package chunbao.nl.event.service;

import chunbao.nl.event.gui.model.MyUser;

public interface UserService {
  MyUser findByUsername(String username);
}