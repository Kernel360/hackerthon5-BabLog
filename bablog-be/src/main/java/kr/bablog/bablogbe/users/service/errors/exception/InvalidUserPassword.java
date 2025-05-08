package kr.bablog.bablogbe.users.service.errors.exception;

import kr.bablog.bablogbe.users.service.errors.UserErrorType;
import lombok.Getter;

@Getter
public class InvalidUserPassword extends UserException {
    public InvalidUserPassword(UserErrorType errorType) {
        super(errorType);
    }
}
