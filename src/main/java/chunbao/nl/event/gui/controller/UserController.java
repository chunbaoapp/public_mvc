package chunbao.nl.event.gui.controller;

import chunbao.nl.event.gui.auth.AuthenticationUtil;
import chunbao.nl.event.gui.model.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/hello")
  public String hello(Model model) {
    model.addAttribute("username", AuthenticationUtil.getAuthenticatedPrincipal());
    return "hello";
  }

  @GetMapping("/register")
  public String registerPage(Model model) {
    model.addAttribute("myUser", new MyUser("username", "password"));
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute MyUser myUser) {
    return "login";
  }
}
