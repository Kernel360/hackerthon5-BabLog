import React, { useState, useEffect, useCallback } from "react";
import Post from "../components/Post";
import Pagination from "../components/Pagination";
import "../styles/Post.css";

const POSTS_PER_PAGE = 9; // 한 페이지에 보여줄 맛집 수

function Posts() {
  const [posts, setPosts] = useState([]);
  const [totalPostCount, setTotalPostCount] = useState(0);
  const [backendTotalPages, setBackendTotalPages] = useState(1);
  const [page, setPage] = useState(1);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const totalPages = Math.ceil(totalPostCount / POSTS_PER_PAGE);

  const fetchPosts = useCallback(async () => {
    setLoading(true);
    setError(null);
    try {
      const offset = (page - 1) * POSTS_PER_PAGE;

      const response = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/posts?offset=${offset}&size=${POSTS_PER_PAGE}`,
        { headers: { "Content-Type": "application/json" } }
      );

      const result = await response.json();

      if (response.ok && result.result === "SUCCESS" && result.data) {
        const rawPosts = result.data.contents || [];

        const formattedPosts = rawPosts.map((backendPost) => ({
          postId: backendPost.postId,
          title: backendPost.title,
          image: backendPost.imgUrl,
        }));

        setPosts(formattedPosts);
        setTotalPostCount(result.data.totalElements);
        setBackendTotalPages(result.data.totalPages);
      } else {
        setError(
          result.error?.message || "맛집 목록을 가져오는데 실패했습니다."
        );
        setPosts([]);
        setTotalPostCount(0);
      }
    } catch (err) {
      console.error("Fetch posts error:", err);
      setError("네트워크 오류가 발생했거나 서버에 연결할 수 없습니다.");
      setPosts([]);
      setTotalPostCount(0);
    } finally {
      setLoading(false);
    }
  }, [page]);

  useEffect(() => {
    fetchPosts();
  }, [fetchPosts]);

  if (loading) {
    return (
      <div
        className="post-container"
        style={{ textAlign: "center", padding: "50px" }}
      >
        <h1 className="post-title">맛집 리스트</h1>
        <p>맛집 목록을 불러오는 중입니다...</p>
      </div>
    );
  }

  if (error) {
    return (
      <div
        className="post-container"
        style={{ textAlign: "center", padding: "50px", color: "red" }}
      >
        <h1 className="post-title">맛집 리스트</h1>
        <p>오류: {error}</p>
        <button onClick={fetchPosts} style={{ marginTop: "10px" }}>
          다시 시도
        </button>
      </div>
    );
  }

  return (
    <div className="post-container">
      <h1 className="post-title">맛집 리스트</h1>
      {posts.length === 0 ? (
        <p style={{ textAlign: "center" }}>표시할 맛집 정보가 없습니다.</p>
      ) : (
        <div className="post-grid">
          {posts.map((post) => (
            <Post
              key={post.postId}
              postId={post.postId}
              image={post.image}
              title={post.title}
            />
          ))}
        </div>
      )}
      {totalPages > 1 && (
        <Pagination
          page={page}
          totalPages={totalPages}
          onPageChange={(newPage) => setPage(newPage)}
        />
      )}
    </div>
  );
}

export default Posts;
