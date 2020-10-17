package com.example.myapplication.Model;

public class Song {

    public int id;
    public  String name,artist,content;


    public Song(int id,String name,String artist,String content){

        this.id=id;
        this.name=name;
        this.artist=artist;
        this.content=content;

    }
    public Song(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
