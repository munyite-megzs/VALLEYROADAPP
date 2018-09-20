package com.example.msitati.valleyroadapp;

import android.provider.MediaStore;

public class Artist {


    String artistId;
    String artistName;
    String artisgenre;

    //constructor here
    public Artist(){}
    //constructor here by right clicking then generate constructor
    public Artist(String artistId,String artistName,  String artisgenre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artisgenre = artisgenre;
    }
    //Create getters for reading the values

    public String getArtistId() {
        return artistId;
    }
    public String getArtistName() {
        return artistName;
    }

     public String getArtisgenre() {
        return artisgenre;
    }
}
