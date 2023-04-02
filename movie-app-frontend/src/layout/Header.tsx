import React from 'react';
import {Link} from "react-router-dom";

function Header() {

    const userID = localStorage.getItem("user_id");
    const [isMobileMenuOpen, setIsMobileMenuOpen] = React.useState(false);

    const handleLogout = () => {
        localStorage.clear();
        window.location.href = "/";
    }

    const closeMobileMenu = () => {
        setIsMobileMenuOpen(false);
    };

    const handleClick = () => {
        closeMobileMenu();
        handleLogout();
    }

    return (
        <div className="mb-8">
            <nav className="bg-stone-800">
                <div className="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8">
                    <div className="relative flex items-center justify-between h-16">
                        <div className="flex-1 flex items-center justify-between">
                            <div className="bg-stone-900 text-white px-3 py-2 rounded-md flex-shrink-0 flex items-center">
                                {/* Auto SVG Logo */}
                                <svg className="h-8 w-8 text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                    <path fillRule="evenodd" d="M2.5 3.5a.5.5 0 01.5-.5h13a.5.5 0 01.5.5v13a.5.5 0 01-.5.5h-13a.5.5 0 01-.5-.5v-13zm1 0v13h13v-13h-13z" clipRule="evenodd" />
                                    <path fillRule="evenodd" d="M6.5 6.5a.5.5 0 01.5-.5h6a.5.5 0 01.5.5v6a.5.5 0 01-.5.5h-6a.5.5 0 01-.5-.5v-6zm1 0v6h6v-6h-6z" clipRule="evenodd" />
                                </svg>
                                {/*<span className="text-white text-2xl font-bold ml-2">Movie App</span>*/}
                                <Link to="/" className="text-2xl font-medium">Movie App</Link>
                            </div>
                            <div className="hidden sm:block sm:ml-6">
                                <div className="flex space-x-4">
                                    <Link to="/popular" className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Popular</Link>
                                    <Link to="/nowplaying" className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Now Playing</Link>
                                    <Link to="/toprated" className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Top Rated</Link>
                                    {userID && userID !== "undefined" ?
                                        <Link to={`/dashboard/${userID}`} className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Dashboard</Link>
                                        : null}
                                    {userID == null || userID === "undefined" ?
                                        <>
                                            <Link to="/login"
                                                className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Login</Link>
                                            <Link to="/register"
                                            className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium">Register</Link>
                                        </>
                                        : null}
                                    {userID && userID !== "undefined" ?
                                    <button className="text-stone-300 hover:bg-stone-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium" onClick={handleLogout}>Logout</button>
                                    : null}
                                </div>
                            </div>
                            {/*  Mobile Navigation  */}
                            <div className="fixed top-0 right-0 z-10 mr-2 sm:hidden flex flex-col">
                                <button type="button" onClick={() => setIsMobileMenuOpen(!isMobileMenuOpen)}
                                        className="fixed top-0 right-0  mt-2 mr-2 w-fit bg-stone-800 inline-flex items-center justify-center p-2 rounded-md text-stone-400 hover:text-white hover:bg-stone-700 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-0" aria-controls="mobile-menu" aria-expanded="false">
                                    <span className="sr-only">Open main menu</span>
                                    <svg className="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16M4 18h16" />
                                    </svg>
                                    <svg className="hidden h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
                                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12" />
                                    </svg>
                                </button>

                                <div className={`${isMobileMenuOpen ? 'block' : 'hidden'} sm:hidden bg-stone-800 p-4 rounded-lg transition duration-300 ease-in-out`} id="mobile-menu">
                                    <div className="w-screen h-screen text-center px-2 space-y-10 z-50 relative divide-y divide-y-reverse divide-dashed">
                                        <Link to="/" className="text-left text-blue-200 hover:bg-stone-700 hover:text-white block ml-6 rounded-md text-xl font-medium" onClick={closeMobileMenu}>
                                            <svg className="h-8 w-8 text-white" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                                                <path fillRule="evenodd" d="M2.5 3.5a.5.5 0 01.5-.5h13a.5.5 0 01.5.5v13a.5.5 0 01-.5.5h-13a.5.5 0 01-.5-.5v-13zm1 0v13h13v-13h-13z" clipRule="evenodd" />
                                                <path fillRule="evenodd" d="M6.5 6.5a.5.5 0 01.5-.5h6a.5.5 0 01.5.5v6a.5.5 0 01-.5.5h-6a.5.5 0 01-.5-.5v-6zm1 0v6h6v-6h-6z" clipRule="evenodd" />
                                            </svg>
                                        </Link>
                                        <Link to="/popular" className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Popular</Link>
                                        <Link to="/nowplaying" className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Now Playing</Link>
                                        <Link to="/toprated" className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Top Rated</Link>
                                        {userID && userID !== "undefined" ?
                                            <Link to={`/dashboard/${userID}`} className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Dashboard</Link>
                                            : null}
                                        {userID == null || userID === "undefined" ?
                                            <>
                                                <Link to="/login" className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Login</Link>
                                                <Link to="/register" className="text-stone-300 hover:bg-stone-700 hover:text-white block ml-10 px-3 py-2 rounded-md text-2xl font-medium" onClick={closeMobileMenu}>Register</Link>
                                            </>
                                            : null}
                                        {userID && userID !== "undefined" ?
                                            <button className="text-stone-300 hover:bg-stone-700 hover:text-white ml-10 text-center px-3 py-2 rounded-md text-2xl font-medium" onClick={handleClick}>Logout</button>
                                            : null}
                                    </div>
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