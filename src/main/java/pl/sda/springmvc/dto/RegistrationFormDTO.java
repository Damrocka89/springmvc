package pl.sda.springmvc.dto;

import lombok.Data;

@Data
public class RegistrationFormDTO {
    private String login;
    private String password;
    private String repeatedPassword;
}
