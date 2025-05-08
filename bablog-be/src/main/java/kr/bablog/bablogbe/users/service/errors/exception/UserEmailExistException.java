package kr.bablog.bablogbe.users.service.errors.exception;

import kr.bablog.bablogbe.users.service.errors.UserErrorType;

public class UserEmailExistException extends UserException {
	public UserEmailExistException(final UserErrorType errorType) {
		super(errorType);
	}
}
