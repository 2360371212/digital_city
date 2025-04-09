package org.digitalcity.advice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/27
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        HttpServletRequest request = ((ServletRequestAttributes) (Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))).getRequest();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("message", e.getMessage());
        map.put("exception", e.getClass().getName());
        map.put("path", request.getRequestURL());
        log.info("捕获到异常:" + e.getMessage());
        return map;
    }
}
