package pl.sda.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.exceptions.WebApplicationException;
import pl.sda.springmvc.component.ShoppingCart;

import java.security.Principal;

@Controller
public class ShopCartController {

    private final ShoppingCart shoppingCart;

    public ShopCartController(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @GetMapping("/shopcart")
    public ModelAndView showShopCart(ModelAndView modelAndView) {
        modelAndView.addObject("products", shoppingCart.getProducts());
        modelAndView.setViewName("/shopCart");
        return modelAndView;
    }

    @RequestMapping("/shopcart/addproduct/{idProduct}")
    public ModelAndView addProductToShopCart(ModelAndView modelAndView, @PathVariable Long idProduct) throws WebApplicationException {
        shoppingCart.addProduct(idProduct);
        modelAndView.addObject("products", shoppingCart.getProducts());
        modelAndView.setViewName("redirect:/shopcart");
        return modelAndView;
    }

    @RequestMapping("/shopcart/placeorder")
    public ModelAndView placeOrder(Principal principal, ModelAndView modelAndView) throws WebApplicationException {
        shoppingCart.placeOrder(principal.getName());
        modelAndView.setViewName("redirect:/shopcart");
        return modelAndView;
    }

}
