package chunbao.nl.event.gui.controller;

import chunbao.nl.event.gui.auth.AuthenticationUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
