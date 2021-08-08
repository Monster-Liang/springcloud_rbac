package com.rbac.rbacService.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.rbac.rbacService.entity.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author 张高奎
 * @version 1.0
 * @description  token工具类
 */

@Slf4j
public class TokenUtil {
    /*
     * 会话超时时间，默认2小时
     */
    public final static int SESSION_TIMEOUT=2*60*60;
    /*
     *置换保护时间，默认1小时
     */
    public final static int REPLACEMENT_PROTECTION_TIMEOUT=60*60;

    /**
     * 秘钥
     */

    private static final String TOKEN_SECRET = "123456";
    /*
     *旧token延迟过期时间
     */
    private static final String DEFAULT_ISS = "author";
    public final static int REPLACEMENT_DELAY=2*60;
    private TokenUtil() {}
    /**
     * Token 创建Token
     * @param userVO 用户信息
     * @return 带有用户信息的token字符串
     */
    public static String createToken(UserVO userVO){
        String token = null;
        Date expiresAt = new Date(System.currentTimeMillis() + SESSION_TIMEOUT);
        token = JWT.create()
                .withIssuer(DEFAULT_ISS)
                .withClaim("userName", userVO.getUserName())
                .withClaim("password",userVO.getPassword())
                .withExpiresAt(expiresAt)
                .sign((Algorithm.HMAC256(TOKEN_SECRET)));
        return token;
    }
    /**
     * 验证token
     * @param token 从请求头中得到的token字符串
     * @return true验证成功 | false验证失败
     */
    public static boolean verify(String token){
        try{
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(DEFAULT_ISS).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            log.info("验证通过");
            log.info("用户名: " + jwt.getClaim("userName").asString());
            return true;
        }catch (Exception e) {
            return false;
        }

    }
}
