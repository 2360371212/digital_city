package org.digitalcity.jwt.provider;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;
import java.util.Map;


/**
 * 提供关于token的一系列服务
 *
 * @Author jacob
 * @Date 2023/8/5
 */
public interface ITokenProvider {
    public SecretKey generateKey();

    public String generateToken(String id, Map<String, Object> subject);

    public boolean verifyToken(String token);

    public String refreshToken(String token);

    public Jws<Claims> parseToken(String token);
}
