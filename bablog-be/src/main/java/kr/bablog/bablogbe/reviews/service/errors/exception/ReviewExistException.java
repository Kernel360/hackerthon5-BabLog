package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewExistException extends ReviewException {
	public ReviewExistException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
