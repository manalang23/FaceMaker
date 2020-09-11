// @author Aron Miguel Manalang
package com.example.facemaker;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

//import necessary classes

public class MainActivity extends AppCompatActivity{

    TextView tvRed = null;
    TextView tvGreen = null;
    TextView tvBlue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Used Developer.mozilla.org for this code and changed it a little to work for this homework.
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList<String> Hair_lengths = new ArrayList<>();
        Hair_lengths.add("Long");
        Hair_lengths.add("Short");
        Hair_lengths.add("Bald");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Hair_lengths);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        //Setting up the different texts
        tvRed = findViewById(R.id.tvRed);
        tvRed.setText("0");

        tvGreen = findViewById(R.id.tvGreen);
        tvGreen.setText("0");

        tvBlue = findViewById(R.id.tvBlue);
        tvBlue.setText("0");

        //Creates a new listener
        Reader eventListener = new Reader (tvRed, tvGreen, tvBlue);

        //Attaches listener to each seekerbar CODE FROM PROFESSOR NUXOLL
        SeekBar seekRed = findViewById(R.id.seekRed);
        seekRed.setOnSeekBarChangeListener(eventListener);

        SeekBar seekGreen = findViewById(R.id.seekGreen);
        seekGreen.setOnSeekBarChangeListener(eventListener);

        SeekBar seekBlue = findViewById(R.id.seekBlue);
        seekBlue.setOnSeekBarChangeListener(eventListener);

    }

}