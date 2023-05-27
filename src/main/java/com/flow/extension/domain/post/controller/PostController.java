package com.flow.extension.domain.post.controller;

import com.flow.extension.domain.extension.dto.CustomExtensionDTO;
import com.flow.extension.domain.extension.entity.ExtensionEnum;
import com.flow.extension.domain.image.dto.S3ResponseDto;
import com.flow.extension.domain.image.service.S3UploaderService;
import com.flow.extension.domain.post.dto.PostDto;
import com.flow.extension.domain.post.repository.PostRepository;
import com.flow.extension.domain.post.service.PostService;
import com.flow.extension.global.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final S3UploaderService s3UploaderService;

    @GetMapping()
    public String getExtensions() {
        return "post";
    }

    @PostMapping()
    public ResponseEntity createPost(PostDto requestDto){
        S3ResponseDto S3ResponseDto = null;
        if(requestDto.getImage() != null){
            MultipartFile image = requestDto.getImage();
            S3ResponseDto = s3UploaderService.uploadFiles("thumbnail", image);
        }
        postService.createStudy(requestDto, S3ResponseDto);
        return ResponseMessage.SuccessResponse("게시글 작성 성공", "");
    }
}
