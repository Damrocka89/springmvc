package pl.sda.springmvc.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final Validator newProductValidator;

    @InitBinder
    private void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(newProductValidator);
    }

    public AdminController(ProductService productService, @Qualifier("newProductDTOValidator") Validator newProductValidator) {
        this.productService = productService;
        this.newProductValidator = newProductValidator;
    }

    @RequestMapping
    public ModelAndView getAdminPage() {
        return new ModelAndView("admin/index");
    }

    @RequestMapping("/products")
    public ModelAndView getProductsPage() {
        ModelAndView modelAndView = new ModelAndView("admin/products");
        modelAndView.addObject("newProduct", new NewProductDTO());
        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView addProduct(@ModelAttribute("newProduct")
                                       @Validated NewProductDTO newProductDTO,
                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/products");
        if (bindingResult.hasErrors()) {
            return new ModelAndView("admin/products");
        }
        productService.addProduct(newProductDTO);
        return modelAndView;
    }
}
