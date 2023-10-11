package com.rafeed.wcteaminfodemo.SecurityConfiguration;

import com.rafeed.wcteaminfodemo.Repository.UserRepository;
import com.rafeed.wcteaminfodemo.SecurityConfiguration.JWT.JwtTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    private UserRepository userRepository;
    private JwtTokenFilter jwtTokenFilter;

    public ApplicationSecurityConfig(UserRepository userRepository,
                                     JwtTokenFilter jwtTokenFilter) {
        this.userRepository = userRepository;
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.getUserByEmailIgnoreCase(username);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement((sessions) -> sessions
                        .requireExplicitAuthenticationStrategy(false)
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        //set unauthorized request exception handler
        http.exceptionHandling((exception)-> exception.authenticationEntryPoint(
                (request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                            authException.getMessage());
                }
        ));

        //set permissions to endpoints
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/login", "/api/v1/user/save" ).permitAll()
                                .anyRequest().authenticated())
                .httpBasic(withDefaults());

        //add JWT token filter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
