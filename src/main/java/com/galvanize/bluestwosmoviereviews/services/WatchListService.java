package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.WatchListRepository;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListService {

    private WatchListRepository watchListRepository;

    @Autowired
    public WatchListService(WatchListRepository watchListRepository){
        this.watchListRepository = watchListRepository;
    }

    public List<WatchListModel> getWatchList(Integer userID){
        return watchListRepository.findByUserID(userID);
    }

    public WatchListModel addToWatchList(WatchListModel watchListModel) {
        return watchListRepository.save(watchListModel);
    }

    public WatchListModel deleteFromWatchList(Integer tmdbId){
        WatchListModel movieToDelete = watchListRepository.findByTmdbID(tmdbId);
        if (movieToDelete != null){
            watchListRepository.deleteByTmdbID(tmdbId);
        }
        return movieToDelete;
    }

}
