package com.galvanize.bluestwosmoviereviews.controllers;

import com.galvanize.bluestwosmoviereviews.models.UserModel;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import com.galvanize.bluestwosmoviereviews.services.WatchListService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class WatchListController {

    WatchListService watchListService;

    @PostMapping("api/v1/watchlist/save")
    public WatchListModel saveMovie(@RequestBody WatchListModel movie) {
        return watchListService.addToWatchList(movie);
    }

}
