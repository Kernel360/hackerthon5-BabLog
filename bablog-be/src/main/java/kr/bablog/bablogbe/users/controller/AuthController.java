package kr.bablog.bablogbe.users.controller;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.users.controller.dto.request.UserCreateWebRequest;
import kr.bablog.bablogbe.users.domain.User;
import kr.bablog.bablogbe.users.repository.UserRepository;
import kr.bablog.bablogbe.users.service.UserService;
import kr.bablog.bablogbe.users.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
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
    public String login(@RequestBody User user) {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());

        if (foundUser.isEmpty() || !user.getPassword().equals(foundUser.get().getPassword())) {
            return "로그인 실패: 이메일 또는 비밀번호가 잘못되었습니다.";
        }

        String token = jwtTokenUtil.createToken(user.getEmail());
        return "Bearer " + token;
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout() {
        return "로그아웃 되었습니다.";
    }
}
