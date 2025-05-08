package kr.bablog.bablogbe.reviews.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.bablog.bablogbe.authentication.dto.LoginUser;
import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCommentUpdateWebRequest;
import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCreateWebRequest;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewCommentUpdateWebResponse;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewCreateWebResponse;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewDeleteWebResponse;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewLookUpWebResponse;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewLookUpWebResponses;
import kr.bablog.bablogbe.reviews.service.ReviewService;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCommentUpdateRequest;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCommentUpdateResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponses;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewInvalidRequestException;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping("/reviews")
	public ResponseEntity<ApiResponse<ReviewCreateWebResponse>> createReview(
		final LoginUser loginUser,
		@RequestBody final ReviewCreateWebRequest reviewCreateWebRequest) {
		final ReviewCreateServiceRequest reviewCreateServiceRequest = new ReviewCreateServiceRequest(
			reviewCreateWebRequest.getPostId(),
			loginUser.userId(),
			reviewCreateWebRequest.getComment(),
			reviewCreateWebRequest.isReviewLike());

		final ReviewCreateServiceResponse serviceResponse = reviewService.save(reviewCreateServiceRequest);
		final ReviewCreateWebResponse reviewCreateWebResponse = ReviewCreateWebResponse.from(serviceResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(reviewCreateWebResponse));
	}

	@PatchMapping("/reviews/comment")
	public ResponseEntity<ApiResponse<ReviewCommentUpdateWebResponse>> updateReviewComment(
		LoginUser loginUser,
		@RequestBody final ReviewCommentUpdateWebRequest reviewCreateWebRequest) {

		ReviewCommentUpdateRequest reviewCommentUpdateRequest = new ReviewCommentUpdateRequest(
			reviewCreateWebRequest.getReviewId(),
			reviewCreateWebRequest.getComment(),
			loginUser.userId());

		final ReviewCommentUpdateResponse reviewCommentUpdateResponse = reviewService.updateComment(
			reviewCommentUpdateRequest);

		final ReviewCommentUpdateWebResponse reviewCommentUpdateWebResponse =
			ReviewCommentUpdateWebResponse.from(reviewCommentUpdateResponse);

		return ResponseEntity.ok(ApiResponse.success(reviewCommentUpdateWebResponse));
	}

	@GetMapping("/posts/{postId}/reviews")
	public ResponseEntity<ApiResponse<ReviewLookUpWebResponses>> updateReviewComment(
		@PathVariable(name = "postId") final Long postId,
		@RequestParam(name = "offset", defaultValue = "0") int offset,
		@RequestParam(name = "size", defaultValue = "10") int size) {

		if (offset < 0) {
			throw new ReviewInvalidRequestException(ReviewErrorType.REVIEW_INVALID_OFFSET);
		}

		if (size <= 0) {
			throw new ReviewInvalidRequestException(ReviewErrorType.REVIEW_INVALID_SIZE);
		}

		final ReviewLookupResponses reviewLookupResponses = reviewService.findPagedReviewsByPostId(postId, offset,
			size);

		final List<ReviewLookUpWebResponse> reviewLookUpWebResponses =
			reviewLookupResponses.reviewLookupResponses().stream()
				.map(ReviewLookUpWebResponse::from)
				.toList();

		return ResponseEntity.ok(ApiResponse.success(new ReviewLookUpWebResponses(reviewLookUpWebResponses,
			reviewLookupResponses.reviewCount(), reviewLookupResponses.likeCount())));
	}

	// TODO 본인이 작성한 리뷰에 한해서 코멘트 삭제 기능 추가
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<ApiResponse<ReviewDeleteWebResponse>> deleteReview(
		@PathVariable(name = "reviewId") final Long reviewId) {
		Long deleteReviewId = reviewService.deleteReview(reviewId);
		final ReviewDeleteWebResponse reviewDeleteWebResponse = new ReviewDeleteWebResponse(deleteReviewId);
		return ResponseEntity.ok(ApiResponse.success(reviewDeleteWebResponse));
	}
}
