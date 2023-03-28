import Home from "./pages/Home";
import Footer from "./layout/Footer";
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import GetMovies from "./pages/GetMovies";
import Header from "./layout/Header";

function App() {

    return (
        <Router>
            <div className="bg-stone-800 max-w-screen-2xl h-screen px-6">
                <Header/>
                <Routes>
                    <Route path="/" element={<Home />}/>
                    <Route path="/movies" element={<GetMovies/>} />
                    <Route path="*" element={<h1>404: Not Found</h1>} />
                </Routes>
                <Footer />
            </div>
        </Router>
    )
}

export default App
