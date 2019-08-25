package pl.sda.springmvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginFormDTO {

    private String login;
    private String password;


}
