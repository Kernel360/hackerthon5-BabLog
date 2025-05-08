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
    fetch(`${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/post/${postId}`)
      .then(res => {
        if (!res.ok) throw new Error('Network response was not ok');
        return res.json();
      })
      .then(data => setDetailData(data))
      .catch(() => {
        setDetailData({
          // 목업 데이터
          title: '맛있는 한식',
          address: '서울 강남구 ...',
          imageUrl:
            'https://images.unsplash.com/photo-1504674900247-0877df9cc836',
          postId: postId,
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
