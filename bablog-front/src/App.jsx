import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Header from './components/Header';
import Signup from './pages/Signup';
import Login from './pages/Login';
import Posts from './pages/Posts';
import Detail from './pages/Detail';

function App() {
  return (
    <Router>
      <Routes>
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
              <Detail />
            </>
          }
        />
        <Route path="/" element={<Login />} />
        <Route path="/sign-up" element={<Signup />} />
      </Routes>
    </Router>
  );
}

export default App;
