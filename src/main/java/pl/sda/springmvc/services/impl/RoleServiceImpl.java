package pl.sda.springmvc.services.impl;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.entities.RoleEntity;
import pl.sda.springmvc.repositories.RoleCrudRepository;
import pl.sda.springmvc.services.RoleService;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleCrudRepository roleCrudRepository;

    public RoleServiceImpl(RoleCrudRepository roleCrudRepository) {
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    public void addRole(String name) {
        Optional<RoleEntity> optionalRoleEntity = roleCrudRepository.findByName(name);
        if (optionalRoleEntity.isPresent()) {
            return;
        }
        roleCrudRepository.save(RoleEntity.builder().name(name).build());
    }
}
