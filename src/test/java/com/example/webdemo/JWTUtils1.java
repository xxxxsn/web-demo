//package com.example.webdemo;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
//import java.security.Key;
//import java.util.Date;
//
//public class JWTUtils1 {
//
//    // 签名算法
//    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
//
//    // 过期时间，单位毫秒
//    private static final long EXPIRATION_TIME = 86400000; // 1天
//
//    // 密钥
//    private static final Key SECRET_KEY = Keys.secretKeyFor(SIGNATURE_ALGORITHM);
//
//    /**
//     * 生成JWT token
//     *
//     * @param subject 主题（一般为用户ID）
//     * @return JWT token
//     */
//    public static String generateToken(String subject) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
//
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(SECRET_KEY, SIGNATURE_ALGORITHM)
//                .compact();
//    }
//
//    /**
//     * 验证JWT token，并返回其包含的主题信息
//     *
//     * @param token JWT token
//     * @return 主题信息
//     * @throws Exception 如果token无效或已过期，则抛出异常
//     */
//    public static String validateTokenAndGetSubject(String token) throws Exception {
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        // 验证token是否过期
//        if (claims.getExpiration().before(new Date())) {
//            throw new Exception("Token已过期");
//        }
//
//        return claims.getSubject();
//    }
//}
