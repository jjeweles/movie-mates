package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import com.galvanize.bluestwosmoviereviews.services.WatchListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WatchListController {

    WatchListService watchListService;

    public WatchListController(WatchListService watchListService){
        this.watchListService = watchListService;
    }

    @GetMapping("api/v1/watchlist/{userId}")
    public ResponseEntity<List<WatchListModel>> getWatchListById(@PathVariable Integer userId){
        List<WatchListModel> watchList = watchListService.getWatchList(userId);

        return watchList == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(watchList);
    }

    @PostMapping("api/v1/watchlist/{tmdbId}")
    public WatchListModel addMovie(@RequestBody WatchListModel tmdbId) {
        return watchListService.addToWatchList(tmdbId);
    }

    @DeleteMapping("api/v1/watchlist/{tmdbId}")
    public ResponseEntity<WatchListModel> deleteMovie(@PathVariable Integer tmdbId){
        WatchListModel deletedMovie = watchListService.deleteFromWatchList(tmdbId);

        return deletedMovie == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedMovie);
    }

}
