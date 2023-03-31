package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.FavoritesListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class FavoritesListController {

    FavoritesListService favoritesListService;
    public FavoritesListController(FavoritesListService favoritesListService)
    {
        this.favoritesListService = favoritesListService;
    }

    @GetMapping("/favList/{userId}")
    public ResponseEntity<List<FavoritesListModel>> getFavsListById(@PathVariable Integer userId) {
        List<FavoritesListModel> favorites = favoritesListService.getFavoritesListByID(userId);

        return favorites == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(favorites);
    }
    @PostMapping("/favList/save/{userId}/{tmdbId}")
    public ResponseEntity<FavoritesListModel> addTmdbIdToFavesList(@PathVariable Integer userId,
                                                                   @PathVariable Integer tmdbId)
    {
        FavoritesListModel newFavorite = new FavoritesListModel(userId, tmdbId);
        return new ResponseEntity<>(newFavorite, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/favList/delete/{userId}/{tmdbId}")
    public ResponseEntity deleteTmdbIdFromFavList(@PathVariable Integer userId, @PathVariable Integer tmdbId) {
       FavoritesListModel favorites = favoritesListService.getFavs(userId, tmdbId);

        favoritesListService.deleteByTmbdId(favorites);

        return ResponseEntity.noContent().build();
    }

}
