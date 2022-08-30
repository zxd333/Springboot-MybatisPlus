package org.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.demo.entity.User;

import java.util.Date;

public class TokenUtils {

    // 到期时间设置为：30min
    private static final long EXPIRE_TIME = 30*60*1000;

    // 密钥
    private static final String TOKEN_SECRET = "test";

    // 生成 token
    public static String createToken(User user){
        String token = null;

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        token = JWT.create()
                .withClaim("id", user.getId())
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(TOKEN_SECRET));

        return token;
    }

    // 验证 token
    public static Boolean checkToken(String token){
        try {
            JWTVerifier jwt = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
            jwt.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("token 无效，请重新获取");
        }
    }
}
