const TitleSection = ({ data }) => (
  <section className="title-section">
    <h2>{data.title}</h2>
    <p className="description">{data.description}</p>
  </section>
);

export default TitleSection;
