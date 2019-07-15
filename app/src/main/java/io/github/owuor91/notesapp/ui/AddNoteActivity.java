package io.github.owuor91.notesapp.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import io.github.owuor91.notesapp.R;

public class AddNoteActivity extends AppCompatActivity {
  static final int REQUEST_IMAGE_CAPTURE = 1;
  TextView tvAddVoiceNote, tvAddPhoto;
  Button btnSaveNote;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_note);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvAddPhoto = findViewById(R.id.tvAddPhoto);
    btnSaveNote = findViewById(R.id.btnSaveNote);

    tvAddVoiceNote = findViewById(R.id.tvAddVoiceNote);
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

  @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
      Bundle extras = data.getExtras();

      Bitmap bitmap = (Bitmap) extras.get("data");
      Log.d("TAG", bitmap.toString());
    }
  }
}
