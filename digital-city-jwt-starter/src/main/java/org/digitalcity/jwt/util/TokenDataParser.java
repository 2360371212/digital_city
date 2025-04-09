package org.digitalcity.jwt.util;

import com.alibaba.fastjson2.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import org.digitalcity.jwt.provider.ITokenProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TokenDataParser {
    @Autowired
    private ITokenProvider tokenProvider;


    public Map<String, String> getHeader(String token) {
        JwsHeader header = this.tokenProvider.parseToken(token).getHeader();
        Map<String, String> map = new HashMap<>();
        header.forEach((key, value) -> {
            map.put(key.toString(), value.toString());
        });
        return map;
    }

    public Set<String> getRole(String token) {
        Jws<Claims> claimsJws = this.tokenProvider.parseToken(token);
        String subject = claimsJws.getBody().getSubject();
        Map<String, List<String>> map = JSONObject.parseObject(subject, Map.class);
        Set<String> roles = new HashSet<>();
        roles.addAll(map.get("roles"));
        return roles;
    }

    public Set<String> getAction(String token) {
        Jws<Claims> claimsJws = this.tokenProvider.parseToken(token);
        String subject = claimsJws.getBody().getSubject();
        Map<String, List<String>> map = JSONObject.parseObject(subject, Map.class);
        Set<String> actions = new HashSet<>();
        actions.addAll(map.get("actions"));
        return actions;
    }

    public String getId(String token) {
        return this.tokenProvider.parseToken(token).getBody().getId();
    }

    public Map<String, Object> getSubject(String token) {
        Jws<Claims> claimsJws = this.tokenProvider.parseToken(token);
        String result = claimsJws.getBody().getSubject();
        Map<String, Object> subject = JSONObject.parseObject(result, Map.class);
        return subject;
    }
}

