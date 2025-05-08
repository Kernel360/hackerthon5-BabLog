const TitleSection = ({ data }) => (
  <section className="title-section">
    <h2>{data.title}</h2>
    <p className="address">{data.address}</p>
  </section>
);

export default TitleSection;
