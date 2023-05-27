package com.flow.extension.domain.extension.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Extension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String extensionName;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ExtensionEnum extensionEnum;

    private boolean checked;

    // 생성자
    public Extension(String name, boolean checked) {
        this.extensionName = name;
        this.checked = checked;
        this.extensionEnum = ExtensionEnum.CUSTOM;
    }
}
