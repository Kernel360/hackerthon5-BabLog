package kr.bablog.bablogbe.common.api.error.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.bablog.bablogbe.common.api.error.CommonErrorType;
import kr.bablog.bablogbe.common.api.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiResponse<?>> handleException(Exception exception) {
		final CommonErrorType errorType = CommonErrorType.ERROR_UNKNOWN;

		log.error("exception : {}, message : {}\n stackTraces: {}",
			exception.getClass().getSimpleName(),
			exception.getMessage(),
			String.join("\n", getStackTraces(exception)));

		return ResponseEntity.internalServerError()
			.body(ApiResponse.error(errorType.getErrorCode().name(), errorType.getMessage()));
	}

	private List<String> getStackTraces(final Exception exception) {
		return Arrays.stream(exception.getStackTrace())
			.map(StackTraceElement::toString)
			.toList();
	}
}
