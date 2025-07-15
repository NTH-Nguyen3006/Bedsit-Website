package com.example.ahihi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfigMVC implements WebMvcConfigurer {

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        // bean.setSuffix(".html");
        // bean.setPrefix("/WEB-INF/view/");
        return bean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**")
                .addResourceLocations("classpath:/static/css");

        registry.addResourceHandler("/bootstrap/**") // Ví dụ: /bootstrap/css/bootstrap.min.css
                .addResourceLocations("classpath:/static/lib/bootstrap-5.3.7-dist/"); // Thư mục gốc chứa Bootstrap

        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/static/images");
    }

}
