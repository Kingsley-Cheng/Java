package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import tacos.User;
import tacos.data.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    // 密码加密
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // 应用bcrypt加强哈希加密
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    // 接受 HttpSecurity 对象充当的生成器，用于 web 级别安全配置。一旦安全配置通过HttpSecurity 对象完成设置，调用 build() 方法将创建并返回一个 SecurityFilterChain 对象。
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorize-> authorize.requestMatchers("/design","/orders").hasRole("USER").requestMatchers("/","/**").permitAll());
        // 登录页面路径
        http.formLogin(authorize->authorize.loginPage("/login").defaultSuccessUrl("/design",true));
        http.logout(authorize->authorize.logoutSuccessUrl("/"));
        return http.build();
    }
}
