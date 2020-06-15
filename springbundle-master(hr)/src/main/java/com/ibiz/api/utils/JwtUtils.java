package com.ibiz.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtils {
/*
    private static String SECRET_KEY = "INZENT.IBIZ.SERVICE.API.SECRETKEY.RC3FE82MCLD2F2JK"; // 추후 Redis
    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private static byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    private static Key key = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
*/
    private static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private static byte[] secretKeyBytes;
    private static Key key;

    private static void initKeySpec(String secretKey) {
        secretKeyBytes = DatatypeConverter.parseBase64Binary(secretKey);
        key = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

    }

    public static String generateAccessToken(String secretKey) {
        initKeySpec(secretKey);

        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject("iBiz-API")
                .claim("clientId", "iBiz-Web")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3650))
                .signWith(key, signatureAlgorithm)
                .compact();

        return jwt;
    }

    public static Boolean checkAccessToken(String jwt, String secretKey) throws ExpiredJwtException {
        initKeySpec(secretKey);
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();

        return claims.get("clientId").equals("iBiz-Web");
    }


}
