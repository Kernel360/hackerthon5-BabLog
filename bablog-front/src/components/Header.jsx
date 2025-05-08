import { Link, useNavigate } from "react-router-dom";
import "../styles/Header.css";

const Header = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    if (!window.confirm("정말 로그아웃 하시겠습니까?")) return;
    localStorage.removeItem("token");
    navigate("/");
  };

  return (
    <header className="header">
      <div className="header-container">
        <Link to="/post" className="home-button">
          <span role="img" aria-label="rice" style={{ marginRight: "6px" }}>
            🍚
          </span>
          Bab-Log
        </Link>
        <button onClick={handleLogout} className="logout-button">
          로그아웃
        </button>
      </div>
    </header>
  );
};

export default Header;
