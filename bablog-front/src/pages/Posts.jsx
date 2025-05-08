import React, { useState } from 'react';
import Post from '../components/Post';
import '../styles/Post.css';

const allPosts = [
  { image: '이미지URL1', title: '맛집1' },
  { image: '이미지URL2', title: '맛집2' },
  { image: '이미지URL2', title: '맛집3' },
  { image: '이미지URL2', title: '맛집5' },
  { image: '이미지URL2', title: '맛집6' },
  { image: '이미지URL2', title: '맛집7' },
  { image: '이미지URL2', title: '맛집8' },
  { image: '이미지URL2', title: '맛집9' },
  { image: '이미지URL2', title: '맛집10' },
  { image: '이미지URL2', title: '맛집11' },
  { image: '이미지URL2', title: '맛집12' },
];

const POSTS_PER_PAGE = 9;

function Posts() {
  const [page, setPage] = useState(1);
  const totalPages = Math.ceil(allPosts.length / POSTS_PER_PAGE);

  const currentPosts = allPosts.slice(
    (page - 1) * POSTS_PER_PAGE,
    page * POSTS_PER_PAGE,
  );

  return (
    <div className="post-container">
      <h1 className="post-title">맛집 리스트</h1>
      <div className="post-grid">
        {currentPosts.map((post, idx) => (
          <Post key={idx} image={post.image} title={post.title} />
        ))}
      </div>
      <div className="pagination">
        <span
          onClick={() => setPage(p => Math.max(1, p - 1))}
          style={{ cursor: 'pointer', marginRight: 10 }}
        >
          &lt; 이전
        </span>
        {[...Array(totalPages)].map((_, i) => (
          <span
            key={i}
            className="page-num"
            style={{
              fontWeight: page === i + 1 ? 'bold' : 'normal',
              color: page === i + 1 ? '#2196f3' : undefined,
            }}
            onClick={() => setPage(i + 1)}
          >
            {i + 1}
          </span>
        ))}
        <span
          onClick={() => setPage(p => Math.min(totalPages, p + 1))}
          style={{ cursor: 'pointer', marginLeft: 10 }}
        >
          다음 &gt;
        </span>
      </div>
    </div>
  );
}

export default Posts;
