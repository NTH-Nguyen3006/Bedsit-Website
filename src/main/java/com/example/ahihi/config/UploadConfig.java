package com.example.ahihi.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.MultipartConfigElement;

@Configuration
public class UploadConfig implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addConnectorCustomizers(connector -> {
            // Other relevant Tomcat settings
            connector.setProperty("maxPostSize", String.valueOf(2L * 1024 * 1024 *
                    1024)); // 2GB
            connector.setProperty("maxSwallowSize", String.valueOf(2L * 1024 * 1024 *
                    1024)); // 2GB
            connector.setMaxPartCount(1000);
            connector.setMaxPostSize(1024 * 1024 * 1024);
        });
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        // Cấu hình số lượng file tối đa
        long maxFileSize = 10 * 1024 * 1024; // 10MB
        long maxRequestSize = 20 * 1024 * 1024; // 20MB
        int maxFileCount = 10; // Đặt số lượng file tối đa là 10

        return new MultipartConfigElement(
                null, // Đường dẫn lưu tạm thời (mặc định)
                maxFileSize,
                maxRequestSize,
                maxFileCount);
    }

}
