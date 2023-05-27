package com.flow.extension.domain.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column
    private String imageURL;

    public Post(String title, String content, String imageURL) {
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }
}
