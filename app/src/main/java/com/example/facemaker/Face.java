// @author Aron Miguel Manalang
package com.example.facemaker;

import android.graphics.Color;
import android.graphics.Canvas;
import java.util.Random;

public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    //Randomizes the different Colors code for hairStyle is incomplete as I don't want this random
    public Face(int skinColor, int eyeColor, int hairColor, int hairStyle) {
    this.skinColor = randomize();
    this.eyeColor = randomize();
    this.hairColor = randomize();
    this.hairStyle = hairStyle;
    }

    //Randomizes RGB values and places it into a Color class
    public int randomize() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        int color = Color.rgb(r,g,b);
        return color;
    }

    public void onDraw(Canvas canvas){
    }
}
