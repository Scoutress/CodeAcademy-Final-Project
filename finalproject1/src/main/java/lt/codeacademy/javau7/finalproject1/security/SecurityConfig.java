// package lt.codeacademy.javau7.finalproject1.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// @Configuration
// public class SecurityConfig{

//     private final UserDetailsService userDetailsService;

//     public SecurityConfig(UserDetailsService userDetailsService) {
//         this.userDetailsService = userDetailsService;
//     }

//     @Bean
//     public DaoAuthenticationProvider authenticationProvider() {
//         DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//         authProvider.setUserDetailsService(userDetailsService);
//         authProvider.setPasswordEncoder(passwordEncoder());
//         return authProvider;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {

//         http.authorizeHttpRequests(configurer ->
//                         configurer
//                                 .requestMatchers("/public/**").permitAll()
//                                 .requestMatchers("/admin/**").hasRole("ADMIN")
//                                 .requestMatchers("/user/**").hasRole("USER")
//                                 .requestMatchers("/register/**").permitAll()
//                                 .anyRequest().authenticated()
//                 )
//                 .formLogin(form ->
//                         form
//                                 .loginPage("/showMyLoginPage")
//                                 .loginProcessingUrl("/authenticateTheUser")
//                                 .successHandler(customAuthenticationSuccessHandler)
//                                 .permitAll()
//                 )
//                 .logout(logout -> logout
//                                 .permitAll()
//                                 .logoutSuccessUrl("/")
//                 )
//                 .exceptionHandling(configurer -> configurer
//                                 .accessDeniedPage("/access-denied")
//                 );

//         return http.build();
//     }

// }