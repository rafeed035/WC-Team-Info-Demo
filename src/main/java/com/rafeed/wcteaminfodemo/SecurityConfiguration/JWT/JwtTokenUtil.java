package com.rafeed.wcteaminfodemo.SecurityConfiguration.JWT;

import com.rafeed.wcteaminfodemo.Enity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hours

    @Value("${app.jwt.secret}")
    private String secretKey;

    public String generateAccessToken(User user){
        return Jwts.builder()
                .setSubject(user.getUserId() + "," + user.getEmail())
                .setIssuer("Admin")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
