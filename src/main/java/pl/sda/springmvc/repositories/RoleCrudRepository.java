package pl.sda.springmvc.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sda.springmvc.entities.RoleEntity;

public interface RoleCrudRepository extends CrudRepository<RoleEntity, Long> {

}
