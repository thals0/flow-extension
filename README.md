# flow-extension
파일확장자에 따라 특정 형식의 파일을 첨부하거나 전송하지 못하도록 제한 과제

### 📑 ERD

<img width="446" alt="image" src="https://github.com/thals0/flow-extension/assets/101865071/a5f08f5a-a82c-4e84-a562-c898df30ea5b">

### 📁 Foldering

```

📁 lablink _ 
           |_ 📁 domain _ 
           |            |_ 📁 extension _
           |                           |_ 📁 controller
           |                           |_ 📁 dto
           |                           |_ 📁 entity
           |                           |_ 📁 exception
           |                           |_ 📁 repository
           |                           |_ 📁 service
           |            |_ 📁 image
           |            |_ 📁 post
           |_ 📁 global _ 
           |            |_ 📁 config
           |            |_ 📁 exception
           |            |_ 📁 message
           |_ 📋 ExtensionApplication

```

###  📌 Dependencies Module
``` java
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.mysql:mysql-connector-j'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.security:spring-security-test'

    // aws-s3 image
    implementation 'org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE'
}
```

### 🔫 Trouble Shooting
- [배포시 "Could not resolve placeholder" 오류 발생](https://thals.tistory.com/196)
