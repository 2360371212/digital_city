package org.digitalcity.jwt.autoconfig;


import org.digitalcity.jwt.config.EncryptConfigProperties;
import org.digitalcity.jwt.config.JWTConfigProperties;
import org.digitalcity.jwt.provider.IEncryptProvider;
import org.digitalcity.jwt.provider.ITokenProvider;
import org.digitalcity.jwt.provider.impl.EncryptProvider;
import org.digitalcity.jwt.provider.impl.TokenProvider;
import org.digitalcity.jwt.util.TokenDataParser;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:自动装配类
 */
@Configuration
@EnableConfigurationProperties({JWTConfigProperties.class, EncryptConfigProperties.class})
public class JWTAutoConfiguration {
    // token服务提供
    @Bean("tokenProvider")
    public ITokenProvider tokenProvider() {
        return new TokenProvider();
    }

    // 加密服务提供
    @Bean
    public IEncryptProvider encryptProvider() {
        return new EncryptProvider();
    }

    // 注入token的解析器
    @Bean
    public TokenDataParser tokenParser() {
        return new TokenDataParser();
    }
}
