package chunbao.nl.event.gui.mock;

import chunbao.nl.event.gui.model.MyUser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {
  private Map<String, MyUser> users = new HashMap<>();

  public MyUser findUser(String username) {
    return users.get(username);
  }

  public void addUser(MyUser myUser) {
    users.put(myUser.getUsername(), myUser);
  }

  public void deleteUser(String username) {
    users.remove(username);
  }
}
