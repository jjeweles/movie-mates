import React from 'react';

function Login() {

    const handleLogin = async (e: any) => {
        e.preventDefault();
        const response = await fetch('http://localhost:8080/api/v1/users/get/' + e.target[0].value)
        const data = await response.json();
        console.log(data.userID);

        localStorage.setItem("user_id", data.userID);
        window.location.href = 'dashboard/' + data.userID;
    }

    const handleRegister = async (e: any) => {
        e.preventDefault();
        const data = {
            name: e.target[0].value,
            email: e.target[1].value,
            username: e.target[2].value,
            password: e.target[3].value
        }
        const response = await fetch('http://localhost:8080/api/v1/users/add', {
            method: 'POST',
            headers: {
                "Accept": "application/json, text/plain, */*", // It can be used to overcome cors errors
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data)
        })
    }

    return (
        <div className="flex gap-10 items-center justify-center">
            <div className="bg-stone-900 rounded-lg shadow-lg p-8 text-white">
                <h1 className="text-2xl font-bold mb-4">Login</h1>
                <form className="flex flex-col" onSubmit={handleLogin}>
                    <label htmlFor="username" className="mb-2">Username</label>
                    <input type="text" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <label htmlFor="password" className="mb-2">Password</label>
                    <input type="password" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <button className="bg-blue-400/75 text-white p-2 rounded-lg">Login</button>
                </form>
            </div>

            <div className="bg-stone-900 rounded-lg shadow-lg p-8 text-white">
                <h1 className="text-2xl font-bold mb-4">Register</h1>
                <form className="flex flex-col" onSubmit={handleRegister}>
                    <label htmlFor="name" className="mb-2">Name</label>
                    <input type="text" id="name" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <label htmlFor="email" className="mb-2">Email</label>
                    <input type="text" id="email" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <label htmlFor="username" className="mb-2">Username</label>
                    <input type="text" id="username" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <label htmlFor="password" className="mb-2">Password</label>
                    <input type="password" id="password" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <button className="bg-blue-400/75 text-white p-2 rounded-lg" type="submit">Register</button>
                </form>
            </div>
        </div>
    );
}

export default Login;