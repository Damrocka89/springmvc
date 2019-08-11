package pl.sda.springmvc.repositories.impl;

import org.springframework.stereotype.Component;
import pl.sda.springmvc.dto.ProductDTO;
import pl.sda.springmvc.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {


    @Override
    public List<ProductDTO> findAllProducts() {
        ProductDTO productDTO1=new ProductDTO(1L, "Prod 1", BigDecimal.valueOf(100));
        ProductDTO productDTO2=new ProductDTO(2L, "Prod 2", BigDecimal.valueOf(50));
        return Arrays.asList(productDTO1, productDTO2);
    }
}
