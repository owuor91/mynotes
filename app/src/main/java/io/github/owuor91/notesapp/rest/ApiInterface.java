package io.github.owuor91.notesapp.rest;

import io.github.owuor91.notesapp.datamodels.Note;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by johnowuor on 13/04/2018.
 */

public interface ApiInterface {
  @GET("notes") Call<List<Note>> getAllNotes();

  @FormUrlEncoded @POST("notes") Call<Note> postNote(@Field("title") String title, @Field("text") String text,
      @Field("logitude") double longitude, @Field("latitude") double latitude);
}
