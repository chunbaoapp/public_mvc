package chunbao.nl.event.controller;

import chunbao.nl.event.gui.DAO.AlienRepo;
import chunbao.nl.event.gui.model.Alien;
import chunbao.nl.event.gui.model.User;
import chunbao.nl.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

  @Autowired AlienRepo repo;
  @Autowired UserService userService;

  @RequestMapping("/")
  public String home() {
    return "user.jsp";
  }

  @RequestMapping("login")
  public String login(User user) {
    return "user.jsp";
  }

  @RequestMapping("insert")
  public String insert() {
    return "insert.jsp";
  }

  @RequestMapping("view")
  public String view() {
    repo.toString();
    return "view.jsp";
  }

  @RequestMapping("find")
  public String find() {
    //		ModelAndView mv=new ModelAndView();
    //		Optional<Alien> a=repo.findById(id);
    //		mv.addObject("obj",a);
    //		mv.setViewName("find.jsp");
    //
    //		return mv;
    return "enter.jsp";
  }

  @RequestMapping("findById")
  public ModelAndView findbyId(@RequestParam int aid) {
    ModelAndView mv = new ModelAndView("find.jsp");
    Alien alien = repo.findById(aid).orElse(new Alien());
    mv.addObject(alien);
    mv.setViewName("find.jsp");

    return mv;
  }

  @RequestMapping("addAlien")
  public String addAlien(Alien alien) {

    repo.save(alien);
    return "home.jsp";
  }
}
