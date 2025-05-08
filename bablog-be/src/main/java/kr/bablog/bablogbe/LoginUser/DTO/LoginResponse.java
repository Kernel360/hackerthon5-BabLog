package kr.bablog.bablogbe.LoginUser.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {

    private String email;
    private String password;
}
