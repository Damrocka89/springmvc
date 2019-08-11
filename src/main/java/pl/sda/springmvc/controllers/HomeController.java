package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    ModelAndView getIndexPage(){
       ModelAndView mnv=new ModelAndView();
       mnv.setViewName("index");
       mnv.addObject("userName", "Ewelina");
       return mnv;
    }

}
