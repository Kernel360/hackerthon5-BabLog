package kr.bablog.bablogbe.reviews.service.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorType {
	USER_REVIEW_EXIST(ReviewErrorCode.ERROR_REVIEW01, "기존 사용자가 해당 리뷰를 작성하였습니다."),
	REVIEW_CREATE_CONSTRAINT(ReviewErrorCode.ERROR_REVIEW02, "리뷰 생성에 있어 문제가 발생하였습니다."),
	REVIEW_NOT_FOUND(ReviewErrorCode.ERROR_REVIEW03, "리뷰가 존재하지 않습니다"),
	REVIEW_COMMENT_EMPTY(ReviewErrorCode.ERROR_REVIEW04, "리뷰 코멘트가 비어있습니다.");

	private final ReviewErrorCode errorCode;
	private final String message;
}
