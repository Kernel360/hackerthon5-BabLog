package kr.bablog.bablogbe.reviews.service.dto.request;

public record ReviewCommentUpdateRequest(Long reviewId, String updatedComment) {
}
