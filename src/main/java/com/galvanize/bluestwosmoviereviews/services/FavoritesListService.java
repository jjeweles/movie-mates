package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.springframework.beans.factory.annotation.Autowired;
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
public FavoritesListModel deleteByTmbdId(Integer tmdbId) {
    FavoritesListModel tmbdIdToDelete = favoritesRepository.findById(tmdbId).orElse(null);

    if (tmbdIdToDelete != null) {
        favoritesRepository.delete(tmbdIdToDelete);
    }

    return tmbdIdToDelete;
}

    public FavoritesListModel addToFavorites(FavoritesListModel favoritesListModel) {
        return favoritesRepository.save(favoritesListModel);
    }

}
