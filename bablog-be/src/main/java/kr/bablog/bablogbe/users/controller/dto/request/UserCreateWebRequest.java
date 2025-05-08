package kr.bablog.bablogbe.users.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class UserCreateWebRequest {
	private final String email;
	private final String password;
}
