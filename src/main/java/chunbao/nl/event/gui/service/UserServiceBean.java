package chunbao.nl.event.gui.service;

import chunbao.nl.event.gui.mock.UserRepo;
import chunbao.nl.event.gui.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserService")
public class UserServiceBean implements UserService {

  @Autowired UserRepo userRepos;

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
