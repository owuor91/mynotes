package io.github.owuor91.notesapp.datamodels;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class NotesMapper {
  public static Note convertFromApi(NoteApiModel noteApiModel) {
    return Note.newBuilder()
        .withId(noteApiModel.getId())
        .withTitle(noteApiModel.getTitle())
        .withText(noteApiModel.getText())
        .withImageUrl(noteApiModel.getImageUrl())
        .withLongitude(noteApiModel.getLongitude())
        .withLatitude(noteApiModel.getLatitude())
        .withVoiceUrl(noteApiModel.getVoiceUrl())
        .withCreatedAt(DateUtils.parseDate(noteApiModel.getCreatedAt()))
        .withLastModified(DateUtils.parseDate(noteApiModel.getLastModified()))
        .build();
  }

  public static NoteDbModel convertToDb(Note note) {
    return NoteDbModel.newBuilder()
        .withId(note.getId())
        .withTitle(note.getTitle())
        .withText(note.getNoteText())
        .withImageUrl(note.getImageUrl())
        .withLongitude(note.getLongitude())
        .withLatitude(note.getLatitude())
        .withVoiceUrl(note.getVoiceUrl())
        .withCreatedAt(DateUtils.convertDateTostring(note.getCreatedAt()))
        .withLastModified(DateUtils.convertDateTostring(note.getLastModified()))
        .build();
  }

  public static Note convertFromApi(NoteDbModel noteDbModel) {
    return Note.newBuilder()
        .withId(noteDbModel.getId())
        .withTitle(noteDbModel.getTitle())
        .withText(noteDbModel.getText())
        .withImageUrl(noteDbModel.getImageUrl())
        .withLongitude(noteDbModel.getLongitude())
        .withLatitude(noteDbModel.getLatitude())
        .withVoiceUrl(noteDbModel.getVoiceUrl())
        .withCreatedAt(DateUtils.parseDate(noteDbModel.getCreatedAt()))
        .withLastModified(DateUtils.parseDate(noteDbModel.getLastModified()))
        .build();
  }
}
