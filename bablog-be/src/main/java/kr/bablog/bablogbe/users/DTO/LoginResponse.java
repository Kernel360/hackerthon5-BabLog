package kr.bablog.bablogbe.users.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {

    private String email;
    private String password;
}
