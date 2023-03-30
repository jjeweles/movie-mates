import React from 'react';
import {Link} from "react-router-dom";

function Dashboard() {
    const user = {
        username: 'john doe',
        name: 'John Doe',
        email: 'john@doe.com'
    }

    const watchlist = [
        { id: 1, title: 'Movie 1' },
        { id: 2, title: 'Movie 2' },
        // ... more movies
    ];
    const favlist = [
        { id: 1, title: 'Movie 1' },
        { id: 2, title: 'Movie 2' },
        // ... more movies
    ];
    const history = [
        { id: 1, title: 'Movie 1' },
        { id: 2, title: 'Movie 2' },
        // ... more movies
    ];

    return (
        <div className="flex gap-10">
            <div className="w-64 h-fit p-6 text-stone-400 bg-stone-900/75 rounded-md grid gap-3">
                <h2 className="text-xl font-bold mb-4">User Information</h2>
                <div className="grid gap-3">
                    <p><strong>Username:</strong> {user.username}</p>
                    <p><strong>Name:</strong> {user.name}</p>
                    <p><strong>Email:</strong> {user.email}</p>
                </div>
            </div>
            <div className="flex flex-col gap-4 text-stone-400">
                <div className="mb-6">
                    <h2 className="text-2xl font-bold mb-4">Watchlist</h2>
                    <div className="flex gap-4">
                        {watchlist.map(movie => (
                            <div className="bg-stone-900 rounded-lg shadow-lg p-3">
                                <div className="flex flex-col items-center">
                                    <div className="w-32 h-48 rounded-lg bg-gray-400 mb-4">
                                        <img src={"https://image.tmdb.org/t/p/w500/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg"} alt="" className="rounded-lg static"/>
                                        {/*<div className="absolute top-36 left-50 rounded-bl-lg rounded-tr-lg p-2">*/}
                                        {/*    <p className="text-sm font-bold bg-blue-400 rounded-full p-1 text-black">8.1</p>*/}
                                        {/*</div>*/}
                                    </div>
                                    <div className="text-center flex flex-col">
                                        <div className="">
                                            <h1 className="text-lg font-medium text-white">{movie.title}</h1>
                                            <p className="text-sm text-gray-400">Release Date</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        ))}
                    </div>
                </div>
                <div className="mb-6">
                    <h2 className="text-2xl font-bold mb-4">Favorites</h2>
                    <div className="flex gap-4">
                        {favlist.map(movie => (
                            <div className="bg-stone-900 rounded-lg shadow-lg p-3">
                                <div className="flex flex-col items-center">
                                    <div className="w-32 h-48 rounded-lg bg-gray-400 mb-4">
                                        <img src={"https://image.tmdb.org/t/p/w500/gOnmaxHo0412UVr1QM5Nekv1xPi.jpg"} alt="" className="rounded-lg static"/>
                                        {/*<div className="absolute bottom-[182px] left-50 rounded-bl-lg rounded-tr-lg p-2">*/}
                                        {/*    <p className="text-sm font-bold bg-blue-400 rounded-full p-1 text-black">8.1</p>*/}
                                        {/*</div>*/}
                                    </div>
                                    <div className="text-center flex flex-col">
                                        <div className="">
                                            <h1 className="text-lg font-medium text-white">{movie.title}</h1>
                                            <p className="text-sm text-gray-400">Release Date</p>
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