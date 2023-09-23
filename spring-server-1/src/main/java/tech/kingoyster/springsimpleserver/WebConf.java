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
        registry
                .addMapping("/**")
                // .addMapping("/api/**") // CORS error??
                .allowedOrigins("*")
                // .allowedOrigins("http://localhost:5173")
                // .allowedOrigins("http://127.0.0.1:5173")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(false)
                .maxAge(3600);
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
