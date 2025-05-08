const ImageSection = ({ imageUrl }) => (
  <section className="image-section">
    <img src={imageUrl} alt="대표 이미지" className="main-image" />
  </section>
);

export default ImageSection;
