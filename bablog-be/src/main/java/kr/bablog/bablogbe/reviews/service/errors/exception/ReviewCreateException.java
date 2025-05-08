package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;

public class ReviewCreateException extends ReviewException {
	public ReviewCreateException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
