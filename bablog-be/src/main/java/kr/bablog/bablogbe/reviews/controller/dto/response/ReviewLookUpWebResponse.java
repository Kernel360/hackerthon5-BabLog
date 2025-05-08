package kr.bablog.bablogbe.reviews.controller.dto.response;

import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponse;

public record ReviewLookUpWebResponse(Long reviewId, String comment, String email, boolean like) {
	public static ReviewLookUpWebResponse from(ReviewLookupResponse reviewLookupResponse) {
		return new ReviewLookUpWebResponse(
			reviewLookupResponse.reviewId(),
			reviewLookupResponse.comment(),
			reviewLookupResponse.email(),
			reviewLookupResponse.like());
	}
}
