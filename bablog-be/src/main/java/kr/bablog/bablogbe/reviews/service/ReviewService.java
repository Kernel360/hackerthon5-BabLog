package kr.bablog.bablogbe.reviews.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCreateWebRequest;
import kr.bablog.bablogbe.reviews.domain.Review;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCommentUpdateRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCommentUpdateResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponses;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewExistException;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewNotFoundException;
import kr.bablog.bablogbe.reviews.service.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;

	@Transactional
	public ReviewCreateServiceResponse save(final ReviewCreateWebRequest reviewCreateWebRequest) {
		if (reviewRepository.existByPostIdAndUserId(reviewCreateWebRequest.getPostId(),
			reviewCreateWebRequest.getUserId())) {
			throw new ReviewExistException(ReviewErrorType.USER_REVIEW_EXIST);
		}

		return reviewRepository.save(reviewCreateWebRequest.toServiceRequest());
	}

	@Transactional
	public ReviewCommentUpdateResponse updateComment(final ReviewCommentUpdateRequest reviewCommentUpdateRequest) {
		final Long inputReviewId = reviewCommentUpdateRequest.reviewId();
		final String inputComment = reviewCommentUpdateRequest.updatedComment();

		final Review review = reviewRepository.findEntityById(inputReviewId)
			.orElseThrow(() -> new ReviewNotFoundException(ReviewErrorType.REVIEW_NOT_FOUND));

		review.updateComment(inputComment);

		return new ReviewCommentUpdateResponse(review.getId(), review.getComment());
	}

	@Transactional(readOnly = true)
	public ReviewLookupResponses findPagedReviewsByPostId(final Long postId, final int offset, final int limit) {
		final List<ReviewLookupResponse> reviewLookupResponses =
			reviewRepository.findPagedReviewsByPostId(postId, offset, limit);

		final Long reviewCount = reviewRepository.countReviewByPostId(postId);
		final Long reviewLikeCount = reviewRepository.countReviewLikeByPostId(postId);

		return new ReviewLookupResponses(reviewLookupResponses, reviewCount, reviewLikeCount);
	}
}
