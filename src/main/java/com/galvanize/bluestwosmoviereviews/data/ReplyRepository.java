package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyModel, Integer> {
    List<ReplyModel> findReplyByUserID(Integer userID);

    ReplyModel findReplyByReplyID(Integer replyID);

    void deleteReplyByReplyID(Integer replyID);

    List<ReplyModel> findReplyByPostID(Integer postID);
}
