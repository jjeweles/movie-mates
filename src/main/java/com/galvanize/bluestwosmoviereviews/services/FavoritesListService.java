package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.FavoritesListRepository;
import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesListService {
    FavoritesListRepository favoritesRepository;
    @Autowired
    FavoritesListService(FavoritesListRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<FavoritesListModel> getFavoritesListByID(Integer userID) {
            return favoritesRepository.findByUserID(userID);
    }

//    public Optional<FavoritesListModel> addToFavorites(int tmdb) {
//        return favoritesRepository.save(tmdb);
//    }


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
