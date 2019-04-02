package io.github.owuor91.notesapp.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import io.github.owuor91.notesapp.R;
import io.github.owuor91.notesapp.datamodels.Note;
import java.util.List;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
  private Context context;
  private List<Note> noteList;

  public NotesAdapter(Context context, List<Note> noteList) {
    this.context = context;
    this.noteList = noteList;
  }

  @Override public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Note note = noteList.get(position);
    holder.tvTitle.setText(note.getTitle());
    holder.tvText.setText(note.getText());
    if (note.getVoiceUrl() != null && !note.getVoiceUrl().isEmpty()) {
      holder.ivImage.setImageResource(R.drawable.ic_play_circle_outline_blue_48dp);
    }

    holder.cardViewRoot.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        context.startActivity(new Intent(context, ViewNoteActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
      }
    });
  }

  @Override public int getItemCount() {
    return noteList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    TextView tvTitle, tvText, tvEdit, tvDelete;
    ImageView ivImage;
    CardView cardViewRoot;

    public ViewHolder(View view) {
      super(view);
      tvTitle = view.findViewById(R.id.tvNoteItemTitle);
      tvText = view.findViewById(R.id.tvNoteItemText);
      tvEdit = view.findViewById(R.id.tvNoteItemEdit);
      tvDelete = view.findViewById(R.id.tvNoteItemDelete);
      ivImage = view.findViewById(R.id.imgNoteItem);
      cardViewRoot = view.findViewById(R.id.cardViewRoot);
    }
  }
}
