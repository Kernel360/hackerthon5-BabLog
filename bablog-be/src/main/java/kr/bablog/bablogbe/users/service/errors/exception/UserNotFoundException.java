package kr.bablog.bablogbe.users.service.errors.exception;

import kr.bablog.bablogbe.users.service.errors.UserErrorType;
import lombok.Getter;

@Getter
public class UserNotFoundException extends UserException {
    public UserNotFoundException(UserErrorType errorType) {
        super(errorType);
    }
}
