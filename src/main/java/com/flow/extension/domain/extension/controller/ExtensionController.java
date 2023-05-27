package com.flow.extension.domain.extension.controller;

import com.flow.extension.domain.extension.dto.CustomExtensionDTO;
import com.flow.extension.domain.extension.entity.Extension;
import com.flow.extension.domain.extension.entity.ExtensionEnum;
import com.flow.extension.domain.extension.repository.ExtensionRepository;
import com.flow.extension.global.exception.GlobalErrorCode;
import com.flow.extension.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExtensionController {
    private final ExtensionRepository extensionRepository;

    @GetMapping("/")
    public String getExtensions(Model model) {
        model.addAttribute("fixedExtensions", extensionRepository.findAllByExtensionEnum(ExtensionEnum.DEFAULT));
        model.addAttribute("customExtensionDTO", new CustomExtensionDTO());
        model.addAttribute("customExtensions", extensionRepository.findAllByExtensionEnum(ExtensionEnum.CUSTOM));
        return "index";
    }

    @PostMapping("/extensions/add")
    public String addExtension(@ModelAttribute CustomExtensionDTO form) {
        String extensionName = form.getExtensionName().trim();

        // 최대 길이 검사
        if (extensionName.length() > 20) {
            throw new GlobalException(GlobalErrorCode.NOT_VALID_EXTENSION_LENGTH);
        }

        // 중복 검사
        if (extensionRepository.findByExtensionName(extensionName) != null) {
            throw new GlobalException(GlobalErrorCode.DUPLICATE_EXTENSION_NAME);
        }

        // 최대 개수 검사
        List<Extension> customExtensions = extensionRepository.findAll();
        if (customExtensions.size() >= 207) {
            throw new GlobalException(GlobalErrorCode.MAXIMUM_EXTENSION_LIMIT);
        }

        // DB에 저장
        Extension extension = new Extension(extensionName, true);
        extensionRepository.save(extension);

        return "redirect:/";
    }

    @PostMapping("/extensions/{id}/toggle")
    public String toggleExtension(@PathVariable Long id) {
        Extension extension = extensionRepository.findById(id).orElseThrow(
                () -> new GlobalException(GlobalErrorCode.NOT_FOUND_EXTENSION)
        );

        // check 상태 토글
        extension.setChecked(!extension.isChecked());
        extensionRepository.save(extension);

        return "redirect:/";
    }

    @PostMapping("/extensions/{id}/delete")
    public String deleteExtension(@PathVariable Long id) {
        extensionRepository.deleteById(id);
        return "redirect:/";
    }
}
