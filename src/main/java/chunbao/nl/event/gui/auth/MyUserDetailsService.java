package chunbao.nl.event.gui.auth;

import chunbao.nl.event.gui.service.UserService;
import chunbao.nl.event.module.GuiUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

  @Autowired UserService userService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    GuiUser user = userService.findByUsername(userName);
    if (user == null) {
      throw new UsernameNotFoundException(userName);
    }
    List<GrantedAuthority> roles = new ArrayList<>();
    roles.add(new SimpleGrantedAuthority("USER"));
    return new User(user.getUsername(), user.getPassword(), roles);
  }
}
