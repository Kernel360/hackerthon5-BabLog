import { useState } from 'react';
import '../styles/Signup.css';
import { useNavigate } from 'react-router-dom';

export default function App() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const navigate = useNavigate();

  async function handleSubmit(e) {
    e.preventDefault();

    if (password !== confirmPassword) {
      setErrorMessage(
        '비밀번호를 잘못 입력했습니다.\n입력하신 내용을 다시 확인해주세요.',
      );
      return;
    }

    setErrorMessage('');

    try {
      const response = await fetch(
        `${import.meta.env.VITE_REACT_APP_API_BASE_URL}/api/signup`,
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ email, password }),
        },
      );

      if (!response.ok) {
        const data = await response.json();
        setErrorMessage(data.message || '회원가입에 실패했습니다.');
      } else {
        alert('회원가입이 완료되었습니다!');
        navigate('/');
      }
    } catch (error) {
      console.error('Error:', error);
      setErrorMessage('서버 오류가 발생했습니다.');
    }
  }

  return (
    <>
      <div className="signup-container">
        <h2 className="signup-title">회원가입</h2>
        <form onSubmit={handleSubmit}>
          <label className="signup-label">이메일 주소</label>
          <input
            type="email"
            className="signup-input"
            placeholder="이메일 주소를 입력해주세요"
            value={email}
            onChange={e => setEmail(e.target.value)}
            required
          />
          <label className="signup-label">비밀번호</label>
          <input
            type="password"
            className="signup-input"
            placeholder="비밀번호를 입력해주세요"
            value={password}
            onChange={e => setPassword(e.target.value)}
            required
          />
          <label className="signup-label">비밀번호 확인</label>
          <input
            type="password"
            className="signup-input"
            placeholder="비밀번호를 다시 입력해주세요"
            value={confirmPassword}
            onChange={e => setConfirmPassword(e.target.value)}
            required
          />

          {errorMessage && (
            <p
              className="signup-error-message"
              style={{ color: 'red', whiteSpace: 'pre-line' }}
            >
              {errorMessage}
            </p>
          )}
          <button type="submit" className="signup-btn">
            회원가입
          </button>
        </form>
      </div>
    </>
  );
}
