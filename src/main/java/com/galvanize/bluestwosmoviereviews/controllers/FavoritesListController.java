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

    @PostMapping("/favList/save/")
    public ResponseEntity<FavoritesListModel> addTmdbIdToFavesList(@RequestBody FavoritesListModel favoritesListModel)
    {
        FavoritesListModel newFavorite = favoritesListService.addNewFavorite(favoritesListModel);
        return new ResponseEntity<>(newFavorite, HttpStatus.CREATED);
    }

    @DeleteMapping("/favList/delete/{userId}/{tmdbId}")
    public ResponseEntity<FavoritesListModel> deleteTmdbIdFromFavList(@PathVariable Integer userId, @PathVariable Integer tmdbId) {

        favoritesListService.deleteByTmbdId(userId, tmdbId);

        return ResponseEntity.accepted().build();
    }

    /* ###### For testing purposes only ###### */
    @DeleteMapping("/favList/deleteAll/{userId}")
    public ResponseEntity<FavoritesListModel> deleteAllFavList(@PathVariable Integer userId) {

        favoritesListService.deleteAll(userId);

        return ResponseEntity.accepted().build();
    }

}
