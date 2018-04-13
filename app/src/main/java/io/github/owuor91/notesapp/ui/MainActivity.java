package io.github.owuor91.notesapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import io.github.owuor91.notesapp.R;
import io.github.owuor91.notesapp.datamodels.Note;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  RecyclerView rvNotes;

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
    setupRecyclerView();
  }

  private void setupRecyclerView() {
    rvNotes.setLayoutManager(new LinearLayoutManager(getBaseContext()));
    List<Note> noteList = new ArrayList<Note>();

    Note note1 = Note.newBuilder()
        .withTitle("Title 1")
        .withText("text 1")
        .withLongitude(2.437864)
        .withLatitude(48.438268)
        .build();

    Note note2 =
        Note.newBuilder().withTitle("Title 2").withText("text 2").withLongitude(3.473864).withLatitude(4.36472).build();
    noteList.add(note1);
    noteList.add(note2);

    NotesAdapter notesAdapter = new NotesAdapter(getBaseContext(), noteList);
    rvNotes.setAdapter(notesAdapter);
  }
}
