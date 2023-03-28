package com.galvanize.bluestwosmoviereviews.models;

public class WatchListModel {

    Integer list_id;
    Integer tmdb_id;
    Integer user_id;

    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public Integer getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(Integer tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public WatchListModel(Integer list_id, Integer imdb_id, Integer user_id){
        this.list_id = list_id;
        this.tmdb_id = imdb_id;
        this.user_id = user_id;
    }

}
