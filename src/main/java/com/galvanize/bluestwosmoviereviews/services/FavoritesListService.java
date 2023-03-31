package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesListService {
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
    public void deleteByTmbdId(FavoritesListModel favoritesListModel) {
    favoritesRepository.delete(favoritesListModel);

    //.findById(userId).orElse(null)

}

    public FavoritesListModel addToFavorites(FavoritesListModel favoritesListModel) {
        return favoritesRepository.save(favoritesListModel);
    }

}
