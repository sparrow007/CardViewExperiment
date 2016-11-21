package com.example.ankit.cardviewexperiment;


public class Album {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }

    private  String name;
    private  long numOfSongs;
    private  int thumbnails;

    public long getThisId() {
        return thisId;
    }

    public void setThisId(long thisId) {
        this.thisId = thisId;
    }

    public long getAlId() {
        return alId;
    }

    public void setAlId(long alId) {
        this.alId = alId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    long thisId;
    long alId;
    String title;

    public Album(String name, String thumbnails, long id, long alId) {
        this.name = name;
        this.title= thumbnails;
        this.numOfSongs = id;
        this.alId = alId;

    }
}
