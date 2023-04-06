import React, {useEffect, useState} from "react";
import Spinner from "../components/Spinner";
import {followFriend} from "../utils/utils";
import {ToastContainer} from "react-toastify";
import {Link} from "react-router-dom";

function Users() {

    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        fetch('http://localhost:8080/api/v1/users')
            .then(res => res.json())
            .then(data => {
                setUsers(data);
                setLoading(false);
            })

        if (localStorage.getItem('user_id')) {
            setIsLoggedIn(true);
        }
    }, [])

    if (loading) {
        return <Spinner/>
    }

    return (
        <div className="relative overflow-x-auto mx-0 sm:mx-20 rounded-lg">
            <table className="w-full text-sm text-left text-stone-500 dark:text-stone-400">
                <thead className="text-xs text-stone-700 uppercase bg-stone-50 dark:bg-stone-700 dark:text-stone-400">
                <tr>
                    <th scope="col" className="px-6 py-3">
                        Username
                    </th>
                    <th scope="col" className="px-6 py-3">
                        Name
                    </th>
                    <th scope="col" className="px-6 py-3">
                        Movies in WatchList
                    </th>
                    <th scope="col" className="px-6 py-3">
                        Movies Favorited
                    </th>
                    <th scope="col" className="px-6 py-3">
                        Posts
                    </th>
                    <th scope="col" className="px-6 py-3">
                        Follow
                    </th>
                </tr>
                </thead>
                <tbody>
                {users.map((user: any) => (
                    <tr className="bg-white border-b dark:bg-stone-800 dark:border-stone-700" key={user.userID}>
                        <th scope="row" className="px-6 py-4 font-medium text-stone-900 whitespace-nowrap dark:text-white">
                            <Link to={`/dashboard/${user.userID}`}>
                                {user.username}
                            </Link>
                        </th>
                        <td className="px-6 py-4">
                            {user.name}
                        </td>
                        <td className="px-6 py-4">
                            Coming Soon
                        </td>
                        <td className="px-6 py-4">
                            Coming Soon
                        </td>
                        <td className="px-6 py-4">
                            Coming Soon
                        </td>
                        <td className="px-6 py-4">
                            {isLoggedIn ? (
                                <button
                                    className="bg-stone-900 hover:bg-orange-500 transition linear duration-300 text-white font-bold py-2 px-4 rounded"
                                    value={user.userID}
                                    onClick={followFriend}
                                >
                                    Follow
                                </button>
                            ) : (
                                <button
                                    className="bg-stone-900 transition linear duration-300 text-white font-bold py-2 px-4 rounded opacity-40"
                                    disabled={true}
                                >
                                    Follow
                                </button>
                            )}
                            <ToastContainer
                                position="top-center"
                                autoClose={3000}
                                hideProgressBar={false}
                                newestOnTop={false}
                                closeOnClick
                                rtl={false}
                                pauseOnFocusLoss={false}
                                draggable
                                theme="dark"
                            />
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default Users