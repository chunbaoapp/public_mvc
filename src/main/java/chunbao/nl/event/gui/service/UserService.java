package chunbao.nl.event.gui.service;

import chunbao.nl.event.module.GuiUser;

public interface UserService {
  GuiUser findByUsername(String username);

  void addUser(GuiUser myUser);

  void deleteUser(String username);
}
