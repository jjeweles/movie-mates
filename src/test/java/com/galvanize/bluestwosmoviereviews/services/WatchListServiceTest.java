package com.galvanize.bluestwosmoviereviews.services;

import com.galvanize.bluestwosmoviereviews.data.WatchListRepository;
import com.galvanize.bluestwosmoviereviews.models.WatchListModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WatchListServiceTest {

    @Mock
    WatchListRepository watchListRepository;

    WatchListService watchListService;

    @BeforeEach
    void setup() {
        watchListService = new WatchListService(watchListRepository);
    }

    @Test
    public void testGetWatchlist(){
        List<WatchListModel> watchList = new ArrayList<>();

        watchList.add(new WatchListModel(1,2));
        watchList.add(new WatchListModel(1,3));
        watchList.add(new WatchListModel(1,4));

        when(watchListRepository.findByUserID(1)).thenReturn(watchList);

        List<WatchListModel> result = watchListService.getWatchList(1);

        assertEquals(3, result.size());
        assertEquals(watchList, result);
    }

    @Test
    public void testAddToWatchList(){
        WatchListModel watchListModel = new WatchListModel(1, 2);

        when(watchListRepository.save(any(WatchListModel.class))).thenReturn(watchListModel);

        WatchListModel result = watchListService.addToWatchList(watchListModel);

        assertThat(result).isNotNull();
        assertThat(result.getTmdbID()).isEqualTo(2);
    }

    @Test
    public void testDeleteFromWatchList(){
        WatchListModel watchList = new WatchListModel(1,2);

        when(watchListRepository.findByUserIDAndTmdbID(anyInt(), anyInt())).thenReturn(watchList);

        WatchListModel watchList1 = watchListService.deleteFromWatchList(1,2);
        assertThat(watchList1).isNotNull();
        assertThat(watchList1.getTmdbID()).isEqualTo(2);
    }
}
