package kr.bablog.bablogbe.users.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.users.controller.dto.request.UserCreateWebRequest;
import kr.bablog.bablogbe.users.controller.dto.request.UserLoginWebRequest;
import kr.bablog.bablogbe.users.controller.dto.response.LoginResponse;
import kr.bablog.bablogbe.users.service.UserService;
import kr.bablog.bablogbe.users.service.dto.response.LoginSuccessResponse;
import kr.bablog.bablogbe.users.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;
	private final JwtTokenUtil jwtTokenUtil;

	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<Void>> signup(@RequestBody final UserCreateWebRequest userCreateWebRequest) {
		userService.createUser(userCreateWebRequest.getEmail(), userCreateWebRequest.getPassword());
		return ResponseEntity.ok(ApiResponse.success(null));
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody UserLoginWebRequest userLoginWebRequest) {
		final LoginSuccessResponse loginSuccessResponse = userService.login(userLoginWebRequest.getEmail(),
			userLoginWebRequest.getPassword());

		String accessToken = jwtTokenUtil.createToken(loginSuccessResponse.id(), loginSuccessResponse.email());
		LoginResponse loginResponse = new LoginResponse(accessToken);

		return ResponseEntity.ok(ApiResponse.success(loginResponse));
	}

	// 로그아웃
	@PostMapping("/logout")
	public String logout() {
		return "로그아웃 되었습니다.";
	}
}
