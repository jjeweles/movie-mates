import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {handleWatchList, handleFavList, addRating} from "../utils/utils";
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
    const [modal, setModal] = useState(false);
    const [providers, setProviders] = useState<any>([]);
    const [rating, setRating] = useState<any>([]);
    const [ratings, setRatings] = useState<any>([]);

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

        const fetchRating = async () => {
            const ratingResponse = await fetch(`http://localhost:8080/api/v1/rating/getMovieAvgMovieRating/${id}`)
            const ratingsResponse = await fetch(`http://localhost:8080/api/v1/rating/getRatingsForMovie/${id}`)
            const ratingData = await ratingResponse.json();
            const ratingsData = await ratingsResponse.json();
            setRatings(ratingsData);
            setRating(ratingData);
        }

        fetchMovieData()
            .then(() => fetchTrailer())
            .then(() => fetchProviders())
            .then(() => fetchRating())

        const timer = setTimeout(() => {
            setLoading(false);
        }, 1000);
    }, []);

    const handleShowVideo = () => {
        setShowVideo(!showVideo);
    }

    const handleStarClick = (e: any) => {
        addRating(e).then(null);
        setModal(false);
    };

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
                    <div className="flex flex-row flex-wrap gap-3 mb-3">
                        {movie.genres.map((genre: any) => (
                            <span
                                key={genre.id}
                                className="bg-gray-100 text-gray-800 text-xs font-medium px-2.5 py-0.5 rounded-full dark:bg-gray-700 dark:text-gray-300">
                                {genre.name}
                            </span>
                            // <span
                            //     className="text-stone-200 text-xs lg:text-md lg:mb-4 bg-white/30 p-2 rounded-full"
                            //     key={genre.name}
                            // >
                            //     {genre.name}
                            // </span>
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
                    <div className="flex-grow mb-3">
                        <p className="text-xs text-gray-100 leading-snug truncate-overflow">

                            <div className="flex items-center">
                                <svg aria-hidden="true" className="w-5 h-5 text-yellow-400" fill="currentColor"
                                     viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><title>Rating star</title>
                                    <path
                                        d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
                                </svg>
                                <p className="ml-2 text-sm font-bold text-gray-900 dark:text-white">
                                    {isNaN(rating) ? 0 : rating - .25}
                                </p>
                                <span className="w-1 h-1 mx-1.5 bg-gray-500 rounded-full dark:bg-gray-400"></span>
                                <span
                                   className="text-xs font-medium text-gray-300">
                                    {ratings.length} Ratings
                                </span>
                                <span className="w-1 h-1 mx-1.5 bg-gray-500 rounded-full dark:bg-gray-400"></span>
                                <button
                                    onClick={() => setModal(true)}
                                    className="text-xs font-medium text-gray-300 underline hover:text-white hover:font-bold">
                                    Rate Movie
                                </button>
                            </div>
                            {modal && (
                                <div className="fixed z-10 inset-0 overflow-y-auto">
                                    <div className="flex items-end justify-center min-h-screen pt-4 px-4 pb-20 text-center sm:block sm:p-0">
                                        <div className="fixed inset-0 bg-gray-500 bg-opacity-5 transition-opacity"
                                             aria-hidden="true"></div>
                                        <span className="hidden sm:inline-block sm:align-middle sm:h-screen" aria-hidden="true">&#8203;</span>
                                        <div className="inline-block align-bottom bg-stone-800 rounded-lg px-4 pt-5 pb-4 text-left overflow-hidden shadow-xl transform transition-all sm:my-8 sm:align-middle sm:max-w-lg sm:w-full sm:p-6">
                                            <h3 className="text-lg leading-6 font-medium text-gray-400">
                                                Rate 1 - 5 stars
                                            </h3>
                                            <div className="mt-6 flex justify-center space-x-4">
                                                {[1, 2, 3, 4, 5].map((star) => (
                                                    <button key={star} className="w-8 h-8"
                                                            data-movieid={movie.id}
                                                            data-rating={star}
                                                            onClick={handleStarClick}>
                                                        <svg className="w-full h-full text-yellow-400" fill="currentColor">
                                                            <title>Rating star</title>
                                                            <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
                                                        </svg>
                                                    </button>
                                                ))}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            )}
                            <ToastContainer
                                position="top-center"
                                autoClose={1750}
                                hideProgressBar={false}
                                newestOnTop={false}
                                closeOnClick
                                rtl={false}
                                pauseOnFocusLoss={false}
                                draggable
                                pauseOnHover
                                theme="dark"
                            />

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
                            autoClose={1750}
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