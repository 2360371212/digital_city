package org.digitalcity.manager;

import org.digitalcity.enu.MailTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Duration;

/**
 * Description:
 *
 * @author xupengxin
 * @date 2024/1/23
 */
@Component
public class VerifyCodeManager {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void save(String mail, int type, String code) {
        String key = "verify:" + mail + ":" + type + ":";
        // 验证码时间有效期5分钟
        redisTemplate.opsForValue().set(key, code, Duration.ofMinutes(5L));
    }

    public boolean validate(String mail, int type, String code) {
        String key = "verify:" + mail + ":" + type + ":";
        String target = redisTemplate.opsForValue().get(key);
        return StringUtils.hasLength(target) && target.equals(code);
    }

    public void delete(String mail, int type) {
        String key = "verify:" + mail + ":" + type + ":";
        redisTemplate.delete(key);
    }
}
