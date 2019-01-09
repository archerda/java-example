package com.github.archerda.spring.ioc.beanwire;

import org.springframework.stereotype.Component;

/**
 * Create by archerda on 2017/11/19.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt.Pepper's Lonely Hearts Clue Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " By " + artist);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
