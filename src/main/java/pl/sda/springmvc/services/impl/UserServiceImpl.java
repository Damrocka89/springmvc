package pl.sda.springmvc.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.dto.RegistrationFormDTO;
import pl.sda.springmvc.entities.RoleEntity;
import pl.sda.springmvc.entities.UserEntity;
import pl.sda.springmvc.exceptions.AlreadyExistingUserException;
import pl.sda.springmvc.repositories.RoleCrudRepository;
import pl.sda.springmvc.repositories.UserCrudRepository;
import pl.sda.springmvc.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserCrudRepository userCrudRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleCrudRepository roleCrudRepository;

    public UserServiceImpl(UserCrudRepository userCrudRepository, PasswordEncoder passwordEncoder, RoleCrudRepository roleCrudRepository) {
        this.userCrudRepository = userCrudRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleCrudRepository = roleCrudRepository;
    }

    @Override
    public void addUser(RegistrationFormDTO registrationFormDTO) throws Exception {
        UserEntity userEntity = UserEntity.builder()
                .password(passwordEncoder.encode(registrationFormDTO.getPassword()))
                .login(registrationFormDTO.getLogin())
                .build();
        Optional<RoleEntity> optionalRoleEntity;
        if (registrationFormDTO.getLogin().equals("ADMIN")) {
            optionalRoleEntity = roleCrudRepository.findByName("ADMIN");
        } else {
            optionalRoleEntity = roleCrudRepository.findByName("USER");
        }
        RoleEntity roleEntity = optionalRoleEntity.orElseThrow(() -> new Exception("Role not found"));
        userEntity.getRoles().add(roleEntity);
        userCrudRepository.save(userEntity);
    }
}
