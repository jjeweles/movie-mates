package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import com.galvanize.bluestwosmoviereviews.services.WatchListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WatchListController {

    WatchListService watchListService;

    public WatchListController(WatchListService watchListService){
        this.watchListService = watchListService;
    }

    @GetMapping("api/v1/watchlist/{userID}")
    public ResponseEntity<List<WatchListModel>> getWatchListById(@PathVariable Integer userID){
        List<WatchListModel> watchList = watchListService.getWatchList(userID);

        return watchList == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(watchList);
    }

    @PostMapping("api/v1/watchlist/add")
    public WatchListModel addMovie(@RequestBody WatchListModel watchListModel) {
        return watchListService.addToWatchList(watchListModel);
    }

    @DeleteMapping("api/v1/watchlist/{userID}/{tmdbID}")
    public ResponseEntity<WatchListModel> deleteMovie(@PathVariable Integer userID,@PathVariable Integer tmdbID){
        WatchListModel deletedMovie = watchListService.deleteFromWatchList(userID, tmdbID);

        return deletedMovie == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(deletedMovie);
    }

    /* ###### For testing purposes only ###### */
    @DeleteMapping("api/v1/watchlist/deleteAll/{userID}")
    public ResponseEntity<WatchListModel> deleteAllWatchList(@PathVariable Integer userID) {

        watchListService.deleteAll(userID);

        return ResponseEntity.accepted().build();
    }
}
