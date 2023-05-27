package com.flow.extension.domain.image.repository;

import com.flow.extension.domain.image.entity.S3Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface S3ImageRepository extends JpaRepository<S3Image,Long> {
    Optional<S3Image> findByUploadFileUrl(String uploadFileUrl);
    S3Image deleteByUploadFileUrl(String uploadFileUrl);
}
