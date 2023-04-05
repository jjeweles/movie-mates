import {Link} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import {addRating, handleFavList, handleRecommendation, handleWatchList} from "../utils/utils";
import React, {useState} from "react";

function MovCard(props: any) {
    const {movie, ratings} = props;
    const [modal, setModal] = useState(false);

    const handleStarClick = (e: any) => {
        addRating(e).then(null);
        setModal(false);
    };

    return (
        <div className="flex flex-col justify-center bg-stone-900 rounded-lg p-4" key={movie.id}>
            <div className="flex flex-col items-center">
                <div className="w-36 h-48 rounded-lg bg-gray-400 mb-4">
                    <Link to={`/movie/${movie.id}`}>
                        <img src={"https://image.tmdb.org/t/p/w500" + movie.poster_path} alt="" className="rounded-lg static"/>
                    </Link>
                </div>
                <div className="text-center flex flex-col mt-6">
                    <div className="">
                        <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}{' '}
                            <span className="text-xs text-gray-400">({movie.release_date.split('-')[0]})</span></h1>
                    </div>

                    {ratings.map((rating: any) => {
                        if (rating.tmdbId === movie.id) {
                            return (
                                <div className="flex items-center justify-center mt-2" key={rating.ratingId}>
                                    <svg aria-hidden="true" className="w-5 h-5 text-yellow-400"
                                         fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg"><title>Rating star</title>
                                        <path
                                            d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
                                    </svg>
                                    <p className="ml-2 text-sm font-bold text-gray-900 dark:text-white">{rating.starRating * 2 - .23}</p>
                                    <span
                                        className="w-1 h-1 mx-1.5 bg-gray-500 rounded-full dark:bg-gray-400"></span>
                                    <button
                                        className="text-sm font-medium text-gray-900 underline dark:text-white" onClick={() => setModal(true)}>Add Rating</button>
                                </div>
                            )
                        }
                    })}

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

                    <div className="text-xs">
                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleWatchList}>Watch List</button>
                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleFavList}>Favorite</button>
                        <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleRecommendation}>More Like This</button>
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
    )
}

export default MovCard