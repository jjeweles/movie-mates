import axios from "axios";
import {toast} from "react-toastify";

export const handleWatchList = async (e: any) => {
    const data = {
        tmdbID: e.target.value,
        userID: localStorage.getItem('user_id')
    }

    const response = await fetch(`http://localhost:8080/api/v1/watchlist/${data.userID}`)
    const watchList = await response.json();

    for (let i = 0; i < watchList.length; i++) {
        if (watchList[i].tmdbID == data.tmdbID) {
            return toast.error("Movie already in Watch List");
        }
    }

    axios.post('http://localhost:8080/api/v1/watchlist/add', data)
        .then(res => {
            // code to pause for 3 seconds and then redirect to dashboard
            const timer = setTimeout(() => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            }, 3000);
        })
    toast.success("Adding to Watchlist");
}

export const handleFavList = async (e: any) => {
    const data = {
        tmdbId: e.target.value,
        userID: localStorage.getItem('user_id')
    }

    const response = await fetch(`http://localhost:8080/api/v1/favList/${data.userID}`)
    const favList = await response.json();

    for (let i = 0; i < favList.length; i++) {
        if (favList[i].tmdbId == data.tmdbId) {
            return toast.error("Movie already in Favorites");
        }
    }

    axios.post('http://localhost:8080/api/v1/favList/save/', data)
        .then(res => {
            const timer = setTimeout(() => {
                window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
            }, 3000);
        })
    toast.success("Adding to Favorites");
}

export const handleRecommendation = (e: any) => {
    const query = e.target.value;
    const timer = setTimeout(() => {
        window.location.href = `/recommend/${query}`;
    }, 2500);
    toast.info("Generating Recommendations");
}