package com.zohn.springboot01.xdvideo.utils;

import com.zohn.springboot01.xdvideo.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Description JWT 工具类
 * @Author zohn
 * @Date 2020/2/2 10:53
 * @Param
 * @Return
 */
public class JwtUtils {

    public static final String SUBJECT = "xdclass";

    /**
     * 过期时间
     */
    public static final Long EXPIRE = 1000L * 60 * 60 * 24 * 7;

    public static final String APPSECRET = "xd20200202";

    /**
     * @Description 生成jwt
     * @Author zohn
     * @Date 2020/2/2 11:12
     * @Param [user]
     * @Return java.lang.String
     */
    public static String geneJsonWebToken(User user){
        if (user == null || com.zohn.springboot01.xdvideo.utils.StringHelper.isEmpty(user.getId() + "")
                || com.zohn.springboot01.xdvideo.utils.StringHelper.isEmpty(user.getName())
                || com.zohn.springboot01.xdvideo.utils.StringHelper.isEmpty(user.getHeadImg())){
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getName())
                .claim("headimg", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
        return token;
    }

    /**
     * @Description 校验token
     * @Author zohn
     * @Date 2020/2/2 11:14
     * @Param [token]
     * @Return io.jsonwebtoken.Claims
     */
    public static Claims checkJWT(String token){
        try {
            final Claims body = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token)
                    .getBody();
            return body;
        } catch (Exception e){
            return null;
        }
    }
}
