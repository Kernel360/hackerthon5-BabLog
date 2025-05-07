package kr.bablog.bablogbe.reviews.service.dto.response;

public record ReviewLookupResponse(Long reviewId, String comment, Long userId, boolean like) {
}
