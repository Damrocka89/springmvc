package pl.sda.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.sda.springmvc.entities.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();
    void removeProductEntityById(Long id);
    Optional<ProductEntity> findProductEntityById(Long id);
}
