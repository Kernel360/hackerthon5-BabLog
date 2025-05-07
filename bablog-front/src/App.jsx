import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Detail from './pages/Detail';
import Signup from "./components/Signup";
import Login from "./components/Login";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<>{/* 로그인 페이지 */}</>} />
        <Route
          path="/post"
          element={
            <>
              <Header />
              {/* 맛집 리스트 페이지 */}
            </>
          }
        />
        <Route
          path="/post/:postId"
          element={
            <>
              <Header />
              <Detail />
            </>
          }
        />
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route path="/sign-up" element={<Signup />} />
      </Routes>
    </Router>
  );
}

export default App;
