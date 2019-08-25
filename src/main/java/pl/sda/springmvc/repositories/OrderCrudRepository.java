package pl.sda.springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sda.springmvc.entities.OrderEntity;

import java.util.List;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Long> {

    List<OrderEntity> findByUserLogin(String login);

}
