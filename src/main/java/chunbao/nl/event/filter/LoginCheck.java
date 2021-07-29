package chunbao.nl.event.filter;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import org.springframework.stereotype.Component;

@Component
public class LoginCheck {
  public boolean hasLogin(String username) {
    return isNotBlank(username);
  }
}
