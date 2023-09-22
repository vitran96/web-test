package tech.kingoyster.springsimpleserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;

@Configuration
@EnableWebMvc
public class WebConf implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173");
    }

    // We can either use this or
    // add spring.servlet.path=/api to application.properties
    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    // configurer.addPathPrefix(
    // "/api",
    // HandlerTypePredicate.forBasePackage("tech.kingoyster.springsimpleserver"));
    // }

}
