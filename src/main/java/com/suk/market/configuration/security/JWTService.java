package com.suk.market.configuration.security;

import com.suk.market.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService
{
    @Value("${online_market.security.jwt.key}")
    private String key;

    public String generateToken(User user){
        String jwt= Jwts.builder()
            .setIssuer("online-marketing")
            .setIssuedAt(new Date())
            .claim("username",user.getUsername())
            .claim("role","user")
            .signWith(SignatureAlgorithm.HS256,key.getBytes())
            .compact();
        return jwt;
    }
}
