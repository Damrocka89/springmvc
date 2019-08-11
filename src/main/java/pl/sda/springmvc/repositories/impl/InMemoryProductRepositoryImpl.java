package pl.sda.springmvc.repositories.impl;

import org.springframework.stereotype.Repository;
import pl.sda.springmvc.entities.ProductEntity;
import pl.sda.springmvc.repositories.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {

    private static Map<Long, ProductEntity> repo = new HashMap<>();

    private Long index = 0L;

    @Override
    public List<ProductEntity> findAllProducts() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public void addProduct(ProductEntity productEntity) {
        productEntity.setId(++index);
        repo.put(index, productEntity);
    }

    @Override
    public Optional<ProductEntity> getProductById(Long idProducts) {
        if (repo.containsKey(idProducts)){
            return Optional.of(repo.get(idProducts));
        }
        return Optional.empty();
    }

    @Override
    public void removeProductById(Long idProduct) {
        if (repo.containsKey(idProduct)){
            repo.remove(idProduct);
        }
    }


}
