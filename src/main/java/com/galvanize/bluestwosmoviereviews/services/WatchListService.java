package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.WatchListRepository;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class WatchListService {

    @PersistenceContext
    EntityManager entityManager;

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

    public WatchListModel deleteFromWatchList(Integer userID, Integer tmdbId){
        WatchListModel movieToDelete = watchListRepository.findByUserIDAndTmdbID(userID, tmdbId);
        if (movieToDelete != null){
            watchListRepository.delete(movieToDelete);
        }
        return movieToDelete;
    }

    @Transactional
    public void deleteAll(Integer userID) {
        String query = "DELETE FROM watchlist WHERE userID = " + userID + "";
        entityManager.createNativeQuery(query).executeUpdate();
    }
}
