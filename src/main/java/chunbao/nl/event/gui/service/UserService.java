package chunbao.nl.event.gui.service;

import chunbao.nl.event.gui.model.MyUser;

public interface UserService {
  MyUser findByUsername(String username);

  void addUser(MyUser myUser);

  void deleteUser(String username);
}
