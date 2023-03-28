package com.galvanize.bluestwosmoviereviews.models;

public class WatchListModel {

    Integer list_id;
    Integer imdb_id;
    Integer user_id;

    public Integer getList_id() {
        return list_id;
    }

    public void setList_id(Integer list_id) {
        this.list_id = list_id;
    }

    public Integer getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(Integer imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public WatchListModel(Integer list_id, Integer imdb_id, Integer user_id){
        this.list_id = list_id;
        this.imdb_id = imdb_id;
        this.user_id = user_id;
    }

}
