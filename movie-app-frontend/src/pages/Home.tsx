import React from 'react';
import {toast, ToastContainer} from "react-toastify";

function Home() {

    const handleSearch = (e: any) => {
        e.preventDefault();
        const query = e.target.query.value;
        const timer = setTimeout(() => {
            window.location.href = `/search/${query}`;
        }, 3000);
        toast.info("Searching for movies");
    }

    return (
        <div>
            <div className="relative bg-stone-800">
                <div className="absolute inset-0">
                    <img className="w-full h-full object-cover grayscale opacity-20 rounded-2xl" src="https://images.unsplash.com/photo-1536440136628-849c177e76a1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1450&q=80" alt="Auto" />
                </div>
                <div className="relative max-w-7xl mx-auto py-24 px-4 sm:py-32 sm:px-6 lg:px-8">
                    <h1 className="text-4xl font-extrabold tracking-tight text-white sm:text-5xl lg:text-4xl">Blues 2s Chews & Reviews </h1>
                    <div className="mt-6 max-w-3xl text-xl text-blue-200">
                        <ul>
                            <li>Spring Boot and React App to rate and review your favorite movies.</li>
                            <li>Browse the list of movies in the database and find your next movie.</li>
                            <li>Store your favorite movies in your watchlist.</li>
                            <li>Save your favorite movies to your favorites list.</li>
                            <li>See what other users have to say about the movies you love.</li>
                        </ul>
                        <div className="mt-6 relative w-full lg:w-1/2">
                            <form onSubmit={handleSearch}>
                                <label htmlFor="search" className="sr-only">Search</label>
                                <input className="w-full h-10 pl-3 pr-10 text-base text-gray-900 placeholder-gray-500 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-200 focus:border-transparent" type="text" name="query" id="search" placeholder="Search movies" />
                                <button className="absolute right-0 top-0 mt-2 mr-2" type="submit">
                                    <svg className="w-6 h-6 text-gray-600" fill="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M10 4a6 6 0 100 12 6 6 0 000-12zm0 2a4 4 0 110 8 4 4 0 010-8zm6 8l4 4-1.414 1.414L14.586 15h-.008l-.293-.293v-.006l1.414-1.414z" />
                                    </svg>
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
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    );
}

export default Home;