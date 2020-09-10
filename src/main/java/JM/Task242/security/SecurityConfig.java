//package JM.Task242.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final UserDetailsService userDetailsService; // сервис, с помощью которого тащим пользователя
//    private final SuccessUserHandler successUserHandler; // класс, в котором описана логика перенаправления пользователей по ролям
//
//    public SecurityConfig(@Qualifier("userServiceImpl") UserDetailsService userDetailsService, SuccessUserHandler successUserHandler) {
//        this.userDetailsService = userDetailsService;
//        this.successUserHandler = successUserHandler;
//    }
//
//    @Autowired
//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); // конфигурация для прохождения аутентификации
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//        .authorizeRequests()
//                .antMatchers("/","/login","/index").permitAll()
//                .antMatchers("/user").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
//                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//                .and().formLogin()
//                // Spring сам подставит свою логин форму
//                .successHandler(successUserHandler)
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
//        // http.csrf().disable(); - попробуйте выяснить сами, что это даёт
////        http.authorizeRequests()
////                .antMatchers("/admin").hasRole("ADMIN")
////                .antMatchers("/user").hasAnyRole("ROLE_USER", "ROLE_ADMIN")
////                .antMatchers("/","/login")
////                .permitAll() // доступность всем
////
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .successHandler(successUserHandler); // подключаем наш SuccessHandler для перенеправления по ролям
////
////
//////                .permitAll()// Spring сам подставит свою логин форму
//////                .usernameParameter("j_username")
//////                .passwordParameter("j_password")
////
////
////        http.logout()
////                // разрешаем делать логаут всем
////                .permitAll()
////                // указываем URL логаута
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                // указываем URL при удачном логауте
////                .logoutSuccessUrl("/login?logout")
////                .permitAll()
////                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
////                .and().csrf().disable();
//
////        http
////                // делаем страницу регистрации недоступной для авторизированных пользователей
////                .authorizeRequests();
////                //страницы аутентификаци доступна всем
////                //.antMatchers("/login").anonymous();
////                // защищенные URL
////                //.antMatchers("/hello").access("hasAnyRole('ROLE_ADMIN')").anyRequest().authenticated();
//    }
//
//    // Необходимо для шифрования паролей
//    // В данном примере не используется, отключен
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
