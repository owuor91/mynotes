package io.github.owuor91.notesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import io.github.owuor91.notesapp.R;
import io.github.owuor91.notesapp.datamodels.Note;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
  RecyclerView rvNotes;
  public static final String API_URL = "https://akirachixnotesapi.herokuapp.com/api/v1/notes";
  public static final String TAG = "NOTES_API";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    rvNotes = findViewById(R.id.notesrecyclerView);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivity(new Intent(getBaseContext(), AddNoteActivity.class));
      }
    });

    toolbar.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        startActivity(new Intent(getBaseContext(), ViewNoteActivity.class));
      }
    });
    getNotes();
  }

  private void setupRecyclerView(List<Note> noteList) {
    rvNotes.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(), noteList);
    rvNotes.setAdapter(notesAdapter);
  }

  private void getNotes() {
    StringRequest stringRequest = new StringRequest(Request.Method.GET, API_URL, new Response.Listener<String>() {
      @Override public void onResponse(String response) {
        Log.d(TAG, response);
        List<Note> noteList = new ArrayList<Note>();

        try {
          JSONArray jsonArray = new JSONArray(response);
          for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = jsonObject.getInt("id");
            String title = jsonObject.getString("title");
            String noteText = jsonObject.getString("noteText");
            Note note = new Note(id, title, noteText);
            noteList.add(note);
          }
        } catch (Exception e) {
          Log.e(TAG, e.getMessage());
        }

        setupRecyclerView(noteList);
      }
    }, new Response.ErrorListener() {
      @Override public void onErrorResponse(VolleyError error) {
        Log.d(TAG, error.getMessage());
      }
    });

    RequestQueue requestQueue = Volley.newRequestQueue(getBaseContext());
    requestQueue.add(stringRequest);
  }

}
