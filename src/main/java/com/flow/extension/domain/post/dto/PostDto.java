package com.flow.extension.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class PostDto {
    private String title;
    private String content;
    MultipartFile image;
}
