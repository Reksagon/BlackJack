package com.blackjack;

import android.graphics.Bitmap;

public class Card {
    String name = "";
    int score = 0;
    Bitmap image = null;

    public Card() { }

    public Card(String name, int score, Bitmap image) {
        this.name = name;
        this.score = score;
        this.image = image;
    }
}
