import React from "react";
import "../styles/Post.css";

function Post({ image, title }) {
  return (
    <div className="post-item">
      <img src={image} alt={title} className="post-image" />
      <div className="post-name">{title}</div>
    </div>
  );
}

export default Post;
