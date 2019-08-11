package pl.sda.springmvc.repositories;

import pl.sda.springmvc.dto.ProductDTO;

import java.util.List;

public interface ProductRepository {

    List<ProductDTO> findAllProducts();

}
