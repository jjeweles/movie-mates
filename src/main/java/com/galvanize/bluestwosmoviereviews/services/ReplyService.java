package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.PostRepository;
import com.galvanize.bluestwosmoviereviews.data.ReplyRepository;
import com.galvanize.bluestwosmoviereviews.models.PostModel;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;

public class ReplyService {


    ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    public Iterable<ReplyModel> getAllReplies() {
        return replyRepository.findAll();
    }

    public ReplyModel getReplyByID(Integer userID){
        return replyRepository.findReplyByUserID(userID);
    }

    public ReplyModel addPost(ReplyModel reply){
        return replyRepository.save(reply);
    }

    public ReplyModel updateReply(Integer replyID, ReplyModel reply){
        ReplyModel replyToUpdate = replyRepository.findReplyByReplyID(replyID);

        if(replyToUpdate != null){
            replyToUpdate.setReply_text(reply.getReply_text());
        }

        assert replyToUpdate != null;
        return replyRepository.save(replyToUpdate);
    }

    public ReplyModel deletePost (Integer replyID){
        ReplyModel replyToDelete = replyRepository.findReplyByReplyID(replyID);
        if (replyToDelete != null){
            replyRepository.delete(replyToDelete);
        }
        return replyToDelete;
    }
}
