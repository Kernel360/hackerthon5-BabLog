import { useState, useEffect, useCallback } from 'react';
import ReviewList from './ReviewList';
import Pagination from './Pagination';
import ReviewInput from './ReviewInput';
import ReviewStatusSection from './ReviewStatusSection';
import { getAuthHeader } from '../utils/auth.js';
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

  const fetchReviews = useCallback(async () => {
    try {
      const offset = (page - 1) * REVIEWS_PER_PAGE;
      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/posts/${postId}/reviews?offset=${offset}&size=${REVIEWS_PER_PAGE}`,
        { headers: { 'Content-Type': 'application/json', ...getAuthHeader() } },
      );
      const result = await res.json();
      console.log('API Response:', result);
      if (result.data?.reviews) {
        console.log('First review item:', result.data.reviews[0]);
        console.log(
          'All review items:',
          JSON.stringify(result.data.reviews, null, 2),
        );
      }
      if (result.result === 'SUCCESS' && result.data) {
        const reviewsWithDate = (result.data.reviews || []).map(r => ({
          ...r,
          id: r.reviewId,
          date: r.createdAt,
        }));
        console.log('Processed reviews:', reviewsWithDate);
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
    try {
      // reviewId가 유효한지 확인
      if (
        !reviewId ||
        (typeof reviewId === 'string' && reviewId.startsWith('review-'))
      ) {
        console.error('Invalid review ID:', reviewId);
        alert('유효하지 않은 리뷰 ID입니다.');
        return;
      }

      if (!newComment.trim()) {
        alert('리뷰 코멘트가 비어있습니다.');
        return;
      }

      console.log(
        'Editing review with ID:',
        reviewId,
        'New comment:',
        newComment,
      );
      const requestBody = {
        reviewId: reviewId,
        comment: newComment,
      };
      console.log('Request body:', requestBody);

      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/reviews/comment`,
        {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
            ...getAuthHeader(),
            Accept: 'application/json',
            Origin: 'http://localhost:5173',
          },
          credentials: 'include',
          mode: 'cors',
          body: JSON.stringify(requestBody),
        },
      );

      console.log('Edit response status:', res.status);
      const responseText = await res.text();
      console.log('Raw response:', responseText);

      if (!res.ok) {
        let errorMessage = '리뷰 수정에 실패했습니다.';
        try {
          const errorData = JSON.parse(responseText);
          errorMessage = errorData.error?.message || errorMessage;
          console.error('Error details:', errorData);
        } catch (e) {
          console.error('Error parsing response:', e);
          console.error('Raw response text:', responseText);
        }
        throw new Error(errorMessage);
      }

      try {
        const data = JSON.parse(responseText);
        console.log('Edit response data:', data);
        if (data.result === 'SUCCESS') {
          alert('리뷰가 수정되었습니다.');
          fetchReviews();
        } else {
          alert(data.error?.message || '리뷰 수정에 실패했습니다.');
        }
      } catch (e) {
        console.error('Error parsing success response:', e);
        console.error('Raw success response:', responseText);
        throw new Error('서버 응답을 처리하는 중 오류가 발생했습니다.');
      }
    } catch (error) {
      console.error('리뷰 수정 중 오류 발생:', error);
      console.error('Error stack:', error.stack);
      alert(
        error.message || '리뷰 수정 중 오류가 발생했습니다. 다시 시도해주세요.',
      );
    }
  };

  const handleDeleteReview = async reviewId => {
    try {
      // reviewId가 유효한지 확인
      if (
        !reviewId ||
        (typeof reviewId === 'string' && reviewId.startsWith('review-'))
      ) {
        console.error('Invalid review ID:', reviewId);
        alert('유효하지 않은 리뷰 ID입니다.');
        return;
      }

      console.log('Deleting review with ID:', reviewId);
      const res = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/reviews/${reviewId}`,
        {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json',
            ...getAuthHeader(),
            Accept: 'application/json',
          },
          credentials: 'include',
        },
      );

      console.log('Delete response status:', res.status);
      const responseText = await res.text();
      console.log('Raw response:', responseText);

      if (!res.ok) {
        let errorMessage = '리뷰 삭제에 실패했습니다.';
        try {
          const errorData = JSON.parse(responseText);
          errorMessage = errorData.error?.message || errorMessage;
          console.error('Error details:', errorData);
        } catch (e) {
          console.error('Error parsing response:', e);
          console.error('Raw response text:', responseText);
        }
        throw new Error(errorMessage);
      }

      try {
        const data = JSON.parse(responseText);
        console.log('Delete response data:', data);
        if (data.result === 'SUCCESS') {
          alert('리뷰가 삭제되었습니다.');
          fetchReviews();
        } else {
          alert(data.error?.message || '리뷰 삭제에 실패했습니다.');
        }
      } catch (e) {
        console.error('Error parsing success response:', e);
        console.error('Raw success response:', responseText);
        throw new Error('서버 응답을 처리하는 중 오류가 발생했습니다.');
      }
    } catch (error) {
      console.error('리뷰 삭제 중 오류 발생:', error);
      console.error('Error stack:', error.stack);
      alert(
        error.message || '리뷰 삭제 중 오류가 발생했습니다. 다시 시도해주세요.',
      );
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
