import {faFilm} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link} from "react-router-dom";

function Community() {

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
                <div className="flex flex-col gap-1.5 text-sm p-2">
                    <div className="flex gap-1.5">
                        <span className="font-bold text-black/60 mr-1">1</span>
                        <Link to="/community/1">Launch HN: OutSail (YC W23) – Wingsails to reduce cargo ship fuel consumption</Link>
                    </div>
                    <div className="flex gap-1.5 text-black/60 text-xs ml-5">
                        <Link to="/dashboard/1">by username</Link>
                        |
                        <Link to="/community/1">comments</Link>
                    </div>
                </div>
            </div>

        </div>
    )

}

export default Community;