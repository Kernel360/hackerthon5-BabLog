package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewNotFoundException extends ReviewException{
	public ReviewNotFoundException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
