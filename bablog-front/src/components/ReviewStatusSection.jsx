const ReviewStatusSection = ({ total, likedCount }) => (
  <section className="review-stats-section">
    <span style={{ marginLeft: '16px' }}>👍 {likedCount}</span>
    <span>리뷰 {total}개</span>
  </section>
);

export default ReviewStatusSection;
