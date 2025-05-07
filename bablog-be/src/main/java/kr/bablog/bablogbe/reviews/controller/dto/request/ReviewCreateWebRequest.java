package kr.bablog.bablogbe.reviews.controller.dto.request;

import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class ReviewCreateWebRequest {
	private final Long postId;
	private final Long userId;
	private final String comment;
	private final boolean reviewLike;

	public ReviewCreateServiceRequest toServiceRequest() {
		return new ReviewCreateServiceRequest(postId, userId, comment, reviewLike);
	}
}
