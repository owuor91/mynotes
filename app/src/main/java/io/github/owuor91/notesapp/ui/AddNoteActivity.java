package io.github.owuor91.notesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import io.github.owuor91.notesapp.R;

public class AddNoteActivity extends AppCompatActivity {
  static final int REQUEST_IMAGE_CAPTURE = 1;
  TextView tvAddVoiceNote, tvAddPhoto;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_note);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvAddPhoto = (TextView) findViewById(R.id.tvAddPhoto);

    tvAddVoiceNote = (TextView) findViewById(R.id.tvAddVoiceNote);
    tvAddVoiceNote.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        startActivity(new Intent(getBaseContext(), RecordAudioActivity.class));
      }
    });

    tvAddPhoto.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
          startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
      }
    });
  }
}
