package chunbao.nl.event.gui.controller;

import chunbao.nl.event.gui.auth.AuthenticationUtil;
import chunbao.nl.event.gui.service.UserService;
import chunbao.nl.event.module.GuiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @Autowired UserService userService;

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/login")
  public String getLogin() {
    return "login";
  }

  @GetMapping("/hello")
  public String getHello(Model model) {
    model.addAttribute("username", AuthenticationUtil.getAuthenticatedPrincipal());
    return "hello";
  }

  @GetMapping("/register")
  public String getRegister(Model model) {
    model.addAttribute("guiUser", new GuiUser("username", "password"));
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute GuiUser myUser) {
    userService.addUser(myUser);
    return "login";
  }
}
