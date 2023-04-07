package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FavoritesListService {

    @PersistenceContext
    EntityManager entityManager;

    private final FavoritesListRepository favoritesRepository;

    @Autowired
    FavoritesListService(FavoritesListRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<FavoritesListModel> getFavoritesListByID(Integer userID) {
        return favoritesRepository.findByUserID(userID);
    }

    public FavoritesListModel getFavs(Integer userId, Integer tmdbId) {
        FavoritesListModel favoritesListModel = new FavoritesListModel(userId, tmdbId);
        return favoritesRepository.save(favoritesListModel);
    }

    public void deleteByTmbdId(Integer userId, Integer tmdbId) {
        FavoritesListModel modelToDelete = favoritesRepository.findByUserIDAndTmdbId(userId, tmdbId);
        favoritesRepository.delete(modelToDelete);
    }

    public FavoritesListModel addToFavorites(FavoritesListModel favoritesListModel) {
        return favoritesRepository.save(favoritesListModel);
    }

    public FavoritesListModel addNewFavorite(FavoritesListModel favoritesListModel) {
        return favoritesRepository.save(favoritesListModel);
    }

    @Transactional
    public void deleteAll(Integer userID) {
        String query = "DELETE FROM favorites WHERE userID = " + userID + "";
        entityManager.createNativeQuery(query).executeUpdate();
    }
}
