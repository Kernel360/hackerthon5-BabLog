const ReviewList = ({ reviews }) => (
  <ul className="review-list">
    {reviews && reviews.length > 0 ? (
      reviews.map(review => (
        <li key={review.id} className="review-item">
          <div className="review-meta">
            <span className="review-email">{review.email}</span>
            <span className="review-date">{review.date}</span>
            <span className="review-like">{review.liked ? '👍' : ''}</span>
          </div>
          <div className="review-content">{review.content}</div>
        </li>
      ))
    ) : (
      <li>리뷰가 없습니다.</li>
    )}
  </ul>
);

export default ReviewList;
