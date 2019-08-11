package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.dto.NewProductDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public ModelAndView getAdminPage(){
        return new ModelAndView("admin/index");
    }

    @RequestMapping("/products")
    public ModelAndView getProductsPage(){
        ModelAndView modelAndView = new ModelAndView("admin/products");
        modelAndView.addObject("newProduct", new NewProductDTO());
        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView addProduct(@ModelAttribute NewProductDTO newProductDTO){
        System.out.println(newProductDTO);
        return new ModelAndView("redirect:/admin/products");
    }
}
