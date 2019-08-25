package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.dto.LoginFormDTO;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView showLoginForm(ModelAndView modelAndView) {
        modelAndView.addObject("loginForm", new LoginFormDTO());
        modelAndView.setViewName("/login");
        return modelAndView;
    }




}
