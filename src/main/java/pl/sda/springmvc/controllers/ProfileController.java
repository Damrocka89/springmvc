package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.dto.OrderDTO;
import pl.sda.springmvc.services.OrderService;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    private final OrderService orderService;

    public ProfileController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/profile")
    public ModelAndView showProfile(Principal principal, ModelAndView modelAndView) {
        List<OrderDTO> orders = orderService.findByUserLogin(principal.getName());
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("profile");
        return modelAndView;
    }


}
