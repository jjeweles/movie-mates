import React from 'react';

function Footer() {
    return (
        <div className="bg-stone-800">
            <div className="max-w-7xl mx-auto py-12 px-4 overflow-hidden sm:px-6 lg:px-8">
                <nav className="-mx-5 -my-2 flex flex-wrap justify-center" aria-label="Footer">
                    <div className="px-5 py-2">
                        <p className="text-stone-400">
                            Backend Made With <a href="https://spring.io/" className="text-stone-300 hover:text-white">Spring</a><br/>
                            Frontend Made With <a href="https://reactjs.org/" className="text-stone-300 hover:text-white">React</a>
                        </p>
                    </div>
                </nav>
                <div className="mt-4 flex justify-center text-xl text-bold text-white">
                    Built By:
                </div>
                <div className="mt-2 flex justify-center space-x-6">
                    <span className="text-stone-300 hover:text-white">
                        Justin
                    </span>
                    <span className="text-stone-300 hover:text-white">
                        Daytien
                    </span>
                    <span className="text-stone-300 hover:text-white">
                        Patrick
                    </span>
                    <span className="text-stone-300 hover:text-white">
                        Jesus
                    </span>
                    <span className="text-stone-300 hover:text-white">
                        Stephen
                    </span>
                </div>
            </div>
        </div>
    );
}

export default Footer;