package org.digitalcity.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("jacob.security.config.jwt")
public class JWTConfigProperties {
    private String signature;  // 保存签名信息
    private String issuer;  // 签发者信息
    private String secret;   // 密钥
    private long expire;  // 过期时间（单位：秒）
}
