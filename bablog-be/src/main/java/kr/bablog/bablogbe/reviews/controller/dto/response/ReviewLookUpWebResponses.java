package kr.bablog.bablogbe.reviews.controller.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReviewLookUpWebResponses(
	@JsonProperty("reviews") List<ReviewLookUpWebResponse> reviewLookUpWebResponses, Long reviewCount, Long likeCount) {
}
