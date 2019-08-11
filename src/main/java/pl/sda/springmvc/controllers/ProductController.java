package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("")
    public ModelAndView getProductsPage(){
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }




}
