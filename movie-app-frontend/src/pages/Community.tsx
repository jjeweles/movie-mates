import {faFilm} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link} from "react-router-dom";
import {useEffect, useState} from "react";
import Spinner from "../components/Spinner";

function Community() {

    const [loading, setLoading] = useState(true);
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/api/v1/posts")
            .then(response => response.json())
            .then(data => {
                setPosts(data.sort().reverse());
                setLoading(false);
            })

    }, []);

    if (loading) {
        return <Spinner/>
    }

    return (
        <div className="flex flex-col min-h-fit py-2 mx-10">

            <div className="container lg bg-amber-50 rounded">
                <div className="bg-orange-500 flex justify-between gap-1.5 text-sm items-center p-1">
                    <div className="flex gap-1.5">
                        <FontAwesomeIcon icon={faFilm} size="xl"/>
                        <span className="font-bold">Community</span>
                        <button className="hover:font-bold">newest</button>
                        |
                        <button className="hover:font-bold">oldest</button>
                        |
                        <button className="hover:font-bold">submit</button>
                    </div>
                </div>
                {posts.map((post: any) => (
                <div className="flex flex-col gap-1.5 text-sm p-2" key={post.postID}>
                    <div className="flex gap-1.5">
                        <span className="font-bold text-black/60 mr-1">{post.postID}</span>
                        <Link to="/community/1">{post.post_title}</Link>
                    </div>
                    <div className="flex gap-1.5 text-black/60 text-xs ml-5">
                        <Link to="/dashboard/1">by {post.userID}</Link>
                        |
                        <Link to="/community/1">comments</Link>
                    </div>
                </div>
                ))}

            </div>

        </div>
    )

}

export default Community;