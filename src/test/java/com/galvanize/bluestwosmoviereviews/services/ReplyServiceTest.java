package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.ReplyRepository;
import com.galvanize.bluestwosmoviereviews.models.ReplyModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReplyServiceTest {

    @Mock
    private ReplyRepository replyRepository;

    @InjectMocks
    private ReplyService replyService;

    private ReplyModel reply;

    @BeforeEach
    void setUp() {
        reply = new ReplyModel();
        reply.setReplyID(1);
        reply.setReply_text("Test Reply");
    }

    @Test
    void getAllReplies() {
        replyService.getAllReplies();
        verify(replyRepository, times(1)).findAll();
    }

    @Test
    void getReplyByUserID() {
        when(replyRepository.findReplyByUserID(1)).thenReturn(Collections.singletonList(reply));
        replyService.getReplyByUserID(1);
        verify(replyRepository, times(1)).findReplyByUserID(1);
    }

    @Test
    void findReplyByPostID() {
        when(replyRepository.findReplyByPostID(1)).thenReturn(Collections.singletonList(reply));
        replyService.findReplyByPostID(1);
        verify(replyRepository, times(1)).findReplyByPostID(1);
    }

    @Test
    void addReply() {
        replyService.addReply(reply);
        verify(replyRepository, times(1)).save(reply);
    }

    @Test
    void updateReply() {
        when(replyRepository.findReplyByReplyID(1)).thenReturn(reply);
        ReplyModel updatedReply = new ReplyModel();
        updatedReply.setReply_text("Updated Reply");
        replyService.updateReply(1, updatedReply);
        verify(replyRepository, times(1)).findReplyByReplyID(1);
        verify(replyRepository, times(1)).save(reply);
    }

    @Test
    void deletePost() {
        when(replyRepository.findReplyByReplyID(1)).thenReturn(reply);
        replyService.deletePost(1);
        verify(replyRepository, times(1)).findReplyByReplyID(1);
        verify(replyRepository, times(1)).delete(reply);
    }
}
