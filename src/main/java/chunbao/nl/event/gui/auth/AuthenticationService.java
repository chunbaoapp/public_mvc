package chunbao.nl.event.gui.auth;

import chunbao.nl.event.gui.model.MyUser;
import chunbao.nl.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

  @Autowired UserService userService;
  @Autowired InMemoryUserDetailsManager inMemoryUserDetailsManager;

  private UserDetails loadUserByUsername(String username) {
    MyUser myUser = userService.findByUsername(username);
    if (myUser == null) {
      throw new UsernameNotFoundException(username);
    }
    UserDetails userDetails =
        User.withDefaultPasswordEncoder()
            .username(myUser.getUsername())
            .password(myUser.getPassword())
            .roles("USER")
            .build();
    return userDetails;
  }

  public void login(MyUser myUser) {
    UserDetails userDetails = loadUserByUsername(myUser.getUsername());
    inMemoryUserDetailsManager.createUser(userDetails);
  }

  public void logout(MyUser myUser) {
    inMemoryUserDetailsManager.deleteUser(myUser.getUsername());
  }
}
