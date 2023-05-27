package com.flow.extension.domain.post.service;

import com.flow.extension.domain.image.dto.S3ResponseDto;
import com.flow.extension.domain.post.dto.PostDto;
import com.flow.extension.domain.post.entity.Post;
import com.flow.extension.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void createStudy(PostDto requestDto, S3ResponseDto s3ResponseDto) {
        String s3imageURL = s3ResponseDto.getUploadFileUrl();
        Post post = new Post(requestDto.getTitle(), requestDto.getContent(), s3imageURL);
        postRepository.save(post);
    }
}
