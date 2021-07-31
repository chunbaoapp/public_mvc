package chunbao.nl.event.gui.controller;

import chunbao.nl.event.gui.auth.AuthenticationService;
import chunbao.nl.event.gui.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  @Autowired AuthenticationService authenticationService;

  // root
  @GetMapping(value = "/")
  public String home(Model model) {
    return "index";
  }

  @GetMapping(value = "/login")
  public String getLogin(Model model) {
    model.addAttribute("user", new MyUser("test", "test"));
    model.addAttribute("loginResult", "dd");
    return "login";
  }

  @PostMapping(value = "/login")
  public String login(@ModelAttribute MyUser user, Model model) {
    if (authenticationService.login(user)) {
      model.addAttribute("user", user);
      return "hello";
    } else {
      model.addAttribute("loginResult", "Wrong username or password!");
      return "login";
    }
  }
}
