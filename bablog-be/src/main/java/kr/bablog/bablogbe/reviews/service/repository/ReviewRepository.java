package kr.bablog.bablogbe.reviews.service.repository;

import java.util.Optional;

import kr.bablog.bablogbe.reviews.domain.Review;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;

public interface ReviewRepository {
	boolean existByPostIdAndUserId(Long postId, Long userId);
	ReviewCreateServiceResponse save(ReviewCreateServiceRequest reviewCreateServiceRequest);
	Optional<Review> findEntityById(Long reviewId);
}
