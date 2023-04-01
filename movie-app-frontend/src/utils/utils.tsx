import axios from "axios";

export const handleWatchList =  (e: any) => {
    const data = {
        tmdbID: e.target.value,
        userID: localStorage.getItem('user_id')
    }
    axios.post('http://localhost:8080/api/v1/watchlist/add', data)
        .then(res => {
            window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
        })
}

export const handleFavList = (e: any) => {
    const data = {
        tmdbId: e.target.value,
        userID: localStorage.getItem('user_id')
    }
    axios.post('http://localhost:8080/api/v1/favList/save/', data)
        .then(res => {
            window.location.href = `/dashboard/${localStorage.getItem('user_id')}`;
        })
}

export const handleRecommendation = (e: any) => {
    const query = e.target.value;
    window.location.href = `/recommend/${query}`;
}