import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFilm, faSignsPost, faArrowsUpToLine} from "@fortawesome/free-solid-svg-icons";
import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Spinner from "../components/Spinner";
import {toast} from "react-toastify";

function Post() {

    const {id} = useParams();
    const [post, setPost] = useState<any>([]);
    const [user, setUser] = useState<any>();
    const [replies, setReplies] = useState<any>([]);
    const [textareaValue, setTextareaValue] = useState("");
    const [loading, setLoading] = useState(true);

    useEffect( () => {

        const getAllData = async () => {
            const postResponse = await fetch("http://localhost:8080/api/v1/posts/findpost/" + id)
            const post = await postResponse.json()
            setPost(post)

            const replyResponse = await fetch("http://localhost:8080/api/v1/posts/reply/post/" + id)
            const replies = await replyResponse.json()
            setReplies(replies)

            const userResponse = await fetch("http://localhost:8080/api/v1/users/" + post.userID)
            const user = await userResponse.json()
            setUser(user)
        }

        getAllData()
            .then(() => setLoading(false))

        const timer = setTimeout(() => {
            setLoading(false);
        }, 3000);
    }, []);

    const deletePost = async () => {
        await fetch("http://localhost:8080/api/v1/posts/" + id, {
            method: "DELETE"
        })
        window.location.href = "/community"
    }

    const deleteReply = async (e: any) => {
        const replyID = e.currentTarget.value
        await fetch("http://localhost:8080/api/v1/posts/reply/" + replyID, {
            method: "DELETE"
        })
        window.location.reload()
    }

    const handleTextareaChange = (event: any) => {
        setTextareaValue(event.target.value);
    };

    const addReply = async (e: any) => {
        e.preventDefault()
        const reply = {
            reply_text: textareaValue,
            postID: id,
            userID: localStorage.getItem("user_id")
        }
        await fetch("http://localhost:8080/api/v1/posts/reply/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reply)
        })
        window.location.reload()
    }

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
                        <button className="hover:font-bold text-white">newest</button>
                        |
                        <button className="hover:font-bold text-white">oldest</button>
                    </div>
                </div>
                <div className="flex flex-col gap-1.5 text-sm p-2">
                    <div className="flex gap-1.5">
                        <span className="font-bold text-stone-400 mr-1">
                            <FontAwesomeIcon icon={faSignsPost} size="sm"/>
                        </span>

                        <span>{post.post_title}</span>
                    </div>
                    <div className="flex gap-1.5 text-stone-400 text-xs ml-5">
                        <button>by {user.username}</button>
                        |
                        <button>{replies.length} comments</button>
                        {post.userID === localStorage.getItem("user_id")
                            || localStorage.getItem("user_id") === "3" &&
                            <>
                                | <button onClick={deletePost}>delete</button>
                            </>
                        }
                    </div>
                    <div className="flex gap-1.5 text-stone-400 text-sm ml-5">
                        {post.post_text}
                    </div>
                    <div className="my-7">
                        <form onSubmit={addReply}>
                            <textarea
                                value={textareaValue} onChange={handleTextareaChange}
                                className="ml-5 p-2 w-4/5 sm:w-1/2 h-20 bg-stone-300 border border-amber-500 text-black rounded outline-none placeholder-gray-500" placeholder="Add a comment..."/><br/>
                            <button className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Add Comment</button>
                        </form>
                    </div>
                    <div className=" border-b border-b-orange-500 p-2 mb-7"/>
                    {replies.map((reply:any) => (
                        // @ts-ignore
                        <div className="flex flex-col gap-1.5 text-sm p-2" key={reply.replyID}>
                            <div className="flex gap-1.5">
                                <span className="font-bold text-stone-400 mr-1">
                                    <FontAwesomeIcon icon={faArrowsUpToLine} size="sm"/>
                                </span>
                                <div className="flex gap-1.5 text-xs text-stone-400">
                                    <button>{reply.replyByUserID}</button>
                                    {reply.replyByUserID === localStorage.getItem("user_id")
                                        || localStorage.getItem("user_id") === "3" &&
                                        <>
                                            | <button className="hover:text-white font-bold"
                                                      value={reply.replyID}
                                                      onClick={deleteReply}>delete</button>
                                        </>
                                    }
                                </div>
                            </div>
                            <div className="flex gap-1.5 text-stone-400 text-sm ml-5">
                                <span className="font-bold text-stone-400 mr-1">
                                    {reply.reply_text}
                                </span>
                            </div>
                        </div>
                    ))}
                </div>

            </div>

        </div>
    )
}

export default Post;