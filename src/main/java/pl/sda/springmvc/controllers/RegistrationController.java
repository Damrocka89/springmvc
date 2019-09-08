package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.dto.RegistrationFormDTO;
import pl.sda.springmvc.exceptions.AlreadyExistingUserException;
import pl.sda.springmvc.services.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(ModelAndView model) {
        model.addObject("userForm", new RegistrationFormDTO());
        model.setViewName("/registration");
        return model;
    }

    @PostMapping("/sign-in")
    public ModelAndView registerUser(@ModelAttribute("userForm") RegistrationFormDTO registrationFormDTO, ModelAndView modelAndView) throws Exception {
        userService.addUser(registrationFormDTO);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }


}
