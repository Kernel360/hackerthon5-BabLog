import { useState, useEffect } from 'react';
import ReviewList from './ReviewList';
import Pagination from './Pagination';
import ReviewInput from './ReviewInput';
import ReviewStatusSection from './ReviewStatusSection';

const REVIEWS_PER_PAGE = 10;

const ReviewSection = ({ postId }) => {
  const [reviews, setReviews] = useState([]);
  const [totalCount, setTotalCount] = useState(0);
  const [likedCount, setLikedCount] = useState(0);
  const [page, setPage] = useState(1);
  const totalPages = Math.ceil(totalCount / REVIEWS_PER_PAGE);

  useEffect(() => {
    const fetchReviews = async () => {
      try {
        const offset = (page - 1) * REVIEWS_PER_PAGE;
        const res = await fetch(
          `/api/posts/${postId}/reviews?offset=${offset}&size=${REVIEWS_PER_PAGE}`,
          { headers: { 'Content-Type': 'application/json' } },
        );
        const result = await res.json();
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
            content: '정말 맛있어 보여요!',
            liked: true,
          },
          {
            id: 2,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 3,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 4,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 5,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 6,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 7,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 8,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 9,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 10,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 11,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
          {
            id: 12,
            email: 'test2@naver.com',
            date: '2024-05-07',
            content: '한식은 사랑입니다.',
            liked: false,
          },
        ];
        const offset = (page - 1) * REVIEWS_PER_PAGE;
        setReviews(mockReviews.slice(offset, offset + REVIEWS_PER_PAGE));
        setTotalCount(mockReviews.length);
        setLikedCount(mockReviews.filter(r => r.liked).length);
      }
    };
    fetchReviews();
  }, [postId, page]);

  return (
    <section className="review-section">
      <ReviewStatusSection total={totalCount} likedCount={likedCount} />
      <ReviewList reviews={reviews} />
      <Pagination page={page} totalPages={totalPages} onPageChange={setPage} />
      <ReviewInput />
    </section>
  );
};

export default ReviewSection;
