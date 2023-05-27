package com.flow.extension.global.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode {
    // 400 BAD_REQUEST - 잘못된 요청
    NOT_VALID_EXTENSION_LENGTH(BAD_REQUEST, "확장자 이름은 최대 20자를 초과할 수 없습니다."),
    DUPLICATE_EXTENSION_NAME(BAD_REQUEST, "이미 존재하는 확장자 이름입니다."),
    MAXIMUM_EXTENSION_LIMIT(BAD_REQUEST, "커스텀 확장자는 최대 200개까지 추가가 가능합니다."),
    NOT_VALID_IMAGE(BAD_REQUEST, "제한된 파일 확장자입니다."),

    // 401 Unauthorized - 권한 없음

    // 404 Not Found - 찾을 수 없음
    NOT_FOUND_EXTENSION(NOT_FOUND, "확장자를 찾을 수 없습니다."),
    // 409 CONFLICT : Resource 를 찾을 수 없음

    NOT_FOUND_IMAGE(NOT_FOUND, "등록된 이미지가 없습니다");

    private final HttpStatus httpStatus;
    private final String message;
}
