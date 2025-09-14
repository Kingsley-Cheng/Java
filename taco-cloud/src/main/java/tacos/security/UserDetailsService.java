package tacos.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// 接受用户名并使用它查找 UserDetails 对象，如果找不到给定用户名的用户，则会抛出UsernameNotFoundException。
public interface UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
