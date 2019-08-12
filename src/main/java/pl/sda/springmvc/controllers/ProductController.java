package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.exceptions.WebApplicationException;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("")
    public ModelAndView getProductsPage() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.getAllProducts());
        return modelAndView;
    }

    @RequestMapping("/{idProduct}")
    public ModelAndView getProduct(@PathVariable Long idProduct) throws WebApplicationException {
        ModelAndView modelAndView = new ModelAndView("product");

        ProductDTO productById = productService.getProductById(idProduct);
        modelAndView.addObject("product", productById);

        return modelAndView;
    }


}
