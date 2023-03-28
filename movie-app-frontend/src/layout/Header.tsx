import React from 'react';
import {Link} from "react-router-dom";

function Header() {

    const handleSubmit = (e: any) => {
        e.preventDefault();
        console.log(e);
        window.location.href = "/search?vin=" + e.target[0].value;
    }

    return (
        <div className="mb-8">
            <nav className="bg-stone-800">
                <div className="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8">
                    <div className="relative flex items-center justify-between h-16">
                        <div className="flex-1 flex items-center justify-center sm:items-stretch sm:justify-between">
                            <div className="flex-shrink-0 flex items-center">
                                {/* Auto SVG Logo */}
                                <svg className="h-8 w-8 text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path fillRule="evenodd" d="M2.5 3.5a.5.5 0 01.5-.5h13a.5.5 0 01.5.5v13a.5.5 0 01-.5.5h-13a.5.5 0 01-.5-.5v-13zm1 0v13h13v-13h-13z" clipRule="evenodd" />
                                    <path fillRule="evenodd" d="M6.5 6.5a.5.5 0 01.5-.5h6a.5.5 0 01.5.5v6a.5.5 0 01-.5.5h-6a.5.5 0 01-.5-.5v-6zm1 0v6h6v-6h-6z" clipRule="evenodd" />
                                </svg>
                                <span className="text-white text-2xl font-bold ml-2">Movie App</span>
                            </div>
                            <div className="hidden sm:block sm:ml-6">
                                <div className="flex space-x-4">
                                    <Link to="/" className="bg-stone-900 text-white px-3 py-2 rounded-md text-sm font-medium">Home</Link>
                                    <Link to="/movies" className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">All Movies</Link>
                                    <Link to="/user/{username}" className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">My Movies</Link>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>

        </div>
    );
}

export default Header;