package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesListService {
    private final FavoritesListRepository favoritesRepository;
    @Autowired
    FavoritesListService(FavoritesListRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<FavoritesListModel> getFavoritesListByID(Integer userId) {
            return favoritesRepository.findByUserId(userId);
    }
    public void deleteByTmbdId(Integer tmbdId) {
        favoritesRepository.deleteById(tmbdId);
    }

    public FavoritesListModel addToFavorites(FavoritesListModel favoritesListModel) {
        return favoritesRepository.save(favoritesListModel);
    }


//    public List<FavoritesListModel> deleteFavorite(int userID, int tmdbId)
//    {
//        List<FavoritesListModel> tmdbIDToDelete = favoritesRepository.findById(userID);
//        if(tmdbIDToDelete != null)
//        {
//            favoritesRepository.;
//        }
//
//        return tmdbIDToDelete;
//    }
}
