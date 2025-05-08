package kr.bablog.bablogbe.reviews.service.errors.exception;

import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import lombok.Getter;

@Getter
public class ReviewCommentEmptyException extends ReviewException {
	public ReviewCommentEmptyException(final ReviewErrorType errorType) {
		super(errorType);
	}
}
