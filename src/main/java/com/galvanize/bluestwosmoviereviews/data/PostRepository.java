package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {

    PostModel findPostsByUserID(Integer userID);

    PostModel findPostsByPostID(Integer userID);
}
