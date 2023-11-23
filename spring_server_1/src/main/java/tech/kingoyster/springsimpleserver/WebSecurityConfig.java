//package tech.kingoyster.springsimpleserver;
//
//import com.upskills.reconv2.securities.services.AuthEntryPointJwt;
//import com.upskills.reconv2.securities.services.AuthTokenFilter;
//import com.upskills.reconv2.securities.services.UserDetailsSecurityServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
////@EnableSwagger2
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserDetailsSecurityServiceImpl userDetailsService;
//
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
//        throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService)
//            .passwordEncoder(passwordEncoder());
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors()
//            .configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
//            .and()
//            .csrf().disable()
//            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .authorizeRequests()
//            .antMatchers("/ws/**").authenticated()
//            .antMatchers("/auth/signin").permitAll()
//            .antMatchers("/api/**").authenticated()
//            .anyRequest().permitAll();
//        http.addFilterBefore(authenticationJwtTokenFilter(),
//                             UsernamePasswordAuthenticationFilter.class);
//
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//            .select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build();
//    }
//
//    @Bean(name = "db1")
//    @Primary
//    @LiquibaseDataSource
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate jdbcTemplate(@Qualifier("db1") DataSource ds) {
//        return new JdbcTemplate(ds);
//    }
//
//    @Bean(name = "db2")
//    @ConfigurationProperties(prefix = "spring.ag-grid-db")
//    public DataSource dataSource2() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "jdbcTemplate2")
//    public JdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds) {
//        return new JdbcTemplate(ds);
//    }
//}
