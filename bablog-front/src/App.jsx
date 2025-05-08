import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Signup from "./components/Signup";
import Login from "./components/Login";
import Posts from "./components/Posts";

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
              <Posts />
            </>
          }
        />
        <Route
          path="/post/:postId"
          element={
            <>
              <Header />
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
