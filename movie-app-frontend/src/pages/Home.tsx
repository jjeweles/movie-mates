import React from 'react';

function Home() {
    return (
        <div>
            {/* Hero section */}
            <div className="relative bg-stone-800">
                <div className="absolute inset-0">
                    <img className="w-full h-full object-cover grayscale opacity-20 rounded-2xl" src="https://images.unsplash.com/photo-1536440136628-849c177e76a1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1450&q=80" alt="Auto"/>
                </div>
                <div className="relative max-w-7xl mx-auto py-24 px-4 sm:py-32 sm:px-6 lg:px-8">
                    <h1 className="text-4xl font-extrabold tracking-tight text-white sm:text-5xl lg:text-4xl">Blues 2s Movie Reviews (And Recommendations)</h1>
                        <ul className="mt-6 max-w-3xl text-xl text-blue-200">
                            <li>Spring Boot and React App to rate and review your favorite movies.</li>
                            <li>Browse the list of movies in the database and find your next movie.</li>
                            <li>Store your favorite movies in your watchlist.</li>
                            <li>Save your favorite movies to your favorites list.</li>
                            <li>See what other users have to say about the movies you love.</li>
                        </ul>
                </div>
            </div>
        </div>
    );
}

export default Home;