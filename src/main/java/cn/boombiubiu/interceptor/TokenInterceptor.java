package cn.boombiubiu.interceptor;

import cn.boombiubiu.exception.TokenExpiredException;
import cn.boombiubiu.exception.TokenInvalidException;
import cn.boombiubiu.exception.TokenNotFoundException;
import cn.boombiubiu.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.expired-time}")
    private long jwtExpiredTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new TokenNotFoundException("TOKEN_NOT_FOUND");
        }
        Optional<Claims> obj = Optional.ofNullable(jwtUtils.verifyJwt(token));
        if (!obj.isPresent()) {
            throw new TokenInvalidException("TOKEN_INVALID");
        }
        Claims claims = obj.get();
        if (System.currentTimeMillis() < claims.getIssuedAt().getTime() + jwtExpiredTime) {
            return true;
        } else {
            throw new TokenExpiredException("TOKEN_EXPIRED");
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
