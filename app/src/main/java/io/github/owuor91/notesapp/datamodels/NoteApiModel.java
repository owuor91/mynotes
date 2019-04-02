package io.github.owuor91.notesapp.datamodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class NoteApiModel {
  @SerializedName("id")
  private int id;

  @SerializedName("title")
  private String title;

  @SerializedName("text")
  private String text;

  @SerializedName("image_url")
  private String imageUrl;

  @SerializedName("latitude")
  private double latitude;

  @SerializedName("longitude")
  private double longitude;

  @SerializedName("voice_url")
  private String voiceUrl;

  @SerializedName("created_at")
  private String createdAt;

  @SerializedName("last_modified")
  private String lastModified;

  public NoteApiModel() {
  }

  private NoteApiModel(Builder builder) {
    setId(builder.id);
    setTitle(builder.title);
    setText(builder.text);
    setImageUrl(builder.imageUrl);
    setLatitude(builder.latitude);
    setLongitude(builder.longitude);
    setVoiceUrl(builder.voiceUrl);
    setCreatedAt(builder.createdAt);
    setLastModified(builder.lastModified);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public String getVoiceUrl() {
    return voiceUrl;
  }

  public void setVoiceUrl(String voiceUrl) {
    this.voiceUrl = voiceUrl;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getLastModified() {
    return lastModified;
  }

  public void setLastModified(String lastModified) {
    this.lastModified = lastModified;
  }

  public static final class Builder {
    private int id;
    private String title;
    private String text;
    private String imageUrl;
    private double latitude;
    private double longitude;
    private String voiceUrl;
    private String createdAt;
    private String lastModified;

    private Builder() {
    }

    public Builder withId(int val) {
      id = val;
      return this;
    }

    public Builder withTitle(String val) {
      title = val;
      return this;
    }

    public Builder withText(String val) {
      text = val;
      return this;
    }

    public Builder withImageUrl(String val) {
      imageUrl = val;
      return this;
    }

    public Builder withLatitude(double val) {
      latitude = val;
      return this;
    }

    public Builder withLongitude(double val) {
      longitude = val;
      return this;
    }

    public Builder withVoiceUrl(String val) {
      voiceUrl = val;
      return this;
    }

    public Builder withCreatedAt(String val) {
      createdAt = val;
      return this;
    }

    public Builder withLastModified(String val) {
      lastModified = val;
      return this;
    }

    public NoteApiModel build() {
      return new NoteApiModel(this);
    }
  }
}
