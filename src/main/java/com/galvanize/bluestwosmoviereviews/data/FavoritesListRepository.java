package com.galvanize.bluestwosmoviereviews.data;

import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Favorite List Model
 * @see FavoritesListModel
 * @see JpaRepository
 * @see Repository
 */
@Repository
public interface FavoritesListRepository extends JpaRepository<FavoritesListModel, Integer> {
    List<FavoritesListModel> findByUserID(Integer userId);

    FavoritesListModel findByUserIDAndTmdbId(Integer userId, Integer tmdbId);
}
