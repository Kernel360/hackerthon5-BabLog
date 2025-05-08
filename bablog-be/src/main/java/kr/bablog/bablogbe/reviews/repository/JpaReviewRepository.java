package kr.bablog.bablogbe.reviews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.bablog.bablogbe.reviews.domain.Review;

public interface JpaReviewRepository extends JpaRepository<Review, Long> {
}
