package kr.bablog.bablogbe.reviews.service.dto.request;

public record ReviewCreateServiceRequest(Long postId, Long userId, String comment, boolean reviewLike) {
}
