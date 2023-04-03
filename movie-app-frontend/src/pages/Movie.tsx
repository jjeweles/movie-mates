import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {handleWatchList, handleFavList} from "../utils/utils";
import {faXmark} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {ToastContainer} from "react-toastify";
import Spinner from "../components/Spinner";

function Movie() {
    const {id} = useParams<{ id: string }>();
    const [movie, setMovie] = useState<any>([]);
    const [trailer, setTrailer] = useState<any>([]);
    const [showVideo, setShowVideo] = useState(false);
    const [loading, setLoading] = useState(true);
    const [providers, setProviders] = useState<any>([]);

    useEffect(() => {
        const fetchMovieData = async () => {
            const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${id}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
            const movieData = await movieResponse.json();
            setMovie(movieData);
        }

        const fetchTrailer = async () => {
            const trailerResponse = await fetch(`https://api.themoviedb.org/3/movie/${id}/videos?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
            const trailerData = await trailerResponse.json();
            for (let i = 0; i < trailerData.results.length; i++) {
                if (trailerData.results[i].name === "Official Trailer") {
                    setTrailer(trailerData.results[i].key);
                    break;
                }
            }
        }

        const fetchProviders = async () => {
            const providerResponse = await fetch(`https://api.themoviedb.org/3/movie/${id}/watch/providers?api_key=52107296ca5b59d71cb74cfb9ed7f144&language=en-us`)
            const providerData = await providerResponse.json();
            setProviders(providerData.results.US);
        }

        fetchMovieData()
            .then(() => fetchTrailer())
            .then(() => fetchProviders())

        const timer = setTimeout(() => {
            setLoading(false);
        }, 1000);
    }, []);

    console.log(providers);

    const handleShowVideo = () => {
        setShowVideo(!showVideo);
    }

    const trailerURL = `https://www.youtube.com/embed/${trailer}`;
    const backgroundImg = `https://image.tmdb.org/t/p/w500/${movie.backdrop_path}`

    if (loading) {
        return <Spinner/>;
    }

    return (
        <div className="relative flex flex-col items-center">
            <div className="relative w-full max-w-4xl rounded-2xl border border-black overflow-hidden shadow-lg m-4 flex flex-col md:flex-row justify-between">
                <div
                    className="absolute rounded-xl inset-0 bg-cover bg-center bg-no-repeat bg-gray-100 z-0"
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
                <div className="static flex flex-col flex-grow px-8 py-4 z-10">
                    <h3 className="font-bold text-2xl md:text-4xl lg:text-2xl text-gray-200 movie--title mb-2">
                        {movie.title} <span className="text-sm text-gray-400">({movie.release_date.split('-')[0]})</span>
                    </h3>
                    <div className="flex flex-row flex-wrap gap-3">
                        {movie.genres.map((genre: any) => (
                            <span
                                className="text-stone-200 text-xs lg:text-md lg:mb-4 bg-white/30 p-2 rounded-full"
                                key={genre.name}
                            >
                                {genre.name}
                            </span>
                        ))}
                    </div>
                    {providers && providers.flatrate && providers.flatrate.length > 0 && (
                        <div className="flex flex-row flex-wrap gap-3">
                            <p className="flex gap-3 items-center text-xs font-bold italic text-gray-100 leading-snug truncate-overflow">
                                Watch on: {providers?.flatrate?.map((provider: any) => (
                                // if providers is undefined, then it will not render the map function
                                // if providers > 1 last provider should be preceded by 'and' and not have a comma
                                <span className={provider.logo_path ? 'text-gray-100' : 'text-gray-500'} key={provider.provider_id}>
                                    {provider.logo_path ? (
                                        <img
                                            className="w-7 h-7 rounded-md"
                                            src={`https://image.tmdb.org/t/p/w500/${provider.logo_path}`}
                                            alt={provider.provider_name}
                                        />
                                    ) : (
                                        <span>{provider.provider_name}</span>
                                    )}
                                </span>
                            ))}
                            </p>
                        </div>
                    )}
                    <div className="flex-grow my-4">
                        <p className="text-base md:text-xl lg:text-base text-gray-100 leading-snug truncate-overflow">
                            {movie.overview}
                        </p>
                    </div>
                    <div className="button-container flex justify-between mb-2 mt-2 flex-col sm:flex-row sm:flex-wrap gap-1">
                        <button
                            className="text-sm md:text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 border text-white"
                            onClick={handleShowVideo}
                        >
                            {showVideo ? 'Close Trailer' : 'Watch Trailer'}
                        </button>
                        <button
                            className="text-sm md:text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 border text-white"
                            value={movie.id}
                            onClick={handleFavList}
                        >
                            Add to Favorites
                        </button>
                        <button
                            className="text-sm md:text-lg lg:text-sm font-bold py-2 px-4 rounded bg-stone-900 border text-white"
                            value={movie.id}
                            onClick={handleWatchList}
                        >
                            Add to Watch List
                        </button>
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
                {showVideo && (
                    <div
                        className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50"
                        onClick={handleShowVideo}>
                        <div
                            className="relative bg-white rounded-lg w-11/12 md:w-2/3 lg:w-2/3 h-2/3 overflow-hidden shadow-lg"
                            onClick={(e) => e.stopPropagation()}>
                            <button
                                className="absolute top-2 right-2 text-gray-500 hover:text-gray-700 focus:outline-none"
                                onClick={handleShowVideo}>
                                <FontAwesomeIcon icon={faXmark} size="2x"/>
                            </button>
                            <div className="w-full h-full pt-72 overflow-hidden relative">
                                <iframe
                                    className="absolute top-0 left-0 w-full h-full"
                                    src={`${trailerURL}?autoplay=1`}
                                    title="YouTube video player"
                                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                    allowFullScreen
                                ></iframe>
                            </div>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default Movie;