package kr.bablog.bablogbe.reviews.repository;

import static kr.bablog.bablogbe.reviews.domain.QReview.review;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.bablog.bablogbe.reviews.domain.Review;
import kr.bablog.bablogbe.reviews.service.dto.request.ReviewCreateServiceRequest;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewCreateServiceResponse;
import kr.bablog.bablogbe.reviews.service.dto.response.ReviewLookupResponse;
import kr.bablog.bablogbe.reviews.service.errors.ReviewErrorType;
import kr.bablog.bablogbe.reviews.service.errors.exception.ReviewCreateException;
import kr.bablog.bablogbe.reviews.service.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslReviewRepository implements ReviewRepository {

	private final JPAQueryFactory queryFactory;
	private final JpaReviewRepository jpaReviewRepository;

	public boolean existByPostIdAndUserId(final Long postId, final Long userId) {
		return queryFactory.select(review.id)
			.from(review)
			.where(review.postId.eq(postId).and(review.userId.eq(userId)))
			.fetchFirst() != null;
	}

	@Override
	public ReviewCreateServiceResponse save(final ReviewCreateServiceRequest request) {
		try {
			final Review review = Review.create(request.postId(), request.userId(), request.comment(),
				request.reviewLike());

			jpaReviewRepository.save(review);

			return new ReviewCreateServiceResponse(true);
		} catch (ConstraintViolationException exception) {
			throw new ReviewCreateException(ReviewErrorType.REVIEW_CREATE_CONSTRAINT);
		}
	}

	@Override
	public Optional<Review> findEntityById(final Long reviewId) {
		final Review findReview = queryFactory.selectFrom(review)
			.where(review.id.eq(reviewId))
			.fetchOne();

		return Optional.ofNullable(findReview);
	}

	@Override
	public List<ReviewLookupResponse> findPagedReviewsByPostId(final Long postId, final int offset, final int limit) {
		return queryFactory.select(Projections.constructor(ReviewLookupResponse.class,
				review.id,
				review.comment,
				review.userId,
				review.reviewLike))
			.from(review)
			.where(review.postId.eq(postId))
			.offset(offset)
			.limit(limit)
			.orderBy(review.createdAt.desc())
			.fetch();
	}

	@Override
	public Long countReviewByPostId(final Long postId) {
		return queryFactory.select(review.id.count())
			.from(review)
			.where(review.postId.eq(postId))
			.fetchOne();
	}

	@Override
	public Long countReviewLikeByPostId(final Long postId) {
		return queryFactory.select(review.id.count())
			.from(review)
			.where(review.postId.eq(postId).and(review.reviewLike.eq(Boolean.TRUE)))
			.fetchOne();
	}
}
