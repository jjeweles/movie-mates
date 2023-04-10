import {faFilm} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Spinner from "../components/Spinner";

function Community() {

    const [loading, setLoading] = useState(true);
    const [posts, setPosts] = useState([]);
    const [replies, setReplies] = useState([]);
    const {id} = useParams<{ id: string }>();
    const [user, setUser] = useState({} as any);

    useEffect(() => {
        fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/userposts/" + id)
            .then(res => res.json())
            .then(data => {
                setPosts(data.sort().reverse());
                setLoading(false);
            })

        fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/users/" + id)
            .then(res => res.json())
            .then(data => {
                setUser(data);
            })

    }, []);

    if (loading) {
        return <Spinner/>
    }

    return (
        <div className="flex flex-col min-h-fit py-2 mx-10">

            <div className="container lg bg-stone-800 border-stone-700 text-white rounded-lg">
                <div className="bg-stone-700 text-stone-400 flex justify-between gap-1.5 text-sm items-center p-1">
                    <div className="flex gap-1.5">
                        <FontAwesomeIcon icon={faFilm} size="xl"/>
                        <span className="font-bold">Community</span>
                        <span className="text-white">{user.username}'s Post History</span>
                    </div>
                </div>
                {posts.map((post: any) => (
                    <div className="flex flex-col gap-1.5 text-sm p-2" key={post.postID}>
                        <div className="flex gap-1.5">
                            <span className="font-bold text-stone-400 mr-1">{post.postID}</span>
                            <Link to={`/community/${post.postID}`}>{post.post_title}</Link>
                        </div>
                        <div className="flex gap-1.5 text-stone-400 text-xs ml-5">
                            <Link to={`/dashboard/${post.userID}`}>by {post.userID}</Link>
                        </div>
                    </div>
                ))}

            </div>

        </div>
    )

}

export default Community;