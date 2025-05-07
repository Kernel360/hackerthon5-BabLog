import "../styles/Login.css";

function Login() {
  return (
    <>
      <div className="signup-container">
        <h2 className="signup-title">로그인</h2>
        <form>
          <label className="signup-label">이메일 주소</label>
          <input
            type="email"
            className="signup-input"
            placeholder="이메일 주소를 입력해주세요"
            required
          />
          <label className="signup-label">비밀번호</label>
          <input
            type="password"
            className="signup-input"
            placeholder="비밀번호를 입력해주세요"
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
