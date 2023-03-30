package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.WatchListRepository;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchListService {

    private WatchListRepository watchListRepository;

    @Autowired
    public WatchListService(WatchListRepository watchListRepository){
        this.watchListRepository = watchListRepository;
    }

    public List<WatchListModel> getWatchList(Integer id){
        return watchListRepository.findAllById(id);
    }

    public WatchListModel addToWatchList(WatchListModel tmdbId) {
        return watchListRepository.save(tmdbId);
    }

    public WatchListModel deleteFromWatchList(Integer tmdbId){
        WatchListModel movieToDelete = watchListRepository.findByTmdbId(tmdbId);
        if (movieToDelete != null){
            watchListRepository.deleteByTmdbId(tmdbId);
        }
        return movieToDelete;
    }

}
