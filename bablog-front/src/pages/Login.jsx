import { useState } from "react";
import "../styles/Login.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault();
    try {
      const response = await axios.post(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/auth/login`,
        {
          email,
          password,
        }
      );

      const token = response.data.data.accessToken;

      localStorage.setItem("token", token);
      navigate("/posts");
    } catch (error) {
      console.error("Login failed", error);
      alert("로그인에 실패했습니다. 다시 시도해주세요.");
    }
  }

  return (
    <>
      <div className="signup-container">
        <h2 className="signup-title">로그인</h2>

        <form onSubmit={handleSubmit}>
          <label className="signup-label">이메일 주소</label>
          <input
            type="email"
            className="signup-input"
            placeholder="이메일 주소를 입력해주세요"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <label className="signup-label">비밀번호</label>
          <input
            type="password"
            className="signup-input"
            placeholder="비밀번호를 입력해주세요"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="signup-btn">
            로그인
          </button>
        </form>
        <div className="signup-guide-container">
          <span>신규 사용자이신가요?</span>
          <a href="/sign-up" className="signup-guide-link">
            회원가입
          </a>
        </div>
      </div>
    </>
  );
}

export default Login;
