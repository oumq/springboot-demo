package cn.boombiubiu.config;

import cn.boombiubiu.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Value("${jwt.exclude-path}")
    private String excludePathListStr;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePathList = Arrays.asList(excludePathListStr.split("\\|"));
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathList);
    }
}
