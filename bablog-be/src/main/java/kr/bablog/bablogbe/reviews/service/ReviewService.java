package kr.bablog.bablogbe.reviews.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCreateWebRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewExistException;
import kr.bablog.bablogbe.reviews.service.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;

	@Transactional
	public ReviewCreateServiceResponse save(final ReviewCreateWebRequest reviewCreateWebRequest) {
		if (reviewRepository.existByPostIdAndUserId(reviewCreateWebRequest.getPostId(), reviewCreateWebRequest.getUserId())) {
			throw new ReviewExistException(ReviewErrorType.USER_REVIEW_EXIST);
		}

		return reviewRepository.save(reviewCreateWebRequest.toServiceRequest());
	}
}
