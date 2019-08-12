package pl.sda.springmvc.services.impl;

import org.springframework.stereotype.Service;
import pl.sda.exceptions.NotFoundProductException;
import pl.sda.exceptions.WebApplicationException;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.entities.ProductEntity;
import pl.sda.springmvc.mapper.ModelMapper;
import pl.sda.springmvc.repositories.ProductRepository;
import pl.sda.springmvc.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(NewProductDTO newProduct) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(newProduct.getName())
                .price(newProduct.getPrice())
                .build();
        productRepository.addProduct(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllProducts().stream()
                .map(ModelMapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long idProduct) {

    }

    @Override
    public ProductDTO getProductById(Long idProduct) throws NotFoundProductException {
        Optional<ProductEntity> productByIdOptional = productRepository.getProductById(idProduct);
        return productByIdOptional
                .map(ModelMapper::mapToProductDTO)
                .orElseThrow(() -> new NotFoundProductException("Not found product with id = " + idProduct));
    }
}
