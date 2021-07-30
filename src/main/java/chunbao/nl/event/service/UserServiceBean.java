package chunbao.nl.event.service;

import chunbao.nl.event.gui.model.MyUser;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceBean implements UserService {

  @Override
  public MyUser findByUsername(String username) {
    MyUser myUser = new MyUser();
    myUser.setUsername(username);
    myUser.setPassword(username);
    return new MyUser();
  }
}
