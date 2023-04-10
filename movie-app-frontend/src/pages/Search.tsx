import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import Spinner from "../components/Spinner";
import MovCard from "../components/MovCard";

function Search() {

    const {query} = useParams<{ query: string }>();
    const [movies, setMovies] = useState<any[]>([]);
    const [loading, setLoading] = useState(true);
    const [ratings, setRatings] = useState<any>(null);

    useEffect(() => {
        const fetchQuery = async () => {
            const response = await fetch(`https://api.themoviedb.org/3/search/movie?api_key=52107296ca5b59d71cb74cfb9ed7f144&query=${query}`)
            const data = await response.json();
            setMovies(data);
            const timer = setTimeout(() => {
                setLoading(false);
            }, 1000);
        }

        const fetchRatings = async () => {
            const result = fetch(`https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/rating/get`)
                .then(response => response.json())
                .then(data => {
                        setRatings(data)
                    }
                );
        }

        fetchRatings().then(null);
        fetchQuery().then(() => null);
    }, []);

    if (loading) {
        return <Spinner/>;
    }

    return (

        <div className="bg-stone-900 max-w-screen-xl px-6">
            <div className="flex flex-col">
                <div className="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                    <div className="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-4">
                            {/* @ts-ignore */}
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

export default Search;