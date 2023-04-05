import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faFilm, faSignsPost, faArrowsUpToLine} from "@fortawesome/free-solid-svg-icons";

function Post() {
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
                        <span>Launch HN: OutSail (YC W23) – Wingsails to reduce cargo ship fuel consumption</span>
                    </div>
                    <div className="flex gap-1.5 text-stone-400 text-xs ml-5">
                        <button>by username</button>
                        |
                        <button># of comments</button>
                    </div>
                    <div className="flex gap-1.5 text-stone-400 text-sm ml-5">
                        lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl.
                        lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl.
                        lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl. Donec auctor, nisl eget ultricies
                        tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl.
                    </div>
                    <div className="my-7">
                        <form>
                            <textarea className="ml-5 p-2 w-1/2 h-20 bg-stone-300 border border-amber-500 text-black rounded outline-none placeholder-gray-500" placeholder="Add a comment..."/><br/>
                            <button className="ml-5 bg-orange-500 hover:bg-orange-700 text-black font-bold py-1 px-2 rounded">Add Comment</button>
                        </form>
                    </div>
                    <div className=" border-b border-b-orange-500 p-2"/>
                    <div className="flex flex-col gap-1.5 text-sm p-2 mt-7">
                        <div className="flex gap-1.5">
                            <span className="font-bold text-stone-400 mr-1">
                                <FontAwesomeIcon icon={faArrowsUpToLine} size="sm"/>
                            </span>
                            <div className="flex gap-1.5 text-xs text-stone-400">
                                <button>username</button>
                            </div>
                        </div>
                        <div className="flex gap-1.5 text-stone-400 text-sm ml-5">
                            <span className="font-bold text-stone-400 mr-1">
                                lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec auctor, nisl eget ultricies
                                tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl. Donec auctor, nisl eget ultricies
                                tincidunt, nisl nisl aliquam nisl, eu aliquam nisl nisl eu nisl.
                            </span>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    )
}

export default Post;