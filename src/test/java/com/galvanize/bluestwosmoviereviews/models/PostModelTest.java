package com.galvanize.bluestwosmoviereviews.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PostModelTest {

    private PostModel post1;
    private PostModel post2;

    @BeforeEach
    void setUp() {
        post1 = new PostModel(1, "Post title 1", "Post text 1", 1, 1, 1);
        post2 = new PostModel(2, "Post title 2", "Post text 2", 2, 1, 1);
    }

    @Test
    void getPostID() {
        assertEquals(1, post1.getPostID());
        assertEquals(2, post2.getPostID());
    }

    @Test
    void setPostID() {
        post1.setPostID(3);
        post2.setPostID(4);
        assertEquals(3, post1.getPostID());
        assertEquals(4, post2.getPostID());
    }

    @Test
    void getPost_title() {
        assertEquals("Post title 1", post1.getPost_title());
        assertEquals("Post title 2", post2.getPost_title());
    }

    @Test
    void setPost_title() {
        post1.setPost_title("New post title 1");
        post2.setPost_title("New post title 2");
        assertEquals("New post title 1", post1.getPost_title());
        assertEquals("New post title 2", post2.getPost_title());
    }

    @Test
    void getPost_text() {
        assertEquals("Post text 1", post1.getPost_text());
        assertEquals("Post text 2", post2.getPost_text());
    }

    @Test
    void setPost_text() {
        post1.setPost_text("New post text 1");
        post2.setPost_text("New post text 2");
        assertEquals("New post text 1", post1.getPost_text());
        assertEquals("New post text 2", post2.getPost_text());
    }

    @Test
    void getUserID() {
        assertEquals(1, post1.getUserID());
        assertEquals(2, post2.getUserID());
    }

    @Test
    void setUserID() {
        post1.setUserID(3);
        post2.setUserID(4);
        assertEquals(3, post1.getUserID());
        assertEquals(4, post2.getUserID());
    }

    @Test
    void getCategoryID() {
        assertEquals(1, post1.getCategoryID());
        assertEquals(1, post2.getCategoryID());
    }

    @Test
    void setCategoryID() {
        post1.setCategoryID(2);
        post2.setCategoryID(3);
        assertEquals(2, post1.getCategoryID());
        assertEquals(3, post2.getCategoryID());
    }

    @Test
    void testEquals() {
        PostModel post1Copy = new PostModel(1, "Post title 1", "Post text 1", 1, 1, 1);
        assertEquals(post1, post1Copy);
        assertNotEquals(post1, post2);
    }

    @Test
    void testHashCode() {
        PostModel post1Copy = new PostModel(1, "Post title 1", "Post text 1", 1, 1, 1);
        assertEquals(post1.hashCode(), post1Copy.hashCode());
        assertNotEquals(post1.hashCode(), post2.hashCode());
    }

    @Test
    void testToString() {
        String expected = "PostModel{" +
                "postID=" + post1.getPostID() +
                ", post_title='" + post1.getPost_title() + '\'' +
                ", post_text='" + post1.getPost_text() + '\'' +
                ", userID=" + post1.getUserID() +
                ", categoryID=" + post1.getCategoryID() +
                '}';
        assertEquals(expected, post1.toString());
    }
}
