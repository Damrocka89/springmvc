package pl.sda.springmvc.services.impl;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.entities.RoleEntity;
import pl.sda.springmvc.repositories.RoleCrudRepository;
import pl.sda.springmvc.services.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleCrudRepository roleCrudRepository;

    public RoleServiceImpl(RoleCrudRepository roleCrudRepository) {
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    public void addRole(RoleEntity roleEntity) {
        roleCrudRepository.save(roleEntity);
    }
}
