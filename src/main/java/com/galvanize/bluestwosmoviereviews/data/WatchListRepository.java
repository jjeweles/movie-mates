package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchListRepository extends JpaRepository<WatchListModel, Integer> {
    void deleteByTmdbID(Integer tmdbID);
    WatchListModel findByTmdbID(Integer tmdbID);
    List<WatchListModel> findByUserID(Integer userID);
    WatchListModel findByUserIDAndTmdbID(Integer userID, Integer tmdbID);
}
