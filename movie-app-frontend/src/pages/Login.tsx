import React from 'react';

function Login() {
    return (
        <div className="flex flex-col items-center justify-center">
            <div className="bg-stone-900 rounded-lg shadow-lg p-8 text-white">
                <h1 className="text-2xl font-bold mb-4">Login</h1>
                <form action="/dashboard/1" className="flex flex-col">
                    <label htmlFor="username" className="mb-2">Username</label>
                    <input type="text" id="username" className="mb-4 p-2 border border-gray-300 rounded-lg" />
                    <label htmlFor="password" className="mb-2">Password</label>
                    <input type="password" id="password" className="mb-4 p-2 border border-gray-300 rounded-lg" />
                    <button className="bg-blue-400/75 text-white p-2 rounded-lg">Login</button>
                </form>
            </div>
        </div>
    );
}

export default Login;