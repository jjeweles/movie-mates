import React, {useEffect, useState} from 'react';
import {toast, ToastContainer} from "react-toastify";

function Register() {

    const [users, setUsers] = useState<any[]>([]);

    useEffect(() => {
        const getUsers = async () => {
            const response = await fetch('http://localhost:8080/api/v1/users');
            const data = await response.json();
            setUsers(data)
        }
        getUsers().then(() => null);
    }, []);

    const handleRegister = async (e: any) => {
        e.preventDefault();
        for (let i = 0; i < users.length; i++) {
            if (users[i].username === e.target[2].value) {
                toast.error('Username already exists')
                return;
            }
            if (users[i].email === e.target[1].value) {
                toast.error('Email already in use')
                return;
            }
        }
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
        setTimeout(() => {
            window.location.href = '/login';
        }, 3000);
        toast.success('Registration successful! Redirecting to login page...')
    }


    return (
        <div className="flex gap-10 items-center justify-center">

            <div className="bg-stone-900 rounded-lg p-8 text-white">
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
                    <button className="bg-orange-400/75 text-white p-2 rounded-lg" type="submit">Register</button>
                    <ToastContainer
                        position="top-right"
                        autoClose={false}
                        newestOnTop={false}
                        closeOnClick
                        rtl={false}
                        pauseOnFocusLoss
                        draggable
                        theme="dark"
                    />
                </form>
            </div>

        </div>
    );
}

export default Register;