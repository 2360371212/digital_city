package org.digitalcity.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.digitalcity.common.enu.ErrorCodeEnum;
import org.digitalcity.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/29
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!StringUtils.hasLength(token)) {
            throw new BusinessException(ErrorCodeEnum.USER_UN_AUTH);
        }
        String uToken = redisTemplate.opsForValue().get("token:" + token);
        if (uToken == null) {
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }
        return true;
    }
}
