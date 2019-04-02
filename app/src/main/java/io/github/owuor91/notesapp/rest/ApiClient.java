package io.github.owuor91.notesapp.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class ApiClient {
  public static final String BASE_URL = "";
  private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

  private static Retrofit.Builder retrofitBuilder =
      new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

  public static <T> T createService(Class<T> serviceClass) {
    Retrofit retrofit = retrofitBuilder.client(httpClientBuilder.build()).build();
    return retrofit.create(serviceClass);
  }
}
