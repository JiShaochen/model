package com.model.common.utils.jwt;

import com.model.common.utils.json.JsonUtils;
import com.model.entity.model.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JWTUtils {

    /**
     * 声明过期时间  毫秒   两个小时
     */
    private static final long EXPIRE = 60000 * 60 * 2;

    /**
     * 加密的公用密钥
     */
    private static final String SECRET = "chenerhao";

    /**
     * 颁布者
     */
    private static final String SUBJECT = "Morning JC";

    /**
     * 加密生成jwt令牌
     */
    public static String geneJsonWebToken(Account account){
        return Jwts.builder().setSubject(SUBJECT)    //设置住体（颁布者）
                .claim("id",account.getId()) //设置荷载
                .setIssuedAt(new Date())//设置生成时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//设置过期时间
                .signWith(SignatureAlgorithm.HS256,SECRET)//使用HS256算法，加密密钥
                .compact();//生成最终的token令牌
    }

    /**
     * 解密token
     */
    public static Claims checkJWT(String token){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        }catch (Exception e){
            //当出现任何的异常，都代表此token解析失败，不是正常的token
            return null;
        }
    }

}

