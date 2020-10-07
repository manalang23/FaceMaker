// @author Aron Miguel Manalang
package com.example.facemaker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import necessary classes

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting up the different the texts
        TextView tvRed = findViewById(R.id.tvRed);
        tvRed.setText("0");

        TextView tvGreen = findViewById(R.id.tvGreen);
        tvGreen.setText("0");

        TextView tvBlue = findViewById(R.id.tvBlue);
        tvBlue.setText("0");

        //Creates a new listener
        Face temp = findViewById(R.id.face);
        Reader eventListener = new Reader (tvRed, tvGreen, tvBlue, temp);

        //How I managed to set up the Spinner /\/\
        //Used Developer.mozilla.org for this code and changed it a little to work for this homework.
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> Hair_lengths = new ArrayList<>();
        Hair_lengths.add("Long");
        Hair_lengths.add("Short");
        Hair_lengths.add("Bald");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Hair_lengths);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(eventListener);

        SeekBar seekRed = findViewById(R.id.seekRed);
        seekRed.setOnSeekBarChangeListener(eventListener);

        SeekBar seekGreen = findViewById(R.id.seekGreen);
        seekGreen.setOnSeekBarChangeListener(eventListener);

        SeekBar seekBlue = findViewById(R.id.seekBlue);
        seekBlue.setOnSeekBarChangeListener(eventListener);

        Button randomButton = findViewById(R.id.button2);
        randomButton.setOnClickListener(eventListener);

        RadioButton hairButton = findViewById(R.id.radioButton13);
        hairButton.setOnClickListener(eventListener);

        RadioButton eyesButton = findViewById(R.id.radioButton14);
        eyesButton.setOnClickListener(eventListener);

        RadioButton skinButton = findViewById(R.id.radioButton15);
        skinButton.setOnClickListener(eventListener);
    }

}