package com.example.facemaker;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class Reader implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, Spinner.OnItemSelectedListener{

        //instances of the different TextViews.
        private TextView tvRed;
        private TextView tvGreen;
        private TextView tvBlue;

        private Face newFace;

        private int currentColor;

        private int whatsBeingSelected;

        //Constructor
        public Reader(TextView tvRed, TextView tvGreen, TextView tvBlue, Face newFace) {
                this.tvRed = tvRed;
                this.tvGreen = tvGreen;
                this.tvBlue = tvBlue;
                this.newFace = newFace;
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int r = Integer.parseInt((String) tvRed.getText());
                int g = Integer.parseInt((String) tvGreen.getText());
                int b = Integer.parseInt((String) tvBlue.getText());

                switch (seekBar.getId()) {

                        case R.id.seekRed:
                                this.tvRed.setText("" + progress);
                                r = progress;
                                break;

                        case R.id.seekGreen:
                                this.tvGreen.setText("" + progress);
                                g = progress;
                                break;

                        case R.id.seekBlue:
                                this.tvBlue.setText("" + progress);
                                b = progress;
                                break;
                }

                int newColor = Color.rgb(r,g,b);

                if (this.whatsBeingSelected == 1) {
                        newFace.setHairColor(newColor);
                } else if (this.whatsBeingSelected == 2) {
                        newFace.setEyeColor(newColor);
                } else if (this.whatsBeingSelected ==3) {
                        newFace.setSkinColor(newColor);
                }

                newFace.invalidate();
        }

        @Override
        public void onClick(View view) {

                switch(view.getId()) {
                        case R.id.button2:
                                newFace.setHairColor(newFace.randomize(1));
                                newFace.setEyeColor(newFace.randomize(1));
                                newFace.setSkinColor(newFace.randomize(1));
                                newFace.setHairStyle(newFace.randomize(2));
                                break;

                        case R.id.radioButton13:
                                this.whatsBeingSelected = 1;
                                //Change RGB values from 0-256
                                break;

                        case R.id.radioButton14:
                                this.whatsBeingSelected = 2;
                                //Change RGB values from 0-256
                                break;

                        case R.id.radioButton15:
                                this.whatsBeingSelected = 3;
                                //Change RGB values from 0-256
                                break;

                        default:
                                break;
                }
                newFace.invalidate();
        }


        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                newFace.setHairStyle(i);
                if (i == 0){
                        //Change RGB values from 0-256
                }
                if (i == 1){
                        //Change RGB values from 0-256
                }
                if (i == 2){
                        //Change RGB values from 0-256
                }
                newFace.invalidate();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
                //Do Nothing
        }
        @Override
        public void onStartTrackingTouch (SeekBar seekBar) {
                //Does Nothing but required.
        }
        @Override
        public void onStopTrackingTouch (SeekBar seekBar) {
                //Don't need but required
        }


}


