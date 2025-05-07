package kr.bablog.bablogbe.reviews.service.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReviewErrorType {
	USER_REVIEW_EXIST(ReviewErrorCode.ERROR_REVIEW01, "기존 사용자가 해당 리뷰를 작성하였습니다."),

	private final ReviewErrorCode errorCode;
	private final String message;
}
