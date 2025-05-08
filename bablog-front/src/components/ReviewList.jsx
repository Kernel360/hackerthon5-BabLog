import { useState } from 'react';

const ReviewList = ({ reviews, currentUserEmail, onEdit, onDelete }) => {
  const [editId, setEditId] = useState(null);
  const [editComment, setEditComment] = useState('');

  const handleEditClick = review => {
    setEditId(review.id);
    setEditComment(review.comment);
  };

  const handleEditChange = e => setEditComment(e.target.value);

  const handleEditSave = e => {
    e.preventDefault();
    if (onEdit) onEdit(editId, editComment);
    setEditId(null);
    setEditComment('');
  };

  const handleEditCancel = () => {
    setEditId(null);
    setEditComment('');
  };

  return (
    <ul className="review-list">
      {reviews && reviews.length > 0 ? (
        reviews.map(review => (
          <li key={review.id} className="review-item">
            <div className="review-meta">
              <span className="review-email">{review.email}</span>
              <span className="review-date">{review.date}</span>
              <span className="review-like">{review.like ? '👍' : ''}</span>
              {/* 본인 리뷰일 때만 버튼 표시 */}
              {review.email === currentUserEmail && editId !== review.id && (
                <span>
                  <button onClick={() => handleEditClick(review)}>수정</button>
                  <button onClick={() => onDelete && onDelete(review.id)}>
                    삭제
                  </button>
                </span>
              )}
            </div>
            <div className="review-comment">
              {editId === review.id ? (
                <form
                  className="review-input-box"
                  style={{
                    marginTop: 0,
                    marginBottom: 0,
                    padding: 0,
                    background: 'none',
                    boxShadow: 'none',
                  }}
                  onSubmit={handleEditSave}
                >
                  <textarea
                    value={editComment}
                    onChange={handleEditChange}
                    className="review-input-field"
                    rows={2}
                  />
                  <button type="submit" className="review-submit-btn">
                    저장
                  </button>
                  <button
                    type="button"
                    className="review-submit-btn"
                    style={{ background: '#bbb', marginLeft: 6 }}
                    onClick={handleEditCancel}
                  >
                    취소
                  </button>
                </form>
              ) : (
                review.comment
              )}
            </div>
          </li>
        ))
      ) : (
        <li>리뷰가 없습니다.</li>
      )}
    </ul>
  );
};

export default ReviewList;
