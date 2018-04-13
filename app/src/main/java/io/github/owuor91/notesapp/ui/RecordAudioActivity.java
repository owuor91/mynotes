package io.github.owuor91.notesapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import io.github.owuor91.notesapp.R;
import pl.droidsonroids.gif.GifImageView;

public class RecordAudioActivity extends AppCompatActivity {
  TextView tvStartRecording, tvStopRecording, tvCounter;
  GifImageView gifImageView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_audio);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvStartRecording = findViewById(R.id.tvStartRecording);
    tvStopRecording = findViewById(R.id.tvStopRecording);
    gifImageView = findViewById(R.id.gifImageView);
    tvCounter = findViewById(R.id.tvCounter);

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