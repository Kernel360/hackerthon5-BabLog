package kr.bablog.bablogbe.reviews.service.dto.response;

public record ReviewLookupResponse(Long reviewId, String comment, String email, boolean like) {
}
