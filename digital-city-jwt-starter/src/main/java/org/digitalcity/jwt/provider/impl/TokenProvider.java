package org.digitalcity.jwt.provider.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import io.jsonwebtoken.*;
import org.digitalcity.jwt.config.JWTConfigProperties;
import org.digitalcity.jwt.provider.ITokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenProvider implements ITokenProvider {
    @Autowired
    private JWTConfigProperties jwtConfigProperties;
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public SecretKey generateKey() {
        byte[] bytes = jwtConfigProperties.getSecret().getBytes();
        return new SecretKeySpec(bytes, 0, bytes.length, signatureAlgorithm.getJcaName());
    }

    @Override
    public String generateToken(String id, Map<String, Object> subject) {
        Date expiredate = new Date(new Date().getTime() + jwtConfigProperties.getExpire() * 1000);
        Map<String, Object> header = new HashMap<>();
        header.put("site", "jacob_netdisc");
        Map<String, Object> claims = new HashMap<>();
        claims.put("author", "xupengxin");
        claims.put("name", "jacob");
        claims.put("module", applicationName);
        JwtBuilder builder = Jwts.builder().addClaims(claims).setHeader(header)
                .setSubject(JSON.toJSONString(subject))
                .setExpiration(expiredate).setIssuedAt(new Date())
                .setId(id).setIssuer(jwtConfigProperties.getIssuer())
                .signWith(generateKey(), signatureAlgorithm);
        return builder.compact();
    }

    @Override
    public boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder().requireIssuer(jwtConfigProperties.getIssuer()).setSigningKey(this.generateKey()).build().parse(token).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String refreshToken(String token) {
        if (verifyToken(token)) {
            Jws<Claims> claimsJws = Jwts.parserBuilder().requireIssuer(jwtConfigProperties.getIssuer()).setSigningKey(this.generateKey()).build().parseClaimsJws(token);
            return this.generateToken(claimsJws.getBody().getId(), JSONObject.parseObject(claimsJws.getBody().getSubject(), Map.class));
        }
        return null;
    }

    @Override
    public Jws<Claims> parseToken(String token) {
        if (verifyToken(token)) {
            Jws<Claims> claimsJws = Jwts.parserBuilder().requireIssuer(jwtConfigProperties.getIssuer()).setSigningKey(this.generateKey()).build().parseClaimsJws(token);
            return claimsJws;
        }
        return null;
    }
}
