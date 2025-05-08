package kr.bablog.bablogbe.users.service.errors.exception;

import kr.bablog.bablogbe.users.service.errors.UserErrorType;
import lombok.Getter;

@Getter
public abstract class UserException extends RuntimeException {
	private final UserErrorType errorType;

	public UserException(final UserErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}
