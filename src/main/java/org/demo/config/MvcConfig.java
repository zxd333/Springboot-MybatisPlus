package org.demo.config;

import org.demo.util.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 定义排除的接口集合，可以添加排除拦截的接口，示例：excludePath.add("/user/login");
        List<String> excludePath = new ArrayList<>();

        /**
         * addInterceptor：添加拦截器
         * addPathPatterns：添加拦截路径
         * excludePathPatterns：设置排除接口
         */
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
    }

    /**
     * 跨域支持
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        /**
         * addMapping：表示对哪种格式的请求路径进行跨域处理。
         * allowedHeaders：表示允许的请求头，默认允许所有的请求头信息。
         * allowedMethods：表示允许的请求方法，默认是 GET、POST 和 HEAD。这里配置为 * 表示支持所有的请求方法。
         * maxAge：表示探测请求的有效期
         * allowedOrigins 表示支持的域
         */
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }
}
