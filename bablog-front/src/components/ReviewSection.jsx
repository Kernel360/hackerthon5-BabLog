import { useState, useEffect, useCallback } from 'react';
import ReviewList from './ReviewList';
import Pagination from './Pagination';
import ReviewInput from './ReviewInput';
import ReviewStatusSection from './ReviewStatusSection';
import { getAuthHeader } from '../utils/auth.js'
import { getEmailFromToken } from '../utils/jwt';

const REVIEWS_PER_PAGE = 10;

const ReviewSection = ({ postId }) => {
  const [reviews, setReviews] = useState([]);
  const [totalCount, setTotalCount] = useState(0);
  const [likedCount, setLikedCount] = useState(0);
  const [page, setPage] = useState(1);
  const totalPages = Math.ceil(totalCount / REVIEWS_PER_PAGE);

  const token = localStorage.getItem('token');
  const currentUserEmail = getEmailFromToken(token);

  // const currentUserEmail = 'test@naver.com'; // 임시 이메일

  const fetchReviews = useCallback(async () => {
    try {
      const offset = (page - 1) * REVIEWS_PER_PAGE;
      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/posts/${postId}/reviews?offset=${offset}&size=${REVIEWS_PER_PAGE}`,
        { headers: { 'Content-Type': 'application/json', ...getAuthHeader() }},
      );
      const result = await res.json();
      console.log(result)
      console.log(result.data)
      if (result.result === 'SUCCESS' && result.data) {
        const reviewsWithDate = (result.data.reviews || []).map(r => ({
          ...r,
          date: r.createdAt,
        }));
        setReviews(reviewsWithDate);
        setTotalCount(result.data.reviewCount || 0);
        setLikedCount(result.data.likeCount || 0);
      } else {
        setReviews([]);
        setTotalCount(0);
        setLikedCount(0);
      }
    } catch {
      // 목업 데이터
      const mockReviews = [
        {
          id: 1,
          email: 'test@naver.com',
          date: '2024-05-07',
          comment: '정말 맛있어 보여요!',
          liked: true,
        },
        {
          id: 2,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 3,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 4,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 5,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 6,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 7,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 8,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 9,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 10,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 11,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
        {
          id: 12,
          email: 'test2@naver.com',
          date: '2024-05-07',
          comment: '한식은 사랑입니다.',
          liked: false,
        },
      ];
      const offset = (page - 1) * REVIEWS_PER_PAGE;
      setReviews(mockReviews.slice(offset, offset + REVIEWS_PER_PAGE));
      setTotalCount(mockReviews.length);
      setLikedCount(mockReviews.filter(r => r.liked).length);
    }
  }, [postId, page]);

  useEffect(() => {
    fetchReviews();
  }, [fetchReviews]);

  const handleEditReview = async (reviewId, newComment) => {
    if (!newComment.trim()) {
      alert('리뷰 코멘트가 비어있습니다.');
      return;
    }
    try {
      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/reviews`,
        {
          method: 'PATCH',
          headers: { 'Content-Type': 'application/json', ...getAuthHeader() },
          body: JSON.stringify({ reviewId, comment: newComment }),
        },
      );
      const data = await res.json();
      if (res.ok && data.result === 'SUCCESS') {
        alert('리뷰가 수정되었습니다.');
        fetchReviews();
      } else {
        alert(data.error?.message || '리뷰 수정에 실패했습니다.');
      }
    } catch {
      alert('네트워크 오류');
    }
  };

  const handleDeleteReview = async reviewId => {
    try {
      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/reviews/${reviewId}`,
        {
          method: 'DELETE',
          headers: { 'Content-Type': 'application/json', ...getAuthHeader() },
          // body: JSON.stringify({ reviewId }),
        },
      );
      const data = await res.json();
      if (res.ok && data.result === 'SUCCESS') {
        alert('리뷰가 삭제되었습니다.');
        fetchReviews();
      } else {
        alert(data.error?.message || '리뷰 삭제에 실패했습니다.');
      }
    } catch {
      alert('네트워크 오류');
    }
  };

  return (
    <section className="review-section">
      <ReviewStatusSection total={totalCount} likedCount={likedCount} />
      <ReviewList
        reviews={reviews}
        currentUserEmail={currentUserEmail}
        onEdit={handleEditReview}
        onDelete={handleDeleteReview}
      />
      <Pagination page={page} totalPages={totalPages} onPageChange={setPage} />
      <ReviewInput
        postId={postId}
        userId={currentUserEmail}
        onReviewSuccess={fetchReviews}
      />
    </section>
  );
};

export default ReviewSection;
