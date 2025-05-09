import TitleSection from './TitleSection';
import ImageSection from './ImageSection';
import ReviewSection from './ReviewSection';
import '../styles/DetailPage.css';

const DetailPage = ({ detailData }) => (
  <div className="detail-page">
    <TitleSection data={detailData} />
    <ImageSection imageUrl={detailData.imgUrl} />
    <ReviewSection postId={detailData.postId} userId={detailData.userId} />
  </div>
);

export default DetailPage;
