import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFilm} from "@fortawesome/free-solid-svg-icons";
import {Link} from "react-router-dom";

function CommunityPost() {

    const addPost = async (e: any) => {
        e.preventDefault();
        const post = {
            post_title: e.target[0].value,
            post_text: e.target[1].value,
            userID: localStorage.getItem("user_id"),
            categoryID: 1
        }
        await fetch("http://localhost:8080/api/v1/posts/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(post)
        })
        window.location.href = "/community"
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
                        |
                        <Link to="/community/post" className="hover:font-bold text-white">submit</Link>
                    </div>
                </div>
                <div className="flex flex-col">

                    <div className="my-7 w-5/6 sm:w-1/2">
                        <form onSubmit={addPost}>
                            <input type="text"
                                   className="ml-5 mb-3 p-2 w-full bg-stone-300 border border-black text-black rounded outline-none placeholder-gray-500" placeholder="Post Title"/><br/>
                            <textarea
                                maxLength={500}
                                className="ml-5 p-2 w-full h-20 bg-stone-300 border border-black text-black rounded outline-none placeholder-gray-500" placeholder="Post Text"/><br/>
                            <button className="ml-5 bg-stone-400 border border-black text-xs hover:bg-orange-700 text-black font-bold py-1 px-2 rounded" type="submit">Add Post</button>
                        </form>
                    </div>

                </div>

            </div>

        </div>
    )

}

export default CommunityPost