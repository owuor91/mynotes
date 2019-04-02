package io.github.owuor91.notesapp.datamodels;

import java.util.Date;

/**
 * Created by johnowuor on 13/04/2018.
 */

public class Note {
  private int id;

  private String title;

  private String text;

  private String imageUrl;

  private double latitude;

  private double longitude;

  private String voiceUrl;

  private Date createdAt;

  private Date lastModified;

  public Note() {
  }

  private Note(Builder builder) {
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
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
    private Date createdAt;
    private Date lastModified;

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

    public Builder withCreatedAt(Date val) {
      createdAt = val;
      return this;
    }

    public Builder withLastModified(Date val) {
      lastModified = val;
      return this;
    }

    public Note build() {
      return new Note(this);
    }
  }
}
