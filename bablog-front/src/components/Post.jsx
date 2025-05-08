import React from "react";
import "../styles/Post.css";
import { Link } from "react-router-dom";

function Post({ postId, image, title }) {
  return (
    <Link to={`/post/${postId}`}>
      <div className="post-item">
        <img src={image} alt={title} className="post-image" />
        <div className="post-name">{title}</div>
      </div>
    </Link>
  );
}

export default Post;
