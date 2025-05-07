package kr.bablog.bablogbe.reviews.controller.dto.response;

import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCommentUpdateResponse;

public record ReviewCommentUpdateWebResponse(Long id, String updatedComment) {

	public static ReviewCommentUpdateWebResponse from(final ReviewCommentUpdateResponse reviewCommentUpdateResponse) {
		return new ReviewCommentUpdateWebResponse(reviewCommentUpdateResponse.id(),
			reviewCommentUpdateResponse.updatedComment());
	}
}
