package kr.bablog.bablogbe.reviews.service.dto.response;

import java.util.List;

public record ReviewLookupResponses(
	List<ReviewLookupResponse> reviewLookupResponses, long reviewCount, long likeCount) {
}
