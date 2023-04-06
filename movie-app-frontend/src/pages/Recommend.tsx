import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useParams} from "react-router-dom";
import Spinner from "../components/Spinner";
import MovCard from "../components/MovCard";

function Recommend() {

    const [movies, setMovies] = useState<any>(null);
    const [singleMovie, setSingleMovie] = useState<any>(null);
    const [loading, setLoading] = useState(true);
    const [ratings, setRatings] = useState<any>(null);
    let { id } = useParams();

    useEffect(() => {
        const fetchMovies = async () => {
            const result = await axios.get('https://api.themoviedb.org/3/movie/' + id + '/recommendations?api_key=52107296ca5b59d71cb74cfb9ed7f144');
            setMovies(result.data);
        }

        const fetchSingleMovie = async () => {
            const result = await fetch(`https://api.themoviedb.org/3/movie/${id}?api_key=52107296ca5b59d71cb74cfb9ed7f144`);
            const data = await result.json();
            setSingleMovie(data);

            const timer = setTimeout(() => {
                setLoading(false);
            }, 1000);
        }

        const fetchRatings = async () => {
            const result = fetch(`http://localhost:8080/api/v1/rating/get`)
                .then(response => response.json())
                .then(data => {
                        setRatings(data)
                    }
                );
        }

        fetchRatings().then(null);
        fetchMovies().then(() => null);
        fetchSingleMovie().then(() => null);
    }, []);

    if (loading) {
        return <Spinner/>;
    }

    return (
        <div className="bg-stone-900 max-w-screen-xl px-6">
            <div className="text-stone-400 text-center text-2xl mb-3 bg-stone-900 w-full p-2 rounded-full">Movies similiar to <span className="text-[#FFBC93FF] italic font-bold">{singleMovie.title}</span></div>
            <div className="flex flex-col">
                <div className="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
                            {movies.results.map((movie: any) => (
                                <MovCard movie={movie} ratings={ratings} key={movie.id}/>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Recommend;