package kr.bablog.bablogbe.reviews.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.bablog.bablogbe.reviews.domain.Review;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCommentUpdateRequest;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCommentUpdateResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponses;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewExistException;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewInvalidDeleteException;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewNotFoundException;
import kr.bablog.bablogbe.reviews.service.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;

	@Transactional
	public ReviewCreateServiceResponse save(final ReviewCreateServiceRequest reviewCreateWebRequest) {
		if (reviewRepository.existByPostIdAndUserId(reviewCreateWebRequest.postId(),
			reviewCreateWebRequest.userId())) {
			throw new ReviewExistException(ReviewErrorType.USER_REVIEW_EXIST);
		}

		return reviewRepository.save(reviewCreateWebRequest);
	}

	// TODO 본인이 작성한 리뷰에 한해서 코멘트 변경 기능
	@Transactional
	public ReviewCommentUpdateResponse updateComment(final ReviewCommentUpdateRequest reviewCommentUpdateRequest) {
		final Long inputReviewId = reviewCommentUpdateRequest.reviewId();
		final String inputComment = reviewCommentUpdateRequest.updatedComment();
		final Long userId = reviewCommentUpdateRequest.userId();

		final Review review = reviewRepository.findEntityById(inputReviewId)
			.orElseThrow(() -> new ReviewNotFoundException(ReviewErrorType.REVIEW_NOT_FOUND));

		review.updateComment(inputComment, userId);

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

	/**
	 * @param reviewId 삭제할 리뷰 아이디
	 * @param aLong
	 * @return 삭제한 리뷰 아이디 반환
	 */
	// TODO 본인이 작성한 리뷰에 한해서 삭제 기능 + 본인이 아닌 경우 예외 반환 로직 추가
	@Transactional
	public Long deleteReview(final Long reviewId, final Long userId) {
		final Review review = reviewRepository.findEntityById(reviewId)
			.orElseThrow(() -> new ReviewNotFoundException(ReviewErrorType.REVIEW_NOT_FOUND));

		if (!review.isAuthor(userId)) {
			throw new ReviewInvalidDeleteException(ReviewErrorType.REVIEW_INVALID_DELETE);
		}

		reviewRepository.deleteById(review.getId());

		return review.getId();
	}
}
