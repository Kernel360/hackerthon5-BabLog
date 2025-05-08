package kr.bablog.bablogbe.reviews.controller.dto.response;

import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewCreateWebResponse {
	private final boolean createSuccess;

	public static ReviewCreateWebResponse from(final ReviewCreateServiceResponse reviewCreateServiceResponse) {
		return new ReviewCreateWebResponse(reviewCreateServiceResponse.createSuccess());
	}
}
