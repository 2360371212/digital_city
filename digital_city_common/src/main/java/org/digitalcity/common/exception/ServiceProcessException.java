package org.digitalcity.common.exception;

/**
 * Description: 业务处理异常
 *
 * @author xupengxin
 * @date 2024/1/22
 */
public class ServiceProcessException extends RuntimeException {
    public ServiceProcessException(String messsage) {
        super(messsage);
    }
    public ServiceProcessException(String message, Throwable cause) {
        super(message, cause);
    }
}