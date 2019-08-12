package pl.sda.springmvc.services;

import pl.sda.exceptions.WebApplicationException;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.dto.ProductDTO;

import java.util.List;

public interface ProductService {


    void addProduct(NewProductDTO newProduct);
    List<ProductDTO> getAllProducts();
    void remove(Long idProduct);
    ProductDTO getProductById(Long idProduct) throws WebApplicationException;

}
