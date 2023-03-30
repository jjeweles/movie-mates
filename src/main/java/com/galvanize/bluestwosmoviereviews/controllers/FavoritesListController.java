package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.FavoritesListModel;
import com.galvanize.bluestwosmoviereviews.models.RatingModel;
import com.galvanize.bluestwosmoviereviews.services.FavoritesListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class FavoritesListController {

    FavoritesListService favoritesListService;
    public FavoritesListController(FavoritesListService favoritesListService)
    {
        this.favoritesListService = favoritesListService;
    }

    @GetMapping("/api/v1/favList/get")
    public ResponseEntity<List<FavoritesListModel>> getFavsListById(@PathVariable Integer userId) {
        List<FavoritesListModel> favorites = favoritesListService.getFavoritesListByID(userId);

        return favorites == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(favorites);
    }

}
