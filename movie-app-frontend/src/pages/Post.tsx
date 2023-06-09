import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFilm, faSignsPost, faArrowsUpToLine} from "@fortawesome/free-solid-svg-icons";
import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import Spinner from "../components/Spinner";

function Post() {

    const {id} = useParams();
    const [post, setPost] = useState<any>([]);
    const [user, setUser] = useState<any>();
    const [replies, setReplies] = useState<any>([]);
    const [textareaValue, setTextareaValue] = useState("");
    const [textareaReplyValue, setTextareaReplyValue] = useState("");
    const [loading, setLoading] = useState(true);
    const [showReply, setShowReply] = useState(false);
    const [showComment, setShowComment] = useState(false);

    useEffect( () => {

        const getAllData = async () => {
            const postResponse = await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/findpost/" + id)
            const post = await postResponse.json()
            setPost(post)

            const replyResponse = await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/reply/post/" + id)
            const replies = await replyResponse.json()
            setReplies(replies)

            const userResponse = await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/users/" + post.userID)
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
        await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/" + id, {
            method: "DELETE"
        })
        window.location.href = "/community"
    }

    const deleteReply = async (e: any) => {
        const replyID = e.currentTarget.value
        await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/reply/" + replyID, {
            method: "DELETE"
        })
        window.location.reload()
    }

    const handleTextareaChange = (event: any) => {
        setTextareaValue(event.target.value);
    };

    const handleTextareaReplyChange = (event: any) => {
        setTextareaReplyValue(event.target.value);
    }

    const addReply = async (e: any) => {
        e.preventDefault()

        if (textareaValue === "") {
            return null
        }

        const reply = {
            reply_text: textareaValue,
            postID: id,
            userID: localStorage.getItem("user_id")
        }
        await fetch("https://blues-twos-movie-reviews-xeeg6ppgsa-vp.a.run.app/api/v1/posts/reply/", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reply)
        })
        window.location.reload()
    }

    const handleReply = async (e: any) => {
        setShowReply(!showReply)
    }

    const handleComment = async (e: any) => {
        setShowComment(!showComment)
    }

    const addReplyToReply = async (e: any) => {
        e.preventDefault()
        if (textareaReplyValue === "") {
            return null
        }
        return null;
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
                        {!showComment &&
                            <button
                                onClick={handleComment}
                                className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Add Comment</button>
                        }
                        {showComment &&
                            <form onSubmit={addReply}>
                                <textarea
                                    value={textareaValue} onChange={handleTextareaChange}
                                    className="ml-5 p-2 w-4/5 sm:w-1/2 h-20 bg-stone-300 border border-amber-500 text-black rounded outline-none placeholder-gray-500" placeholder="Add a comment..."/><br/>
                                <div className="flex gap-2">
                                    <button className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Submit</button>
                                    <button
                                        onClick={handleComment}
                                        className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Close</button>
                                </div>
                            </form>
                        }
                    </div>
                    <div className="border-b border-b-orange-500 p-2 mb-7"/>
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
                            <div className="flex flex-col gap-2">
                                <div className="flex gap-1.5 text-stone-400 text-sm ml-5">
                                    <button onClick={handleReply} value={reply.replyID}>
                                        <span className="font-bold text-stone-400 mr-1">
                                            {reply.reply_text}
                                        </span>
                                    </button>
                                </div>
                                {showReply &&
                                    <div className="flex gap-1.5 text-xs text-stone-400">
                                        <form onSubmit={addReplyToReply}>
                                            <textarea
                                                value={textareaReplyValue} onChange={handleTextareaReplyChange}
                                                className="ml-5 p-2 h-20 bg-stone-300 border border-amber-500 text-black rounded outline-none placeholder-gray-500" placeholder="Reply..."/><br/>
                                            <div className="flex gap-2">
                                                <button className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Reply</button>
                                                <button
                                                    onClick={handleReply}
                                                    className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Close</button>
                                            </div>                                        </form>
                                    </div>
                                }
                            </div>
                        </div>
                    ))}
                </div>

            </div>

        </div>
    )
}

export default Post;