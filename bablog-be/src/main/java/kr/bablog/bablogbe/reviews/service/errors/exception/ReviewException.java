package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public abstract class ReviewException extends RuntimeException {
	private final ReviewErrorType errorType;

	public ReviewException(final ReviewErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
}
