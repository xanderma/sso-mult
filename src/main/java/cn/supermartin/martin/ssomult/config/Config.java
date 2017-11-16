package cn.supermartin.martin.ssomult.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author maxiaoding
 * @date 2017/11/12 下午4:32
 * @description:
 */
@Configuration
public class Config extends WebMvcConfigurerAdapter {

    @Resource
    private SessionInterceptor sessionInterceptor;

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/staticFiles", "/login", "/doLogin","/error");
    }
}
