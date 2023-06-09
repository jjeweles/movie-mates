import Home from "./pages/Home";
import Footer from "./layout/Footer";
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Popular from "./pages/Popular";
import Header from "./layout/Header";
import TopRated from "./pages/TopRated";
import NowPlaying from "./pages/NowPlaying";
import Dashboard from "./pages/Dashboard";
import Login from "./pages/Login";
import Recommend from "./pages/Recommend";
import Register from "./pages/Register";
import Movie from "./pages/Movie";
import Search from "./pages/Search";
import './styles.css'
import MovieCard from "./components/MovieCard";
import Community from "./pages/Community";
import Post from "./pages/Post";
import Users from "./pages/Users";
import CommunityPost from "./pages/CommunityPost";
import CommunityUserPost from "./pages/CommunityUserPost";

function App() {

    return (
        <Router>
            <div className="bg-stone-900 max-w-screen min-h-screen px-6 font-lato">
                <Header/>
                <Routes>
                    <Route path="/" element={<Home />}/>
                    <Route path="/popular" element={<Popular/>} />
                    <Route path="/nowplaying" element={<NowPlaying/>} />
                    <Route path="/toprated" element={<TopRated/>} />
                    <Route path="/dashboard/:id" element={<Dashboard/>} />
                    <Route path="/friends/:id" element={<Dashboard/>} />
                    <Route path="/login" element={<Login/>} />
                    <Route path="/register" element={<Register/>} />
                    <Route path="/recommend/:id" element={<Recommend/>} />
                    <Route path="/movie/:id" element={<Movie/>} />
                    <Route path="/search/:query" element={<Search/>} />
                    <Route path="/moviecard" element={<MovieCard/>} />
                    <Route path="/community" element={<Community/>} />
                    <Route path="/users/" element={<Users/>} />
                    <Route path="/community/:id" element={<Post/>} />
                    <Route path="/community/post" element={<CommunityPost/>} />
                    <Route path="/community/user/:id" element={<CommunityUserPost/>} />
                    <Route path="*" element={<h1 className="text-white">404: Not Found</h1>} />
                </Routes>
                <Footer />
            </div>
        </Router>
    )
}

export default App
