package kr.bablog.bablogbe.reviews.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class ReviewCommentUpdateWebRequest {
	private final Long reviewId;
	private final String comment;
}
