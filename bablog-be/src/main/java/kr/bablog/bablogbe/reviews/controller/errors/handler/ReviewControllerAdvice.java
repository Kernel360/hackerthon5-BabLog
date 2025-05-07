package kr.bablog.bablogbe.reviews.controller.errors.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewException;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ReviewControllerAdvice {

	@ExceptionHandler(ReviewException.class)
	public ResponseEntity<ApiResponse<?>> handleReviewException(final ReviewException exception) {
		final ReviewErrorType errorType = exception.getErrorType();
		return ResponseEntity.badRequest()
			.body(ApiResponse.error(errorType.getErrorCode().name(), errorType.getMessage()));
	}
}
