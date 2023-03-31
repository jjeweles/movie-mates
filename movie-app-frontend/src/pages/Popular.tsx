import React, {useEffect, useState} from 'react';
import {Link} from "react-router-dom";
import axios from "axios";

function Popular() {

    const [movies, setMovies] = useState<any>(null);
    const [loading, setLoading] = useState(true);
    const [status, setStatus] = useState();
    useEffect(() => {
        const fetchMovies = async () => {
            const result = await axios.get('https://api.themoviedb.org/3/movie/popular?api_key=52107296ca5b59d71cb74cfb9ed7f144');

            if (result.status !== 200) {
                window.location.href = '/';
            }

            setMovies(result.data);
            setLoading(false);
            // @ts-ignore
            setStatus(result.status)

        }
        fetchMovies().then(null);
    }, []);

    const handleWatchList =  (e: any) => {
        const data = {
            tmdbID: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.post('http://localhost:8080/api/v1/watchlist/add', data)
            .then(res => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            })
    }

    const handleFavList = (e: any) => {
        const data = {
            tmdbID: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.post('http://localhost:8080/api/v1/favList/save', data)
            .then(res => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            })
    }

    if (loading) {
        return <div>Loading...</div>;
    }
    if (status !== 200) {
        return <div>Error</div>;
    }

    return (
        <div className="bg-stone-800 max-w-screen-xl px-6">
            <div className="flex flex-col">
                <div className="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
                            {movies.results.map((movie: any) => (
                                <div className="flex flex-col justify-center bg-stone-900 rounded-lg shadow-lg p-4" key={movie.id}>
                                    <div className="flex flex-col items-center">
                                        <div className="w-36 h-48 rounded-lg bg-gray-400 mb-4">
                                            <img src={"https://image.tmdb.org/t/p/w500" + movie.poster_path} alt="" className="rounded-lg static"/>
                                            {/*<div className="absolute bottom-50 left-50 bg-gray-900 bg-opacity-50 rounded-bl-lg rounded-tr-lg px-2 py-1">*/}
                                            {/*    <p className="text-sm font-bold bg-blue-400 rounded-full p-1 text-black">{movie.vote_average}</p>*/}
                                            {/*</div>*/}
                                        </div>
                                        <div className="text-center flex flex-col mt-6">
                                            <div className="">
                                                <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}</h1>
                                                <p className="text-xs text-gray-400">Released: {movie.release_date}</p>
                                            </div>
                                            <div className="text-xs">
                                                    <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700" value={movie.id} onClick={handleWatchList}>Watch List</button>
                                                    <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700" value={movie.id} onClick={handleFavList}>Favorite</button>
                                                    <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700">More Like This</button>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default Popular;