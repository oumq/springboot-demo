package cn.boombiubiu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class JwtUtils {

    /**
     * jwt 加密解密密钥
     */
    @Value("${jwt.secret}")
    private String jwtSecret;


    /**
     * 由字符串生成加密key
     */
    private SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(jwtSecret);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建JWT
     */
    public String createJwt(Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date signDate = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(signDate)
                .signWith(signatureAlgorithm, secretKey);
        return builder.compact();
    }

    /**
     * 验证jwt
     */
    public Claims verifyJwt(String token) {
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
