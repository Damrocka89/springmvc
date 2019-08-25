package pl.sda.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.entities.UserEntity;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<UserEntity, Long> {

        Optional<UserEntity> findByLogin(String login);
        Optional<UserEntity> findById(Long id);
}
