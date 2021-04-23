package com.model.common.aop;

import com.model.common.user.UserThreadLocalDTO;
import com.model.common.utils.json.JsonUtils;
import com.model.common.utils.jwt.JWTUtils;
import com.model.entity.model.Account;
import io.jsonwebtoken.Claims;
import io.swagger.models.auth.In;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Morning JS
 * @date 2021/4/15 18:43
 * @desc 请求Aop
 */
@Aspect
@Component
public class RequestAop {

    private static Integer count = 555;

    @Around("execution (* com.model.controller..*.*(..))")
    public Object beforeCheckToken(ProceedingJoinPoint pro) throws Throwable {

        Object proceed = null;
        try {
            String name = Thread.currentThread().getName();
            System.out.println("thread name is " + name);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            Claims claims = JWTUtils.checkJWT(token);
            Account account = JsonUtils.jsonToBean(claims.get("account").toString(), Account.class);
            account.setId(++count);
            UserThreadLocalDTO.setThreadLocal(account);

            //方法执行完成后执行的方法
            proceed = pro.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            UserThreadLocalDTO.clear();
        }
        return proceed;
    }

}