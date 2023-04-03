package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.FriendsListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsListRepository extends JpaRepository<FriendsListModel, Integer> {
    List<FriendsListModel> findByUserId(Integer userId);
    FriendsListModel findByUserId(Integer userId, Integer friendId);
}
