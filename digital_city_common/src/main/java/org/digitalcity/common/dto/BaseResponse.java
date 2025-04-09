package org.digitalcity.common.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/22
 */
@Data
@Builder
public class BaseResponse {
    private Integer code;
    private String msg;
    private Object data;

    public static BaseResponse ok() {
        return BaseResponse.builder().code(HttpStatus.OK.value()).build();
    }

    public static BaseResponse ok(Object data) {
        return BaseResponse.builder().code(HttpStatus.OK.value()).data(data).build();
    }

    public static BaseResponse ok(String message) {
        return BaseResponse.builder().code(HttpStatus.OK.value()).msg(message).build();
    }

    public static BaseResponse ok(String message, Object data) {
        return BaseResponse.builder().code(HttpStatus.OK.value()).data(data).msg(message).build();
    }

    public static BaseResponse error() {
        return BaseResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
    }

    public static BaseResponse error(String message) {
        return BaseResponse.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).msg(message).build();
    }
}