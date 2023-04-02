import axios from "axios";
import {toast} from "react-toastify";

export const handleWatchList =  (e: any) => {
    const data = {
        tmdbID: e.target.value,
        userID: localStorage.getItem('user_id')
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

export const handleFavList = (e: any) => {
    const data = {
        tmdbId: e.target.value,
        userID: localStorage.getItem('user_id')
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