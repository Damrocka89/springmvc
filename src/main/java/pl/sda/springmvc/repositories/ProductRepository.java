package pl.sda.springmvc.repositories;

import pl.sda.springmvc.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<ProductEntity> findAllProducts();

    void addProduct(ProductEntity productEntity);

    Optional<ProductEntity> getProductById(Long idProducts);

    void removeProductById(Long idProduct);
}
