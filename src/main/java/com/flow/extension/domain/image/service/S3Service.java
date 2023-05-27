package com.flow.extension.domain.image.service;

import com.flow.extension.domain.image.entity.S3Image;
import com.flow.extension.domain.image.repository.S3ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class S3Service {
    private final S3ImageRepository s3ImageRepository;

    @Transactional
    public S3Image getS3Image(String uploadFileUrl){
        return s3ImageRepository.findByUploadFileUrl(uploadFileUrl).orElse(null);
    }
}
