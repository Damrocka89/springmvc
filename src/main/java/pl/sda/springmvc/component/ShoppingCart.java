package pl.sda.springmvc.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.springmvc.exceptions.NotFoundUserException;
import pl.sda.springmvc.exceptions.WebApplicationException;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.services.OrderService;
import pl.sda.springmvc.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {

    private final ProductService productService;
    private final OrderService orderService;

    private List<ProductDTO> productDTOS = new ArrayList<>();

    public ShoppingCart(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public List<ProductDTO> getProducts() {
        return productDTOS;
    }

    public void addProduct(Long id) throws WebApplicationException {
        ProductDTO productById = productService.getProductById(id);
        productDTOS.add(productById);
    }

    public void placeOrder(String username) throws NotFoundUserException {
        orderService.placeOrder(username, productDTOS.stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toList()));
        productDTOS.clear();
    }
}
