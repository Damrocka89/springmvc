package pl.sda.springmvc.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.springmvc.dto.RegistrationFormDTO;
import pl.sda.springmvc.entities.UserEntity;
import pl.sda.springmvc.exceptions.AlreadyExistingUserException;
import pl.sda.springmvc.repositories.UserCrudRepository;
import pl.sda.springmvc.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserCrudRepository userCrudRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserCrudRepository userCrudRepository, PasswordEncoder passwordEncoder) {
        this.userCrudRepository = userCrudRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addUser(RegistrationFormDTO registrationFormDTO) throws AlreadyExistingUserException {
        UserEntity userEntity = UserEntity.builder()
                .password(passwordEncoder.encode(registrationFormDTO.getPassword()))
                .login(registrationFormDTO.getLogin())
                .build();
            userCrudRepository.save(userEntity);
    }
}
