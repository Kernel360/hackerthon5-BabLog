import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import DetailPage from '../components/DetailPage';

const Detail = () => {
  const { postId } = useParams();
  const [detailData, setDetailData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true);
    fetch(`/api/post/${postId}`)
      .then(res => {
        if (!res.ok) throw new Error('Network response was not ok');
        return res.json();
      })
      .then(data => {
        setDetailData(data);
      })
      .catch(() => {
        // 목업 데이터
        setDetailData({
          title: '맛있는 한식',
          description: '서울 강남구 도로명 상세주소 어쩌구',
          imageUrl:
            'https://images.unsplash.com/photo-1504674900247-0877df9cc836',
          reviews: [
            {
              id: 1,
              author: 'test@naver.com',
              date: '2024-05-07',
              content: '정말 맛있어 보여요!',
              liked: true,
            },
            {
              id: 2,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 3,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 4,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 5,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 6,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 7,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 8,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 9,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 10,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
            {
              id: 11,
              author: 'test2@naver.com',
              date: '2024-05-07',
              content: '한식은 사랑입니다.',
              liked: false,
            },
          ],
        });
        setError('데이터를 불러오지 못했습니다. (mock data)');
      })
      .finally(() => setLoading(false));
  }, [postId]);

  if (loading) return <div>로딩중...</div>;
  if (!detailData) return <div>데이터 없음</div>;

  return (
    <div>
      {error && <div style={{ color: 'red' }}>{error}</div>}
      <DetailPage detailData={detailData} />
    </div>
  );
};

export default Detail;
