package kr.bablog.bablogbe.authentication.interceptor;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bablog.bablogbe.authentication.dto.LoginUser;
import kr.bablog.bablogbe.users.service.UserService;
import kr.bablog.bablogbe.users.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

	private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
	private static final String BEARER = "Bearer";

	private final JwtTokenUtil jwtTokenUtil;
	private final UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			final String accessToken = extractAccessToken(request);

			final Claims claims = jwtTokenUtil.extractClaims(accessToken);
			final Integer userId = (Integer) claims.get("userId");
			final String email = (String)claims.get("email");

			if (!userService.existByEmail(email)) {
				return false; // TODO 사용자 미존재 예외 만들기
			}

			final LoginUser loginUser = new LoginUser(userId.longValue(), email);
			request.setAttribute("loginUser", loginUser);

		} catch (ExpiredJwtException exception) { // TODO 만료된 토큰에 관한 재발급 로직 추가 필요
			logWarn(exception);
		} catch (RuntimeException runtimeException) {
			logWarn(runtimeException);
		}

		return true;
	}

	private static String extractAccessToken(final HttpServletRequest request) {
		final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER_NAME);
		final String[] splitHeader = authorizationHeader.split(" ");
		final String headerType = splitHeader[0];

		// TODO custom exception 추가하기
		if (!BEARER.equals(headerType) || splitHeader.length != 2) {
			throw new IllegalArgumentException("올바른 인증 토큰이 아닙니다.");
		}

		return splitHeader[1];
	}

	private static void logWarn(final RuntimeException exception) {
		log.warn("exception type: {}, message: {}", exception.getClass(),
			Arrays.toString(exception.getStackTrace()));
	}
}
