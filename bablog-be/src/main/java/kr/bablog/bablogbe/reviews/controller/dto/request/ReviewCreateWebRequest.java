package kr.bablog.bablogbe.reviews.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class ReviewCreateWebRequest {
	private final Long postId;
	private final String comment;
	private final boolean reviewLike;
}
