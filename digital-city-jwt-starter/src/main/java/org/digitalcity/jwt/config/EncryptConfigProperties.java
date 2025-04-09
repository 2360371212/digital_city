package org.digitalcity.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "jacob.security.config.password.encrypt")
public class EncryptConfigProperties {
    private Integer repeat; // 加密次数
    private String salt;  // 盐值
}
