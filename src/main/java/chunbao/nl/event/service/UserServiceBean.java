package chunbao.nl.event.service;

import chunbao.nl.event.gui.mock.UserRepos;
import chunbao.nl.event.gui.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceBean implements UserService {

  @Autowired UserRepos userRepos;

  @Override
  public MyUser findByUsername(String username) {
    return userRepos.findUser(username);
  }

  @Override
  public void addUser(MyUser myUser) {
    userRepos.addUser(myUser);
  }

  @Override
  public void deleteUser(String username) {
    userRepos.deleteUser(username);
  }
}
