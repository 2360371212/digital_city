package org.digitalcity.jwt.code;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

public enum JWTResponseType {
    SUCCESS(HttpServletResponse.SC_OK, "服务正常访问"),
    TOKEN_NULL(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "token信息不存在"),
    TOKEN_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "token信息无法验证"),
    TOKEN_TIME_OUT(HttpServletResponse.SC_BAD_REQUEST, "token失效");
    @Getter
    private int code;
    @Getter
    private String msg;

    private JWTResponseType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"code\":" + this.code + ",\"msg\":" + this.msg + "}";
    }
}
