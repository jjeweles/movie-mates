import Home from "./pages/Home";
import Footer from "./layout/Footer";
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Popular from "./pages/Popular";
import Header from "./layout/Header";
import TopRated from "./pages/TopRated";
import NowPlaying from "./pages/NowPlaying";

function App() {

    return (
        <Router>
            <div className="bg-stone-800 max-w-screen-2xl min-h-screen px-6">
                <Header/>
                <Routes>
                    <Route path="/" element={<Home />}/>
                    <Route path="/popular" element={<Popular/>} />
                    <Route path="/nowplaying" element={<NowPlaying/>} />
                    <Route path="/toprated" element={<TopRated/>} />
                    <Route path="*" element={<h1 className="text-white">404: Not Found</h1>} />
                </Routes>
                <Footer />
            </div>
        </Router>
    )
}

export default App
