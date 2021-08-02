package chunbao.nl.event.gui.mock;

import chunbao.nl.event.module.GuiUser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {
  private Map<String, GuiUser> users = new HashMap<>();

  public GuiUser findUser(String username) {
    return users.get(username);
  }

  public void addUser(GuiUser myUser) {
    users.put(myUser.getUsername(), myUser);
  }

  public void deleteUser(String username) {
    users.remove(username);
  }
}
