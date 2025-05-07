import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Detail from './pages/Detail';

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
      </Routes>
    </Router>
  );
}

export default App;
