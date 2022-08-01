import "./App.css";
import "./bootstrap-4.0.0-dist/css/bootstrap.min.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavbarMain from "./Components/Navbar";
import Episode from "./Components/Episode";
import Data from "./Components/Data";
import HomePage from "./Components/HomePage";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavbarMain />
        <Routes>
          <Route exact path="/" element={<HomePage/>}></Route>
          <Route exact path="/episode" element={<Episode />}></Route>
          <Route exact path="/add" element={<Data/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
