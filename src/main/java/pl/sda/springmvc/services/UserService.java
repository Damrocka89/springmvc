package pl.sda.springmvc.services;

import pl.sda.springmvc.dto.RegistrationFormDTO;
import pl.sda.springmvc.exceptions.AlreadyExistingUserException;

public interface UserService {

    void addUser(RegistrationFormDTO registrationFormDTO) throws AlreadyExistingUserException;
}
