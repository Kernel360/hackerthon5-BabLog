package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewInvalidDeleteException extends ReviewException {
	public ReviewInvalidDeleteException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
