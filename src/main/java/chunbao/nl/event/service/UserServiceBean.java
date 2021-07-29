package chunbao.nl.event.service;

import chunbao.nl.event.gui.model.User;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceBean implements UserService {

  @Override
  public boolean existUser(User user) {
    return false;
  }
}
