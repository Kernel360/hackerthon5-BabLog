package kr.bablog.bablogbe.users.controller.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginResponse {
    private final String accessToken;
}
