import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";

function Movie() {
    const {id} = useParams<{ id: string }>();
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

    const handleWatchList = (e: any) => {
        const data = {
            tmdbId: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.post('http://localhost:8080/api/v1/watchlist/add', data)
            .then(res => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            })
    }

    const handleFavList = (e: any) => {
        const data = {
            tmdbId: e.target.value,
            userID: localStorage.getItem('user_id')
        }
        axios.post('http://localhost:8080/api/v1/favList/save/', data)
            .then(res => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            })
    }

    const backgroundImg = `https://image.tmdb.org/t/p/w500/${movie.backdrop_path}`

    if (loading) {
        return <div className="flex flex-col text-center text-white text-5xl">Loading...</div>;
    }

    return (
        <div className="relative flex flex-col items-center">
            <div className="relative w-full max-w-4xl rounded-2xl border border-black overflow-hidden shadow-lg m-4 flex flex-col md:flex-row justify-between">
                <div
                    className="absolute rounded-xl inset-0 bg-cover bg-center bg-no-repeat bg-gray-100"
                    style={{
                        backgroundImage: `url(${backgroundImg})`,
                        filter: 'grayscale(100%)',
                        opacity: '0.1',
                    }}
                ></div>
                <div className="md:flex-shrink-0">
                    <img
                        className="w-full h-64 object-cover object-center md:w-56 md:h-full rounded-b-lg md:rounded-b-none"
                        src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`}
                        alt={movie.title}
                    />
                </div>
                <div className="flex flex-col flex-grow px-8 py-4 z-50">
                    <h3 className="font-bold text-2xl md:text-4xl lg:text-2xl text-gray-200 movie--title">
                        {movie.title}
                    </h3>
                    <span className="movie--year text-stone-200 text-lg lg:text-sm lg:mb-4">
                        {movie.release_date}
                    </span>
                    <div className="flex flex-row flex-wrap gap-3">
                        {movie.genres.map((genre: any) => (
                            <span
                                className="text-stone-200 text-xs lg:text-md lg:mb-4 bg-stone-900 p-2 rounded-full"
                                key={genre.name}
                            >
                                {genre.name}
                            </span>
                        ))}
                    </div>
                    <div className="flex-grow">
                        <p className="text-base md:text-xl lg:text-base text-gray-100 leading-snug truncate-overflow">
                            {movie.overview}
                        </p>
                    </div>
                    <div className="button-container flex justify-between mb-2 mt-2 flex-wrap">
                        <button
                            className="text-sm md:text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 text-white mb-2 md:mb-0"
                            value={movie.id}
                            onClick={handleFavList}
                        >
                            Add to Favorites
                        </button>
                        <button
                            className="text-sm md:text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 text-white"
                            value={movie.id}
                            onClick={handleWatchList}
                        >
                            Add to Watch List
                        </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Movie;