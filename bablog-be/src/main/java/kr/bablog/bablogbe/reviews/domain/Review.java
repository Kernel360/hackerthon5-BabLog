package kr.bablog.bablogbe.reviews.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
	@UniqueConstraint(columnNames = {"postId", "userId"})
})
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long postId;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false, length = 400)
	private String comment;

	@Column(nullable = false)
	@ColumnDefault("0")
	private boolean reviewLike;

	private Review(final Long postId, final Long userId, final String comment, final boolean reviewLike) {
		this.postId = postId;
		this.userId = userId;
		this.comment = comment;
		this.reviewLike = reviewLike;
	}

	public static Review create(final Long postId, final Long userId, final String comment, final boolean reviewLike) {
		return new Review(postId, userId, comment, reviewLike);
	}

}
