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
import android.widget.EditText;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import io.github.owuor91.notesapp.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AddNoteActivity extends AppCompatActivity {
  static final int REQUEST_IMAGE_CAPTURE = 1;
  TextView tvAddVoiceNote, tvAddPhoto;
  Button btnSaveNote;
  public static final String API_URL = "https://akirachixnotesapi.herokuapp.com/api/v1/notes";
  public static final String TAG = "NOTES_API";
  EditText etTitle, etNoteText;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_note);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    tvAddPhoto = findViewById(R.id.tvAddPhoto);
    btnSaveNote = findViewById(R.id.btnSaveNote);
    etTitle = findViewById(R.id.etTitle);
    etNoteText = findViewById(R.id.etNoteText);

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

    btnSaveNote.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        postNote();
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

  private void postNote() {
    StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
      @Override public void onResponse(String response) {
        Log.d(TAG, response);
        try {
          JSONObject jsonObject = new JSONObject(response);
          int id = jsonObject.getInt("id");
          String title = jsonObject.getString("title");
          String noteText = jsonObject.getString("noteText");
          Log.d(TAG, noteText);
        } catch (Exception e) {
          Log.e(TAG, e.getMessage());
        }
      }
    }, new Response.ErrorListener() {
      @Override public void onErrorResponse(VolleyError error) {
        Log.d(TAG, error.getMessage());
      }
    }) {
      @Override
      protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("title", etTitle.getText().toString());
        params.put("noteText", etNoteText.getText().toString());

        return params;
      }
    };

    RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
    requestQueue.add(stringRequest);
  }



}
