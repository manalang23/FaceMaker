package com.example.facemaker;

import android.widget.SeekBar;
import android.widget.TextView;

public class Reader implements SeekBar.OnSeekBarChangeListener {

        //instances of the different TextViews.
        private TextView tvRed = null;
        private TextView tvGreen = null;
        private TextView tvBlue = null;

        //Constructor
        public Reader(TextView redInit, TextView greenInit, TextView blueInit) {
                this.tvRed = redInit;
                this.tvGreen = greenInit;
                this.tvBlue = blueInit;
        }

        @Override
        public void onStartTrackingTouch (SeekBar seekBar) {
                //Does Nothing but required.
        }

        @Override
        public void onStopTrackingTouch (SeekBar seekBar) {
                //Don't need but required
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (!fromUser) {
                        return;
                }

                //Based this switch off of Professor Nuxoll's code.
                switch (seekBar.getId()) {

                        case R.id.seekRed:
                                this.tvRed.setText("" + progress);
                                break;

                        case R.id.seekGreen:
                                this.tvGreen.setText("" + progress);
                                break;

                        case R.id.seekBlue:
                                this.tvBlue.setText("" + progress);
                                break;
                }
        }
}


