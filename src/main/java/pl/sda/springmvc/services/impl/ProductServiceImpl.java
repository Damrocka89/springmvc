package pl.sda.springmvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.exceptions.NotFoundProductException;
import pl.sda.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.entities.ProductEntity;
import pl.sda.springmvc.mapper.ModelMapper;
import pl.sda.springmvc.repositories.ProductCrudRepository;
import pl.sda.springmvc.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductCrudRepository productCrudRepository;


    @Override
    public void addProduct(NewProductDTO newProduct) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(newProduct.getName())
                .price(newProduct.getPrice())
                .build();
        productCrudRepository.save(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productCrudRepository.findAll().stream()
                .map(ModelMapper::mapToProductDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long idProduct) {
        productCrudRepository.removeProductEntityById(idProduct);
    }

    @Override
    public ProductDTO getProductById(Long idProduct) throws NotFoundProductException {
        Optional<ProductEntity> productByIdOptional = productCrudRepository.findProductEntityById(idProduct);
        return productByIdOptional
                .map(ModelMapper::mapToProductDTO)
                .orElseThrow(() -> new NotFoundProductException("Not found product with id = " + idProduct));
    }
}
