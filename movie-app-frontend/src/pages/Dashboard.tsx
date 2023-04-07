import React, {Fragment, useEffect, useRef, useState} from 'react';
import {Link, useParams} from "react-router-dom";
import axios from "axios";
import {getRandomOptions} from "../utils/bigheads";
import {getUserPosts, followFriend, unfollowFriend} from "../utils/utils";
import Spinner from "../components/Spinner";
import {toast, ToastContainer} from "react-toastify";
import {faUser, faCheckCircle} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {BigHead} from "@bigheads/core";

function Dashboard() {
    const [loading, setLoading] = useState(true);
    const [favList, setFavList] = useState<any[]>([]);
    const [watchList, setWatchList] = useState<any[]>([]);
    const [ratings, setRatings] = useState<any[]>([]);
    const [friends, setFriends] = useState<any[]>([]);
    const { id } = useParams<{ id: string }>();
    const userID = localStorage.getItem("user_id");
    let following = false;

    useEffect(() => {
        const fetchUserData = async () => {
            const userResponse = await fetch(`http://localhost:8080/api/v1/users/${id}`);
            const userData = await userResponse.json();
            localStorage.setItem('username', userData.username);
            localStorage.setItem('name', userData.name);
            localStorage.setItem('email', userData.email);
        }

        const fetchWatchListData = async () => {
            const watchListResponse = await fetch(`http://localhost:8080/api/v1/watchlist/${id}`);
            const watchListData = await watchListResponse.json();
            for (let i = 0; i < watchListData.length; i++) {
                const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${watchListData[i].tmdbID}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
                const movieData = await movieResponse.json();
                // @ts-ignore
                setWatchList(watchList => [...watchList, movieData]);
            }
        }

        const fetchFavData = async () => {
            const favListResponse = await fetch(`http://localhost:8080/api/v1/favList/${id}`);
            const favListData = await favListResponse.json();
            for (let i = 0; i < favListData.length; i++) {
                const movieResponse = await fetch(`https://api.themoviedb.org/3/movie/${favListData[i].tmdbId}?api_key=52107296ca5b59d71cb74cfb9ed7f144`)
                const movieData = await movieResponse.json();
                setFavList(favList => [...favList, movieData]);
            }
        }

        const fetchFriendsList = async () => {
            const friendsResponse = await fetch(`http://localhost:8080/api/v1/friendsList/${id}/get`);
            const friendsData = await friendsResponse.json();
            for (let i = 0; i < friendsData.length; i++) {
                setFriends(friends => [...friends, friendsData[i]])
            }
        }

        fetchFriendsList().then(() => null);
        fetchUserData().then(() => null);
        fetchFavData().then(() => null);
        fetchWatchListData().then(() => null);

        const timer = setTimeout(() => {
            setLoading(false);
        }, 1000);
    }, []);

    const handleWatchlistRemove = (e: any) => {
        const data = {
            tmdbID: e.target.dataset.value,
            userID: localStorage.getItem('user_id')
        }
        axios.delete(`http://localhost:8080/api/v1/watchlist/${data.userID}/${data.tmdbID}`)
            .then(res => {
                const timer = setTimeout(() => {
                    window.location.reload();
                }, 2000);
            })
        toast.success("Removing from watchlist...")
    }

    const handleFavlistRemove = (e: any) => {
        const data = {
            tmdbID: e.target.dataset.value,
            userID: localStorage.getItem('user_id')
        }
        axios.delete(`http://localhost:8080/api/v1/favList/delete/${data.userID}/${data.tmdbID}`)
            .then(res => {
                const timer = setTimeout(() => {
                    window.location.reload();
                }, 2000);
            })
        toast.success("Removing from favorites...")
    }

    const gotoFriend = (e: any) => {
        const friendID = e.currentTarget.getAttribute('data-value');
        window.location.href = `/friends/${friendID}`;
    }

    const user = {
        id: localStorage.getItem('user_id'),
        username: localStorage.getItem('username'),
        name: localStorage.getItem('name'),
        email: localStorage.getItem('email')
    }

    if (loading) {
        return <Spinner/>
    }

    // @ts-ignore
    return (
        <Fragment>
            <style>
                {`.bg-gradient-to-r {
                    background-image: linear-gradient(to bottom, #562200 0%, #B04701 100%);
                }
                    .bevel {
                    box-shadow:
                    inset 1px 1px 3px #1A202C,
                    inset -1px -1px 3px #51698FFF,
                    2px 2px 4px rgba(0, 0, 0, 0.25);
                }`}
            </style>
            <div className="flex flex-col text-center items-center sm:items-stretch sm:text-left sm:flex-row gap-10">
                <div className="flex flex-col flex-wrap text-center sm:text-left w-3/4 sm:w-80 h-fit p-6 text-white rounded-lg shadow-lg grid gap-3 bevel bg-gradient-to-r">
                    <div className="flex items-center justify-center sm:justify-start mb-4">
                        <FontAwesomeIcon icon={faUser} className="text-4xl"/>
                        {/* @ts-ignore */ }
                        <h2 className="text-lg font-bold ml-4">{user.name.charAt(0).toUpperCase() + user.name.slice(1)}'s Dashboard</h2>
                    </div>
                    <div className="grid gap-3 text-sm">
                        <div className="flex justify-between">
                            <strong>Username:</strong>
                            <span>{user.username}</span>
                        </div>
                        <div className="flex justify-between">
                            <strong>Email:</strong>
                            <span>{user.email}</span>
                        </div>
                        <div className="flex justify-between">
                            <strong>Movies to Watch:</strong>
                            <span>{watchList.length}</span>
                        </div>
                        <div className="flex justify-between">
                            <strong>Movies in Favorites:</strong>
                            <span>{favList.length}</span>
                        </div>
                        <div className="flex justify-between">
                            <strong>Average Rating:</strong>
                            <span>{ratings}</span>
                        </div>
                    </div>
                    <div className=" border-b border-b-white p-2"/>
                    <div className="flex items-center justify-center sm:justify-start">
                        <h2 className="text-lg font-bold">Friend's List</h2>
                    </div>
                    <div className="flex flex-wrap gap-3 text-sm mb-2">
                        {friends.map(friend => (
                            <div className="w-16 h-10 p-1 mb-3 rounded-full hover:cursor-pointer" onClick={gotoFriend} data-value={friend.friendId} key={friend.friendId}>
                                {/* @ts-ignore  */}
                                <BigHead {...getRandomOptions()}/>
                            </div>
                        ))}
                    </div>
                    <div className=" border-b border-b-white p-2"/>
                        <div className="flex items-center justify-center sm:justify-start mb-2">
                            <div className="flex gap-2 text-xs">
                                {userID === id ? null : (
                                    <>
                                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2" value={id} onClick={followFriend}>
                                            Follow
                                        </button>
                                        <button className="bg-stone-900 text-white rounded-lg px-4 py-2" value={id} onClick={unfollowFriend}>
                                            Unfollow
                                        </button>
                                    </>
                                )}
                                <button className="bg-stone-900 text-white rounded-lg px-4 py-2" value={id} onClick={getUserPosts}>
                                    See Posts
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
                                    theme="dark"
                                />
                            </div>
                        </div>
                </div>
                <div className="flex flex-col gap-4 text-stone-400">
                    <div className="mb-6">
                        <h2 className="text-2xl font-bold mb-4">Watchlist</h2>
                        <div className="grid grid-cols-2 sm:grid-cols-3 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 px-1">
                            {watchList.map(movie => (
                                <div className="bg-stone-900 rounded-lg p-3" key={movie.id}>
                                    <div className="flex flex-col items-center">
                                        <div className="w-32 h-48 rounded-lg bg-gray-400 relative">
                                            <Link to={`/movie/${movie.id}`}>
                                                <img src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`} alt="" className="rounded-lg static"/>
                                                {/*<p className="absolute -top-1 -left-2 text-sm font-bold bg-blue-400 rounded-full w-max p-1 text-black">8.1</p>*/}
                                            </Link>
                                            {user.id == id && (
                                                <>
                                                    <button
                                                        onClick={handleWatchlistRemove}
                                                        className="absolute -top-4 -right-4 text-sm font-bold bg-stone-400 rounded-full w-max p-1 text-black hover:bg-red-700 transition ease-in-out duration-200">
                                                        <svg
                                                            data-value={movie.id}
                                                            xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24">
                                                            <path d="M18.3 5.71a.996.996 0 0 0-1.41 0L12 10.59 7.11 5.7A.996.996 0 1 0 5.7 7.11L10.59 12 5.7 16.89a.996.996 0 1 0 1.41 1.41L12 13.41l4.89 4.89a.996.996 0 1 0 1.41-1.41L13.41 12l4.89-4.89c.38-.38.38-1.02 0-1.4z"/>
                                                        </svg>
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
                                                        theme="dark"
                                                    />
                                                </>
                                            )}
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="mb-6">
                        <h2 className="text-2xl font-bold mb-4">Favorites</h2>
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4 px-2">
                            {favList.map(movie => (
                                <div className="bg-stone-900 rounded-lg p-3" key={movie.id}>
                                    <div className="flex flex-col items-center">
                                        <div className="w-32 h-48 rounded-lg bg-gray-400 relative">
                                            <Link to={`/movie/${movie.id}`}>
                                                <img src={`https://image.tmdb.org/t/p/w500/${movie.poster_path}`} alt="" className="rounded-lg static"/>
                                                {/*<p className="absolute -bottom-1 -left-2 text-sm font-bold bg-blue-400 rounded-full w-max p-1 text-black">8.1</p>*/}
                                            </Link>
                                            {user.id == id && (
                                                <>
                                                    <button
                                                        onClick={handleFavlistRemove}
                                                        className="absolute -top-4 -right-4 text-sm font-bold bg-stone-400 rounded-full w-max p-1 text-black hover:bg-red-700 transition ease-in-out duration-200">
                                                        <svg
                                                            data-value={movie.id}
                                                            xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24">
                                                            <path d="M18.3 5.71a.996.996 0 0 0-1.41 0L12 10.59 7.11 5.7A.996.996 0 1 0 5.7 7.11L10.59 12 5.7 16.89a.996.996 0 1 0 1.41 1.41L12 13.41l4.89 4.89a.996.996 0 1 0 1.41-1.41L13.41 12l4.89-4.89c.38-.38.38-1.02 0-1.4z"/>
                                                        </svg>
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
                                                        theme="dark"
                                                    />
                                                </>
                                            )}
                                        </div>
                                    </div>
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </Fragment>

    );
}

export default Dashboard;