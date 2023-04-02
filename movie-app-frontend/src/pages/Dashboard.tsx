import React, {useEffect, useState} from 'react';
import {Link, useParams} from "react-router-dom";
import axios from "axios";
import Spinner from "../components/Spinner";

function Dashboard() {
    const [loading, setLoading] = useState(true);
    const [favList, setFavList] = useState<any[]>([]);
    const [watchList, setWatchList] = useState<any[]>([]);
    const [ratings, setRatings] = useState<any[]>([]);
    const { id } = useParams<{ id: string }>();
    const userID = localStorage.getItem("user_id");

    useEffect(() => {
        const fetchUserData = async () => {
            const userResponse = await fetch(`http://localhost:8080/api/v1/users/${userID}`);
            const userData = await userResponse.json();
            localStorage.setItem('username', userData.username);
            localStorage.setItem('name', userData.name);
            localStorage.setItem('email', userData.email);

        }

        const fetchWatchListData = async () => {
            const watchListResponse = await fetch(`http://localhost:8080/api/v1/watchlist/${userID}`);
            const watchListData = await watchListResponse.json();
            for (let i = 0; i < watchListData.length; i++) {
                const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${watchListData[i].tmdbID}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
                const movieData = await movieResponse.json();
                // @ts-ignore
                setWatchList(watchList => [...watchList, movieData]);
            }
        }

        const fetchFavData = async () => {
            const favListResponse = await fetch(`http://localhost:8080/api/v1/favList/${userID}`);
            const favListData = await favListResponse.json();
            for (let i = 0; i < favListData.length; i++) {
                const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${favListData[i].tmdbId}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
                const movieData = await movieResponse.json();
                setFavList(favList => [...favList, movieData]);
            }
        }

        fetchUserData().then(() => null);
        fetchFavData().then(() => null);
        fetchWatchListData().then(() => null);

        const timer = setTimeout(() => {
            setLoading(false);
        }, 1000);
    }, []);

    const handleWatchlistRemove = (e: any) => {
        const data = {
            tmdbID: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.delete(`http://localhost:8080/api/v1/watchlist/${data.userID}/${data.tmdbID}`)
            .then(res => {
                window.location.reload();
            })
    }

    const handleFavlistRemove = (e: any) => {
        const data = {
            tmdbID: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.delete(`http://localhost:8080/api/v1/favList/delete/${data.userID}/${data.tmdbID}`)
            .then(res => {
                window.location.reload();
            })
    }

    const user = {
        username: localStorage.getItem('username'),
        name: localStorage.getItem('name'),
        email: localStorage.getItem('email')
    }

    // const history = [
    //     { id: 1, title: 'Movie 1' },
    //     { id: 2, title: 'Movie 2' },
    //     // ... more movies
    // ];

    if (loading) {
        return <Spinner/>
    }

    // @ts-ignore
    return (
        <div className="flex flex-col text-center items-center sm:items-stretch sm:text-left sm:flex-row gap-10">
            <div className="text-center sm:text-left w-64 h-fit p-6 text-stone-400 bg-stone-900/75 rounded-md grid gap-3">
                <h2 className="text-md font-bold mb-4">User Information</h2>
                <div className="grid gap-3 text-sm">
                    <p><strong>Username:</strong><br/> {user.username}</p>
                    <p><strong>Name:</strong><br/> {user.name}</p>
                    <p><strong>Email:</strong><br/> {user.email}</p>
                </div>
            </div>
            <div className="flex flex-col gap-4 text-stone-400">
                <div className="mb-6">
                    <h2 className="text-2xl font-bold mb-4">Watchlist</h2>
                    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 px-12">
                        {watchList.map(movie => (
                            <div className="flex flex-col justify-center bg-stone-900 rounded-lg shadow-lg p-4" key={movie.id}>
                                <div className="flex flex-col items-center">
                                    <div className="w-36 h-48 rounded-lg bg-gray-400 mb-4 relative">
                                        <Link to={`/movie/${movie.id}`}>
                                            <img src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`} alt="" className="rounded-lg static"/>
                                            <p className="absolute -top-1 -left-2 text-sm font-bold bg-blue-400 rounded-full w-max p-1 text-black">8.1</p>
                                        </Link>
                                    </div>
                                    <div className="text-center flex flex-col mt-6">
                                        <div className="">
                                            <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}</h1>
                                        </div>
                                        <div className="text-xs">
                                            <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-4 hover:bg-red-700"
                                                    value={movie.id} onClick={handleWatchlistRemove}>
                                                Remove
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="mb-6">
                    <h2 className="text-2xl font-bold mb-4">Favorites</h2>
                    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 px-12">
                        {favList.map(movie => (
                            <div className="bg-stone-900 rounded-lg shadow-lg p-3" key={movie.id}>
                                <div className="flex flex-col items-center">
                                    <div className="w-32 h-48 rounded-lg bg-gray-400 mb-4 relative">
                                        <Link to={`/movie/${movie.id}`}>
                                            <img src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`} alt="" className="rounded-lg static"/>
                                            <p className="absolute -top-1 -left-2 text-sm font-bold bg-blue-400 rounded-full w-max p-1 text-black">8.1</p>
                                            {/*<p className="absolute -bottom-1 -right-2 text-sm font-bold bg-stone-400 rounded-full w-max p-1 text-black">8.1</p>*/}
                                        </Link>
                                    </div>
                                    <div className="text-center flex flex-col mt-6">
                                        <div className="">
                                            <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}</h1>
                                        </div>
                                        <div className="text-xs">
                                            <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-4 hover:bg-red-700"
                                                    value={movie.id} onClick={handleFavlistRemove}>
                                                Remove
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                {/*<div className="mb-6">*/}
                {/*    <h2 className="text-2xl font-bold mb-4">History</h2>*/}
                {/*    <div className="flex gap-4">*/}
                {/*        {history.map(movie => (*/}
                {/*            <div className="bg-stone-900 rounded-lg shadow-lg p-3">*/}
                {/*                <div className="flex flex-col items-center">*/}
                {/*                    <div className="w-32 h-48 rounded-lg bg-gray-400 mb-4">*/}
                {/*                        <img src={"https://image.tmdb.org/t/p/w500/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg"} alt="" className="rounded-lg static"/>*/}
                {/*                        /!*<div className="absolute -bottom-[184px] left-50 rounded-bl-lg rounded-tr-lg p-2">*!/*/}
                {/*                        /!*    <p className="text-sm font-bold bg-blue-400 rounded-full p-1 text-black">8.1</p>*!/*/}
                {/*                        /!*</div>*!/*/}
                {/*                    </div>*/}
                {/*                    <div className="text-center flex flex-col">*/}
                {/*                        <div className="">*/}
                {/*                            <h1 className="text-lg font-medium text-white">{movie.title}</h1>*/}
                {/*                            <p className="text-sm text-gray-400">Release Date</p>*/}
                {/*                        </div>*/}
                {/*                    </div>*/}
                {/*                </div>*/}
                {/*            </div>*/}
                {/*        ))}*/}
                {/*    </div>*/}
                {/*</div>*/}
            </div>
        </div>
    );
}

export default Dashboard;