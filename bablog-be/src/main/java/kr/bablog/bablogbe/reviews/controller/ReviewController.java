package kr.bablog.bablogbe.reviews.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.bablog.bablogbe.common.api.response.ApiResponse;
import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCommentUpdateWebRequest;
import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCreateWebRequest;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewCommentUpdateWebResponse;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewCreateWebResponse;
import kr.bablog.bablogbe.reviews.service.ReviewService;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCommentUpdateRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCommentUpdateResponse;
import kr.bablog.bablogbe.reviews.controller.dto.request.ReviewCreateWebRequest;
import kr.bablog.bablogbe.reviews.controller.dto.response.ReviewCreateWebResponse;
import kr.bablog.bablogbe.reviews.service.ReviewService;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping
	public ResponseEntity<ApiResponse<ReviewCreateWebResponse>> createReview(
		@RequestBody final ReviewCreateWebRequest reviewCreateWebRequest) {

		final ReviewCreateServiceResponse serviceResponse = reviewService.save(reviewCreateWebRequest);
		final ReviewCreateWebResponse reviewCreateWebResponse = ReviewCreateWebResponse.from(serviceResponse);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(reviewCreateWebResponse));
	}

	@PatchMapping("/comment")
	public ResponseEntity<ApiResponse<ReviewCommentUpdateWebResponse>> updateReviewComment(
		@RequestBody final ReviewCommentUpdateWebRequest reviewCreateWebRequest) {
		ReviewCommentUpdateRequest reviewCommentUpdateRequest =
			new ReviewCommentUpdateRequest(reviewCreateWebRequest.getReviewId(), reviewCreateWebRequest.getComment());

		final ReviewCommentUpdateResponse reviewCommentUpdateResponse = reviewService.updateComment(
			reviewCommentUpdateRequest);

		final ReviewCommentUpdateWebResponse reviewCommentUpdateWebResponse =
			ReviewCommentUpdateWebResponse.from(reviewCommentUpdateResponse);

		return ResponseEntity.ok(ApiResponse.success(reviewCommentUpdateWebResponse));
	}
}
