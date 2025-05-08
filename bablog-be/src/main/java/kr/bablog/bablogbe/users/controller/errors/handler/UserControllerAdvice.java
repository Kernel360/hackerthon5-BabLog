package kr.bablog.bablogbe.users.controller.errors.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.users.service.errors.UserErrorType;
import kr.bablog.bablogbe.users.service.errors.exception.UserException;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
@Order(Integer.MAX_VALUE - 1)
public class UserControllerAdvice {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ApiResponse<?>> handleReviewException(final UserException exception) {
		final UserErrorType errorType = exception.getErrorType();
		return ResponseEntity.badRequest()
			.body(ApiResponse.error(errorType.getErrorCode().name(), errorType.getMessage()));
	}
}
