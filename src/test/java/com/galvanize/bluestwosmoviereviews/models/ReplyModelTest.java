package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ReplyModelTest {

    private ReplyModel reply1;
    private ReplyModel reply2;

    @BeforeEach
    void setUp() {
        reply1 = new ReplyModel(1, "Test reply text 1", 1, 1);
        reply2 = new ReplyModel(2, "Test reply text 2", 2, 1);
    }

    @Test
    void getReplyID() {
        assertEquals(1, reply1.getReplyID());
        assertEquals(2, reply2.getReplyID());
    }

    @Test
    void setReplyID() {
        reply1.setReplyID(3);
        reply2.setReplyID(4);
        assertEquals(3, reply1.getReplyID());
        assertEquals(4, reply2.getReplyID());
    }

    @Test
    void getReply_text() {
        assertEquals("Test reply text 1", reply1.getReply_text());
        assertEquals("Test reply text 2", reply2.getReply_text());
    }

    @Test
    void setReply_text() {
        reply1.setReply_text("New reply text 1");
        reply2.setReply_text("New reply text 2");
        assertEquals("New reply text 1", reply1.getReply_text());
        assertEquals("New reply text 2", reply2.getReply_text());
    }

    @Test
    void getReplyByUserID() {
        assertEquals(1, reply1.getReplyByUserID());
        assertEquals(2, reply2.getReplyByUserID());
    }

    @Test
    void setUserID() {
        reply1.setUserID(3);
        reply2.setUserID(4);
        assertEquals(3, reply1.getReplyByUserID());
        assertEquals(4, reply2.getReplyByUserID());
    }

    @Test
    void getPostID() {
        assertEquals(1, reply1.getPostID());
        assertEquals(1, reply2.getPostID());
    }

    @Test
    void setPostID() {
        reply1.setPostID(2);
        reply2.setPostID(3);
        assertEquals(2, reply1.getPostID());
        assertEquals(3, reply2.getPostID());
    }

    @Test
    void testEquals() {
        ReplyModel reply1Copy = new ReplyModel(1, "Test reply text 1", 1, 1);
        assertEquals(reply1, reply1Copy);
        assertNotEquals(reply1, reply2);
    }

    @Test
    void testHashCode() {
        ReplyModel reply1Copy = new ReplyModel(1, "Test reply text 1", 1, 1);
        assertEquals(reply1.hashCode(), reply1Copy.hashCode());
        assertNotEquals(reply1.hashCode(), reply2.hashCode());
    }

    @Test
    void testToString() {
        String expected1 = "ReplyModel{replyID=1, reply_text='Test reply text 1', userID=1, postID=1}";
        String expected2 = "ReplyModel{replyID=2, reply_text='Test reply text 2', userID=2, postID=1}";
        assertEquals(expected1, reply1.toString());
        assertEquals(expected2, reply2.toString());
    }
}
