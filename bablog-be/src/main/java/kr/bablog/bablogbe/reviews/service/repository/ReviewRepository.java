package kr.bablog.bablogbe.reviews.service.repository;

import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;

public interface ReviewRepository {
	boolean existByPostIdAndUserId(Long postId, Long userId);
	ReviewCreateServiceResponse save(ReviewCreateServiceRequest reviewCreateServiceRequest);
}
