package me.shazxrin.dxctechnicalassessment.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class LocaleWebMvcConfigurer implements WebMvcConfigurer {
    private final LocaleChangeInterceptor localeChangeInterceptor;

    @Autowired
    public LocaleWebMvcConfigurer(LocaleChangeInterceptor localeChangeInterceptor) {
        this.localeChangeInterceptor = localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.localeChangeInterceptor);
    }
}
