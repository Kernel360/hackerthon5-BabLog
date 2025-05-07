import "../styles/Signup.css";

export default function App() {
  return (
    <>
      <div className="signup-container">
        <h2 className="signup-title">회원가입</h2>
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
          <label className="signup-label">비밀번호 확인</label>
          <input
            type="password"
            className="signup-input"
            placeholder="비밀번호를 다시 입력해주세요"
            required
          />
          <button type="submit" className="signup-btn">
            회원가입
          </button>
        </form>
      </div>
    </>
  );
}
