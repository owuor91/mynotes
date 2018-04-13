package io.github.owuor91.notesapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;
import pl.droidsonroids.gif.GifImageView;

public class RecordAudioActivity extends AppCompatActivity {
  TextView tvStartRecording, tvStopRecording, tvCounter;
  GifImageView gifImageView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_audio);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvStartRecording = (TextView) findViewById(R.id.tvStartRecording);
    tvStopRecording = (TextView) findViewById(R.id.tvStopRecording);
    gifImageView = (GifImageView) findViewById(R.id.gifImageView);
    tvCounter = (TextView) findViewById(R.id.tvCounter);

    tvStartRecording.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        gifImageView.setImageResource(R.drawable.recordingmic);
      }
    });

    tvStopRecording.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        gifImageView.setImageResource(R.drawable.stoprecording);
      }
    });
  }
}