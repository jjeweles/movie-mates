import React, {useEffect, useState} from 'react';
import {Link, useParams} from "react-router-dom";
import {handleRecommendation, handleFavList, handleWatchList} from "../utils/utils";
import {ToastContainer} from "react-toastify";

function Search() {

    const {query} = useParams<{ query: string }>();
    const [movies, setMovies] = useState<any[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        const fetchQuery = async () => {
            const response = await fetch(`https://api.themoviedb.org/3/search/movie?api_key=52107296ca5b59d71cb74cfb9ed7f144&query=${query}`)
            const data = await response.json();
            setMovies(data);

            const timer = setTimeout(() => {
                setLoading(false);
            }, 1000);
        }

        fetchQuery().then(() => null);
    }, []);

    if (loading) {
        return <div className="flex flex-col text-center text-white text-5xl">Loading...</div>;
    }

    return (

        <div className="bg-stone-800 max-w-screen-xl px-6">
            <div className="flex flex-col">
                <div className="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
                            {/* @ts-ignore */}
                            {movies.results.map((movie: any) => (
                                <div className="flex flex-col justify-center bg-stone-900 rounded-lg shadow-lg p-4" key={movie.id}>
                                    <div className="flex flex-col items-center">
                                        <div className="w-36 h-48 rounded-lg bg-gray-400 mb-4">
                                            <Link to={`/movie/${movie.id}`}>
                                                <img src={"https://image.tmdb.org/t/p/w500" + movie.poster_path} alt="" className="rounded-lg static"/>
                                                {/*<div className="absolute bottom-50 left-50 bg-gray-900 bg-opacity-50 rounded-bl-lg rounded-tr-lg px-2 py-1">*/}
                                                {/*    <p className="text-sm font-bold bg-blue-400 rounded-full p-1 text-black">{movie.vote_average}</p>*/}
                                                {/*</div>*/}
                                            </Link>
                                        </div>
                                        <div className="text-center flex flex-col mt-6">
                                            <div className="">
                                                <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}</h1>
                                                <p className="text-xs text-gray-400">Released: {movie.release_date}</p>
                                            </div>
                                            <div className="text-xs">
                                                <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700" value={movie.id} onClick={handleWatchList}>Watch List</button>
                                                <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700" value={movie.id} onClick={handleFavList}>Favorite</button>
                                                <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-4 hover:bg-stone-700" value={movie.id} onClick={handleRecommendation}>More Like This</button>
                                                <ToastContainer
                                                    position="top-center"
                                                    autoClose={3000}
                                                    hideProgressBar={false}
                                                    newestOnTop={false}
                                                    closeOnClick
                                                    rtl={false}
                                                    pauseOnFocusLoss={false}
                                                    draggable
                                                    pauseOnHover
                                                    theme="dark"
                                                />
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

export default Search;