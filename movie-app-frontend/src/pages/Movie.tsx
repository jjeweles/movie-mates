import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";

function Movie() {
    const { id } = useParams<{ id: string }>();
    const [movie, setMovie] = useState<any>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {

        const fetchMovieData = async () => {
            const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${id}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
            const movieData = await movieResponse.json();
            setMovie(movieData);
        }

        fetchMovieData()
            .then(() => setLoading(false));
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
        return <div className="flex flex-col text-center text-white text-5xl">Loading...</div>;
    }

    return (
        // page to display movie details
        <div className="flex flex-col items-center">
            <div
                className="w-full md:w-full lg:w-3/4 max-w-4xl rounded-2xl border border-black overflow-hidden shadow-lg m-4 flex justify-between">
                <div className="md:flex-shrink-0">
                    <img className="md:w-56 h-full rounded-b-lg " src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`}  alt={movie.title}/>
                </div>
                <div className="flex flex-col flex-grow px-8 py-4 bg-color-333">
                    <h3 className="font-bold text-4xl md:text-2xl lg:text-2xl text-gray-200 movie--title">{movie.title}</h3>
                    <span className="movie--year text-stone-200 text-xl lg:text-sm lg:mb-4">{movie.release_date}</span>
                    <div className="flex flex-row gap-3">
                        {movie.genres.map((genre: any) => (
                                <span className="text-stone-200 text-xl lg:text-xs lg:mb-4 bg-stone-900 p-2 rounded-full">{genre.name}</span>
                        ))}
                    </div>
                    <div className="flex-grow">
                        <p className="text-xl md:text-base lg:text-base text-gray-100 leading-snug truncate-overflow">
                            {movie.overview}
                        </p>
                    </div>
                    <div className="button-container flex justify-between mb-2 mt-2">
                        <button
                            className="text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 text-white" value={movie.id} onClick={handleWatchList}>
                            Add to Favorites
                        </button>
                        <button
                            className="text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 text-white" value={movie.id} onClick={handleFavList}>
                            Add to Watch List
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Movie;