package kr.bablog.bablogbe.users.service.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorType {
	USER_EMAIL_EXIST(UserErrorCode.ERROR_USER01, "기존 이메일로 가입한 사용자가 존재합니다."),
	USER_NOT_FOUND(UserErrorCode.ERROR_USER02, "유저 이메일을 찾을 수 없습니다."),
	USER_INVALID_PASSWORD(UserErrorCode.ERROR_USER03, "유저 패스워드가 일치하지 않습니다.");

	private final UserErrorCode errorCode;
	private final String message;
}
