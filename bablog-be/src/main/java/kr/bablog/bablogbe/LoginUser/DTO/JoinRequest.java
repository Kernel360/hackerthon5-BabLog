package kr.bablog.bablogbe.LoginUser.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequest {

    //@NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    //@NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

}
