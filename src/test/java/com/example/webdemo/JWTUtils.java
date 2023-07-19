package com.example.webdemo;

import io.jsonwebtoken.*;

import java.time.Instant;
import java.util.Date;

public class JWTUtils {

    // 签名密钥
    private static final String SECRET = "your_secret_key_here";

    // 过期时间，单位毫秒
    private static final long EXPIRATION_TIME = 24 * 60 * 60 *1000 ; // 1天

    /**
     * 生成JWT token
     *
     * @param subject 主题（一般为用户ID）
     * @return JWT token
     */
    public static String generateToken(String subject) {
        // 设置token过期时间，即当前时间+过期时间
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRATION_TIME);

        // 构建JWT token并返回
        return Jwts.builder()
                .setSubject(subject) // 设置token主题，一般为用户ID等信息
                .setIssuedAt(new Date()) // 设置token签发时间，默认为当前时间
                .setExpiration(expirationDate) // 设置token过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET) // 设置签名算法和密钥
                .compact();
    }


    /**
     * 验证JWT token，并返回其包含的主题信息
     *
     * @param token JWT token
     * @return 主题信息
     * @throws Exception 如果token无效或已过期，则抛出异常
     */
    public static String validateTokenAndGetSubject(String token) throws Exception {
        try {
            // 解析验证token，如果解析失败则抛出异常
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            // 获取token主题信息
            String subject = claims.getSubject();
            // 获取token过期时间，并与当前时间比较，如果过期则抛出异常
            Date expirationDate = claims.getExpiration();
            if (expirationDate.before(new Date())) {
                throw new ExpiredJwtException(null, null,"Token已过期");
            }
            // 验证通过，返回token主题信息
            return subject;
        } catch (ExpiredJwtException e) {
            throw new Exception("Token已过期", e);
        } catch (JwtException e) {
            throw new Exception("无效的Token", e);
        }
    }


        public static void main(String[] args) throws Exception {
            // 生成JWT token
            String userId = "123";
            String token = JWTUtils.generateToken(userId);
            System.out.println("生成的JWT token：" + token);

            // 验证JWT token，并获取其包含的主题信息
            String subject = JWTUtils.validateTokenAndGetSubject(token);
            System.out.println("JWT token验证通过，主题信息为：" + subject);
        }

}
