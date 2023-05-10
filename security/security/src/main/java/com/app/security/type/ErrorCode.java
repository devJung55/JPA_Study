package com.app.security.type;

import lombok.Getter;

@Getter
public enum ErrorCode {
    LOGIN_FAILED("AUTH_001", "LOGIN_FAILED.", 401),
    AUTHENTICATION_FAILED("AUTH_002", "AUTHENTICATION_FAILED", 401);

    private final String code;
    private final String message;
    private final int status;

//    필드 초기화
    ErrorCode(final String code, final String message, final int status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
