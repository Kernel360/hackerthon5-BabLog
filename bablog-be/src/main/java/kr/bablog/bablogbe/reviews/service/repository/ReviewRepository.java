package kr.bablog.bablogbe.reviews.service.repository;

import java.util.List;
import java.util.Optional;

import kr.bablog.bablogbe.reviews.domain.Review;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponse;

public interface ReviewRepository {
	boolean existByPostIdAndUserId(Long postId, Long userId);
	ReviewCreateServiceResponse save(ReviewCreateServiceRequest reviewCreateServiceRequest);
	Optional<Review> findEntityById(Long reviewId);
	List<ReviewLookupResponse> findPagedReviewsByPostId(Long postId, int offset, int limit);
	Long countReviewByPostId(Long postId);
	Long countReviewLikeByPostId(Long postId);
}
