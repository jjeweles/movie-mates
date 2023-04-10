import React from 'react';
import {toast, ToastContainer} from "react-toastify";

function Login() {

    const handleLogin = async (e: any) => {
        e.preventDefault();
        const formData = {
            username: e.target[0].value,
            password: e.target[1].value
        }
        const response = await fetch('https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/users/get/' + formData.username)
        const data = await response.json();
        if (data.password !== formData.password) {
            return toast.error("Incorrect Password");
        }

        localStorage.setItem("user_id", data.userID);
        const timer = setTimeout(() => {
            window.location.href = 'dashboard/' + data.userID;
        }, 3000);
        toast.success("Success! Redirecting to Dashboard");
    }

    return (
        <div className="flex gap-10 items-center justify-center">
            <div className="bg-stone-900 rounded-lg p-8 text-white">
                <h1 className="text-2xl font-bold mb-4">Login</h1>
                <form className="flex flex-col" onSubmit={handleLogin}>
                    <label htmlFor="username" className="mb-2">Username</label>
                    <input type="text" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <label htmlFor="password" className="mb-2">Password</label>
                    <input type="password" className="mb-4 p-2 border border-gray-300 rounded-lg text-black" />
                    <button className="bg-orange-400/75 text-white p-2 rounded-lg">Login</button>
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
                </form>
            </div>
        </div>
    );
}

export default Login;