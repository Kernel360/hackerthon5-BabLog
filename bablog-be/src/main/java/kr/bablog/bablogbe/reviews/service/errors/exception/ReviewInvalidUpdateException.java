package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewInvalidUpdateException extends ReviewException {
	public ReviewInvalidUpdateException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
