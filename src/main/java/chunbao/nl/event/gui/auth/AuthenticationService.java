package chunbao.nl.event.gui.auth;

import chunbao.nl.event.gui.model.MyUser;
import chunbao.nl.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

  @Autowired UserService userService;
  @Autowired MyInMemoryUserDetailsManager myInMemoryUserDetailsManager;

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

  public boolean login(MyUser myUser) {
    UserDetails userDetails = loadUserByUsername(myUser.getUsername());
    if (userDetails != null) {
      myInMemoryUserDetailsManager.createUser(userDetails);
      return true;
    }
    return false;
  }

  public void logout(MyUser myUser) {
    myInMemoryUserDetailsManager.deleteUser(myUser.getUsername());
  }
}
