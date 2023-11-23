package tech.kingoyster.springsimpleserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
//@EnableWebMvc
@EnableWebSecurity
//public class WebConf implements WebMvcConfigurer {
public class WebConf extends WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //noinspection removal
        httpSecurity.cors()
            .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
            .and()
            .csrf().disable()
            .exceptionHandling().and()
            .authorizeRequests(
                requests ->
                    requests
                        .requestMatchers("/auth/signin").permitAll()
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll() // TODO: does this allow all?
            );
        return httpSecurity.build();
    }

//    @Override
//    public Filter springSecurityFilterChain() throws Exception {
//        return super.springSecurityFilterChain();
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //noinspection removal
//        http.cors()
//            .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
//            .and()
//            .csrf().disable()
//            .exceptionHandling().and()
//            .authorizeRequests(
//                requests ->
//                    requests
//                        .requestMatchers("/auth/signin").permitAll()
//                        .requestMatchers("/api/**").authenticated()
//                        .anyRequest().permitAll() // TODO: does this allow all?
//            );
//    }

    //    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        // Configure allowed origins for the /api/** routes
//        CorsConfiguration apiConfig = new CorsConfiguration();
////        apiConfig.addAllowedOrigin("http://localhost:5173"); // Replace with your allowed origin
////        apiConfig.addAllowedOrigin("http://127.0.0.1:5173"); // Replace with your allowed origin
//        apiConfig.addAllowedOrigin("*"); // Replace with your allowed origin
//        apiConfig.addAllowedMethod("*"); // Allow all HTTP methods for API routes
//        apiConfig.addAllowedHeader("*"); // Allow all headers for API routes
//        apiConfig.addExposedHeader("Access-Control-Allow-Origin"); // Allow CORS headers to be sent back
//        apiConfig.addExposedHeader("Access-Control-Allow-Credentials"); // Allow CORS headers to be sent back
//        apiConfig.setAllowCredentials(false); // Don't allow credentials for API routes
//        source.registerCorsConfiguration("/**", apiConfig);
//
//        // Allow any origin to access static files via GET
////        CorsConfiguration staticFileConfig = new CorsConfiguration();
////        staticFileConfig.addAllowedOrigin("*"); // Allow any origin
////        staticFileConfig.addAllowedMethod("GET");
////        staticFileConfig.addAllowedHeader("*");
////        source.registerCorsConfiguration("/**", staticFileConfig);
//
//        return new CorsFilter(source);
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
////        registry
////            .addMapping("/**")
////            .allowedOrigins("*")
////            .allowedMethods(HttpMethod.GET.toString())
////            .allowedHeaders("*")
////            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
////            .allowCredentials(false)
////            .maxAge(3600);
//
//        registry
//            .addMapping("/**")
////            .addMapping("/api/**") // CORS error??
//            .allowedOrigins("*")
////            .allowedOrigins("http://localhost:5173")
////            .allowedOrigins("http://127.0.0.1:5173")
//            .allowedMethods("*")
//            .allowedHeaders("*")
//            .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//            .allowCredentials(false)
//            .maxAge(3600);
//    }


    // We can either use this or
    // add spring.servlet.path=/api to application.properties
    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    // configurer.addPathPrefix(
    // "/api",
    // HandlerTypePredicate.forBasePackage("tech.kingoyster.springsimpleserver"));
    // }

}
