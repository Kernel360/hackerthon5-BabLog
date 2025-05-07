import { BrowserRouter, Routes, Route } from "react-router-dom";
import Signup from "./components/Signup";
export default function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/sign-up" element={<Signup />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}
