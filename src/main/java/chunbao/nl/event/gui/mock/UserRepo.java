package chunbao.nl.event.gui.mock;

import chunbao.nl.event.gui.config.MyConfiguration;
import chunbao.nl.event.json.JsonUtil;
import chunbao.nl.event.module.GuiUser;
import chunbao.nl.event.util.HttpClientUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {
  @Autowired MyConfiguration myConfiguration;
  private Map<String, GuiUser> users = new HashMap<>();

  public GuiUser findUser(String username) {
    try {
      String url = myConfiguration.getReadonlyServerUrl() + "/user-rest/" + username;
      String userStr = HttpClientUtil.getJson(url);
      GuiUser user = JsonUtil.parse(userStr, GuiUser.class);
      return user;
    } catch (IOException e) {
      return null;
    }
  }

  public void addUser(GuiUser myUser) {
    users.put(myUser.getUsername(), myUser);
  }

  public void deleteUser(String username) {
    users.remove(username);
  }
}
