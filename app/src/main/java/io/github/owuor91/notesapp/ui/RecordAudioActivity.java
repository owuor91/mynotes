package io.github.owuor91.notesapp.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import io.github.owuor91.notesapp.R;
import io.github.owuor91.notesapp.datamodels.DateUtils;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import pl.droidsonroids.gif.GifImageView;

public class RecordAudioActivity extends AppCompatActivity {
  TextView tvStartRecording, tvStopRecording, tvCounter;
  GifImageView gifImageView;
  public static final int REQUEST_RECORD_AUDIO = 432;
  public static final int REQUEST_WRITE_EXTERNAL_STORAGE = 839;
  boolean recording;
  private MediaRecorder mediaRecorder;
  private MediaPlayer mediaPlayer;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_audio);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvStartRecording = (TextView) findViewById(R.id.tvStartRecording);
    tvStopRecording = (TextView) findViewById(R.id.tvStopRecording);
    gifImageView = (GifImageView) findViewById(R.id.gifImageView);
    tvCounter = (TextView) findViewById(R.id.tvCounter);

    tvStartRecording.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Log.d("RecordAudioMF", "clicked start recording shiiiiiii");
        startRecording();
      }
    });

    tvStopRecording.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Log.d("RecordAudioMF", "clicked stop recording meeeeeeh");
        stopRecording();
      }
    });
  }

  /*if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
      {
    ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.RECORD_AUDIO },REQUEST_RECORD_AUDIO);
    }*/

  private void startRecording() {
    Log.d("RecordAudioMF", "parrrmisooons");
    String[] permissions =
        new String[] { Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    if (!hasPermissions(getBaseContext(), permissions)) {
      ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO);
    } else {
      gifImageView.setImageResource(R.drawable.recordingmic);
      Log.d("RecordAudioMF", "chak kae senji");
      File outputFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS),
          String.format("%s%s%s", "/", DateUtils.convertDateTostring(new Date()), ".3gp"));
      Log.d("RecordAudioMF", outputFile.getPath());
      recording = true;
      mediaRecorder = new MediaRecorder();
      mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
      mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
      mediaRecorder.setOutputFile(outputFile.getPath());
      mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

      try {
        mediaRecorder.prepare();
        mediaRecorder.start();
      } catch (IOException e) {
        Log.e(this.getClass().getName(), "prepare() failed");
      }
    }
  }

  private void stopRecording() {
    Log.d("RecordAudioMF", "clicked stop tf");
    recording = false;
    /*mediaRecorder.stop();
    mediaRecorder.release();
    mediaRecorder = null;*/
    gifImageView.setImageResource(R.drawable.stoprecording);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
      case REQUEST_RECORD_AUDIO:
        startRecording();
        break;
    }
  }

  public boolean hasPermissions(Context context, String... permissions) {
    if (context != null && permissions != null) {
      for (String permission : permissions) {
        if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
          return false;
        }
      }
    }
    return true;
  }

  /*private void startPlaying() {
    playing = true;
    tvPlayAudio.setText("Stop playing");
    mediaPlayer = new MediaPlayer();
    try {
      mediaPlayer.setDataSource(fileName);
      mediaPlayer.prepare();
      mediaPlayer.start();
    } catch (IOException e) {
      Log.e(this.getClass().getName(), "prepare() failed");
    }
  }

  private void stopPlaying() {
    playing = false;
    tvPlayAudio.setText("Start playing");
    mediaPlayer.release();
    mediaPlayer = null;
  }*/
}