import React, {useEffect, useState} from 'react';
// import axios from "axios";
import {Link} from "react-router-dom";

function GetAutos() {

    // const [autos, setAutos] = useState<any[]>([]);
    // get json from api and parse it http://localhost:8080/api/autos/ with axios
    // useEffect(() => {
    //     axios.get('http://localhost:8080/api/autos/')
    //         .then((response) => {
    //                 setAutos(response.data.automobiles);
    //             }
    //         )
    // }, []);
    //
    // const handleDelete = async (e: any) => {
    //     e.preventDefault();
    //     await axios.delete('http://localhost:8080/api/autos/' + e.target.value);
    //     setAutos(autos.filter((auto) => auto.vin !== e.target.value));
    //     window.location.reload();
    // }

    return (
        <div className="bg-stone-800 max-w-screen-xl h-screen px-6">
            <div className="flex flex-col">
                <div className="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
                            <div className="bg-stone-900 rounded-lg shadow-lg p-4">
                                <div className="flex flex-col items-center">
                                    <div className="w-32 h-48 rounded-lg bg-gray-400 mb-4"></div>
                                    <div className="text-center">
                                        <h1 className="text-lg font-medium text-white">Movie Title</h1>
                                        <p className="text-sm text-gray-400">Movie Year</p>

                                        <Link to="/movies/1">
                                            <button className="bg-stone-900 text-white text-sm rounded-lg px-4 py-2 mt-4 hover:bg-stone-700">Watch List</button>
                                            <button className="bg-stone-900 text-white text-sm rounded-lg px-4 py-2 mt-4 hover:bg-stone-700">Favorite</button>
                                        </Link>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    );
}

export default GetAutos;