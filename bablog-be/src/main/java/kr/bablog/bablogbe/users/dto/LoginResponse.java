package kr.bablog.bablogbe.users.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {

    private String email;
    private String password;
}
