// @author Aron Miguel Manalang
package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.SurfaceView;
import android.util.AttributeSet;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class Face extends SurfaceView {

    //Paints
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint backgroundFiller = new Paint();

    //Values for face design
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    //Randomizes offers an RGB value if called with value 1, or offers a value from 1-3 if called with value 2.
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        //Basically randomizes all of my colors and style, and after doing so, also sets up my Paint values.
        this.skinColor = randomize(1);
        skinPaint.setColor(this.skinColor);
        skinPaint.setStyle(Paint.Style.FILL);

        this.eyeColor = randomize(1);
        eyePaint.setColor(this.eyeColor);
        skinPaint.setStyle(Paint.Style.FILL);

        this.hairColor = randomize(1);
        hairPaint.setColor(this.hairColor);
        hairPaint.setStyle(Paint.Style.FILL);

        this.hairStyle = randomize(2);

        //This paint is mainly so I can "erase" parts of a drawing to make new shapes.
        backgroundFiller.setColor(Color.WHITE);
        backgroundFiller.setStyle(Paint.Style.FILL);

        //made the background white so it's easier to see.
        setBackgroundColor(Color.WHITE);
    }

    //Randomizes skinColor, eyeColor, hairColor, or hairStyle.
    public int randomize(int i) {
        Random random = new Random();
        if(i == 1) {
            //Random program that makes a number from 0-255.
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int color = Color.rgb(r,g,b);
            return color;
        } else {
            //Creates an int from 0-2
            return (random.nextInt(3));
        }

    }

    //Getters and Setters just incase I need them. Android studio messed up my formatting somehow
    public int getHairColor(){
        return this.hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(int skinColor) {
        this.skinColor = skinColor;
    }

    public int getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(int eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setHairStyle(int hairStyle) {
        this.hairStyle = hairStyle;
    }

    public int getHairStyle() {
        return this.hairStyle;
    }

    //This requires API makes it so lower "leveled" devices won't crash when using it.
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawEyes(Canvas canvas) {
        canvas.drawOval(250,300,300,350, eyePaint);
        canvas.drawOval(400,300,450,350, eyePaint);
    }

    public void drawMouth(Canvas canvas) {

        //Points for my smiling face :)
        float[][] points = {{2f,9f} , {3f,10f} , {6f,11f} , {9f, 10f} , {10f, 9f} ,
                {9f, 12f}, {3f, 12f}, {2f, 9f}};


        for(int i = 1; i < points.length; ++i) {
            canvas.drawLine(25.0f * points[i - 1][0] + 200.0f,
                    25.0f * points[i - 1][1] + 200.0f,
                    25.0f * points[i][0] + 200.0f,
                    25.0f * points[i][1] + 200.0f,
                    eyePaint);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onDraw(Canvas canvas) {

        skinPaint.setColor(this.getSkinColor());
        eyePaint.setColor(this.getEyeColor());
        hairPaint.setColor(this.getHairColor());

        //Basically makes it so that it checkes what hair it should be and draws it based on that.
        if(this.hairStyle == 2) {
            //Do nothing
        } else if (this.hairStyle  == 1) {
            //Draw a bowl cut hair style.
            canvas.drawOval(50,0,650,750, hairPaint);
            canvas.drawRect(50, 300 ,650, 750, backgroundFiller);
        } else if (this.hairStyle  == 0) {
            canvas.drawOval(50, 0, 650, 750, hairPaint);
            canvas.drawRect(55, 300, 645, 750, hairPaint);
        }


        canvas.drawOval(100,50,600,700, skinPaint);
        drawEyes(canvas);
        drawMouth(canvas);
    }
}
