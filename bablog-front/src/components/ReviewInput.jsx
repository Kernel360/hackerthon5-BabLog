import { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faThumbsUp as faSolidThumbsUp } from '@fortawesome/free-solid-svg-icons';
import { faThumbsUp as faRegularThumbsUp } from '@fortawesome/free-regular-svg-icons';

const ReviewInput = ({ postId, userId, onReviewSuccess }) => {
  const [review, setReview] = useState('');
  const [liked, setLiked] = useState(false);

  const handleChange = e => setReview(e.target.value);
  const handleLikeToggle = () => setLiked(l => !l);
  const handleSubmit = async e => {
    e.preventDefault();
    if (!review.trim()) return;

    try {
      const res = await fetch('/api/reviews', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          postId,
          userId,
          comment: review,
          reviewLike: liked,
        }),
      });
      const data = await res.json();
      if (res.status === 201 && data.result === 'SUCCESS') {
        setReview('');
        setLiked(false);
        alert('리뷰가 등록되었습니다!');
        if (onReviewSuccess) onReviewSuccess();
      } else if (res.status === 400 && data.error?.code === 'ERROR_REVIEW01') {
        alert('이미 리뷰를 작성하셨습니다.');
      } else {
        alert('리뷰 등록에 실패했습니다.');
      }
    } catch {
      alert('네트워크 오류');
    }
  };

  return (
    <form className="review-input-box" onSubmit={handleSubmit}>
      <textarea
        placeholder="리뷰를 입력하세요"
        value={review}
        onChange={handleChange}
        className="review-input-field"
        rows={3}
      />
      <button
        type="button"
        className={`review-like-toggle${liked ? ' liked' : ''}`}
        onClick={handleLikeToggle}
        aria-label="좋아요"
      >
        <FontAwesomeIcon icon={liked ? faSolidThumbsUp : faRegularThumbsUp} />
      </button>
      <button type="submit" className="review-submit-btn">
        등록
      </button>
    </form>
  );
};

export default ReviewInput;
