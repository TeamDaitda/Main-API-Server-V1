package com.daitda.backend.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(tokenRequired)")
    public void authenticateWithToken(TokenRequired tokenRequired) {
        ServletRequestAttributes requestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttribute.getRequest();

        //  request header에 있는 토큰 체크하기
        String token = request.getHeader("token");
        if(ObjectUtils.isEmpty(token)) {
            throw new IllegalArgumentException("token is empty");
        }
        Claims claims = Jwts.parser().setSigningKey(
                DatatypeConverter.parseBase64Binary(
                        SecurityServiceImpl.SECRET_KEY))
                .parseClaimsJws(token).getBody();
        if (claims == null || claims.getSubject() == null) {
            throw new IllegalArgumentException("Token Error!! Claims are null!!");
        }

        System.out.println("토큰의 Subject로 자체 인증해주세요.");
    }
}
