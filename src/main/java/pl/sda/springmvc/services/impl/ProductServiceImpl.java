package pl.sda.springmvc.services.impl;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.repositories.ProductRepository;
import pl.sda.springmvc.services.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void addProduct(NewProductDTO newProduct) {

    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public void remove(Long idProduct) {

    }
}
