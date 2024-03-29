package pl.sda.springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sda.springmvc.entities.RoleEntity;

import java.util.Optional;

public interface RoleCrudRepository extends CrudRepository<RoleEntity, Long> {
Optional<RoleEntity> findByName(String name);
}
