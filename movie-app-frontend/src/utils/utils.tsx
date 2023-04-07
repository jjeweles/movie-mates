import axios from "axios";
import {toast} from "react-toastify";

export const handleWatchList = async (e: any) => {
    const data = {
        tmdbID: e.target.value,
        userID: localStorage.getItem('user_id')
    }

    if (localStorage.getItem('user_id') == null) {
        toast.error("Please login to add to Watch List");
        return window.location.href = '/login';
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

    if (localStorage.getItem('user_id') == null) {
        toast.error("Please login to add to Favorites");
        return window.location.href = '/login';
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

export const followFriend = (e: any) => {
    const data = {
        userId: localStorage.getItem('user_id'),
        friendId: e.target.value
    }

    if (data.userId == data.friendId) {
        toast.error("You can't follow yourself");
        const timer = setTimeout(() => {
            return null;
        }, 2000);
    } else {

        axios.post(`http://localhost:8080/api/v1/friendsList/add`, data)
            .then(res => {
                const timer = setTimeout(() => {
                    window.location.href = `/dashboard/${data.userId}`
                }, 2000);
            })
        toast.success("Following friend...")

    }
}

export const unfollowFriend = (e: any) => {
    const data = {
        userId: localStorage.getItem('user_id'),
        friendId: e.target.value
    }
    axios.delete(`http://localhost:8080/api/v1/friendsList/delete/${data.userId}/${data.friendId}`)
        .then(res => {
            const timer = setTimeout(() => {
                window.location.href = `/dashboard/${data.userId}`
            }, 2000);
        })
    toast.success("Unfollowing friend...")
}

export const getUserPosts = async (e: any) => {
    window.location.href = `/community/user/${e.currentTarget.value}`
}

export const addRating = async (e: any) => {
    const data = {
        userID: localStorage.getItem('user_id'),
        starRating: e.currentTarget.getAttribute('data-rating'),
        tmdbId: e.currentTarget.getAttribute('data-movieid')
    }
    axios.post(`http://localhost:8080/api/v1/rating/save`, data)
        .then(res => {
                const timer = setTimeout(() => {
                    window.location.reload();
                }, 2000);
            }
        )
    toast.success("Rating added...")
}