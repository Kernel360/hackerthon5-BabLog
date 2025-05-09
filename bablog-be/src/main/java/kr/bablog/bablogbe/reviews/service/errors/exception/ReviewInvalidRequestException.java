package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewInvalidRequestException extends ReviewException {
	public ReviewInvalidRequestException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
