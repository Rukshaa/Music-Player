package com.example.musicplayer.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SearchModel {
    private int songImg;
    private  String titleSong;
    private String titleSub;
}
