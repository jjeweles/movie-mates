import {Link} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import {addRating, handleFavList, handleRecommendation, handleWatchList} from "../utils/utils";
import React, {useState} from "react";
import {faBookmark, faCheckCircle} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

function MovCard(props: any) {
    const {movie, ratings} = props;

    return (
        <div className="flex flex-col justify-center bg-stone-900 rounded-lg p-4" key={movie.id}>
            <div className="flex flex-col items-center">
                <div className="w-36 h-48 rounded-lg bg-gray-400 mb-4">
                    <Link to={`/movie/${movie.id}`}>
                        <img src={"https://image.tmdb.org/t/p/w500" + movie.poster_path} alt="" className="rounded-lg static"/>
                    </Link>
                </div>
                <div className="text-center flex flex-col mt-6">
                    <div className="h-12">
                        <h1 className="sm:text-xs md:text-sm font-medium text-white">{movie.title}{' '}
                            <span className="text-xs text-gray-400">({movie.release_date.split('-')[0]})</span></h1>
                    </div>

                    <div className="flex flex-col md:flex-row text-xs">
                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleWatchList}>
                            <FontAwesomeIcon icon={faBookmark} size="sm" className="mr-2"/>
                            Watch List
                        </button>
                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleFavList}>
                            <FontAwesomeIcon icon={faCheckCircle} size="sm" className="mr-2"/>
                            Favorite
                        </button>
                    </div>
                    <div className="flex flex-col md:flex-row justify-center text-xs">
                        <button className="bg-stone-700 text-white rounded-lg px-4 py-2 mt-2 hover:bg-stone-700" value={movie.id} onClick={handleRecommendation}>
                            More Like This
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
            </div>
        </div>
    )
}

export default MovCard