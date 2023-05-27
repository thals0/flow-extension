package com.flow.extension.domain.extension.service;

import com.flow.extension.domain.extension.entity.Extension;
import com.flow.extension.domain.extension.repository.ExtensionRepository;
import com.flow.extension.global.exception.GlobalErrorCode;
import com.flow.extension.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExtensionService {
    private final ExtensionRepository extensionRepository;

    @Transactional
    public Extension getCheckedExtension(String name){
        return extensionRepository.findByExtensionNameAndChecked(name, true);
    }
}
