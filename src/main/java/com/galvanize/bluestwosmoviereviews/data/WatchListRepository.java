package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface WatchListRepository extends JpaRepository<WatchListModel, Integer> {
    void deleteByTmdbId(Integer tmdbId);
    WatchListModel findByTmdbId(Integer tmdbId);

    List<WatchListModel> findByUserID(Integer userID);
}
