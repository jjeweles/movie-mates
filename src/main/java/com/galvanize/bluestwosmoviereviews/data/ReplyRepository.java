package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<ReplyModel, Integer> {

    ReplyModel findReplyByUserID(Integer userID);

    ReplyModel findReplyByReplyID(Integer replyID);
    ReplyModel save(ReplyModel reply);

    void deleteReplyByReplyID(Integer replyID);


    }
