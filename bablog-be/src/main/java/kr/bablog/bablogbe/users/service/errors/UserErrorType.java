package kr.bablog.bablogbe.users.service.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorType {
	USER_EMAIL_EXIST(UserErrorCode.ERROR_USER01, "기존 이메일로 가입한 사용자가 존재합니다.");

	private final UserErrorCode errorCode;
	private final String message;
}
