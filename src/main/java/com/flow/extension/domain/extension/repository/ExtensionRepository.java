package com.flow.extension.domain.extension.repository;

import com.flow.extension.domain.extension.entity.Extension;
import com.flow.extension.domain.extension.entity.ExtensionEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    Extension findByExtensionName(String name);
    Extension findByExtensionNameAndChecked(String name, boolean checked);
    List<Extension> findAllByExtensionEnum(ExtensionEnum extensionEnum);
}
