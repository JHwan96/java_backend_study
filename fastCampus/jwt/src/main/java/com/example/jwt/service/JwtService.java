package com.example.jwt.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class JwtService {
    private static String secretKey = "javaSpringBootJWTTokenKeyForPractice";
    public String create(Map<String, Object> claims, LocalDateTime expireAt) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        Date _expireAt = Date.from(expireAt.atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(_expireAt)
                .compact();
    }

    public void validation(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());
        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();

        try {
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
            claimsJws.getBody().entrySet().forEach(x -> log.info("key : {}, value : {}", x.getKey(), x.getValue()));
        } catch (Exception e) {
            if(e instanceof SignatureException) {
                throw new RuntimeException("JWT Token Not Valid Exception");
            } else if(e instanceof ExpiredJwtException) {
                throw new RuntimeException("JWT Token Expired Exception");
            } else {
                throw new RuntimeException("JWT Token Validation Exception");
            }
        }

    }
}
