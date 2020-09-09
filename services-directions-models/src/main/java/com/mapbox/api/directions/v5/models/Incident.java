package com.mapbox.api.directions.v5.models;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;

/**
 * Object representing an incident along the intersection.
 *
 */
@AutoValue
public abstract class Incident extends DirectionsJsonObject {

  /**
   * Incident type.
   *
   * @return incident type
   */
  @NonNull
  @SerializedName("incident_type")
  public abstract String incidentType();

  /**
   * Incident start time.
   *
   * @return incident start time
   */
  @NonNull
  @SerializedName("start_time")
  public abstract Long startTime();

  /**
   * Incident end time.
   *
   * @return incident end time
   */
  @NonNull
  @SerializedName("end_time")
  public abstract Long endTime();

  /**
   * Incident creation time.
   *
   * @return incident creation time
   */
  @NonNull
  @SerializedName("creation_time")
  public abstract Long creationTime();

  /**
   * Incident id.
   *
   * @return incident id
   */
  @NonNull
  public abstract Integer id();

  /**
   * Create a new instance of this class by using the {@link StepIntersection.Builder} class.
   *
   * @return this classes {@link StepIntersection.Builder} for creating a new instance
   * @since 3.0.0
   */
  public static Builder builder() {
    return new AutoValue_Incident.Builder();
  }

  /**
   * Convert the current {@link Incident} to its builder holding the currently assigned values. This
   * allows you to modify a single property and then rebuild the object resulting in an updated and
   * modified {@link Incident}.
   *
   * @return a {@link Builder} with the same values set to match the ones defined in this {@link
   * Incident}
   */
  public abstract Builder toBuilder();

  /**
   * Gson type adapter for parsing Gson to this class.
   *
   * @param gson the built {@link Gson} object
   * @return the type adapter for this class
   */
  public static TypeAdapter<Incident> typeAdapter(Gson gson) {
    return new AutoValue_Incident.GsonTypeAdapter(gson);
  }

  /**
   * Create a new instance of this class by passing in a formatted valid JSON String.
   *
   * @param json a formatted valid JSON string defining an Incident
   * @return a new instance of this class defined by the values passed in the method
   */
  public static Incident fromJson(String json) {
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    return gson.create().fromJson(json, Incident.class);
  }

  /**
   * This builder can be used to set the values describing the {@link Incident}.
   */
  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Type of the incident.
     *
     * @param incidentType String with incident type
     * @return this builder for chaining options together
     */
    public abstract Builder incidentType(@NonNull String incidentType);

    /**
     * Time when incident started.
     *
     * @param startTime Long value describing when incident started
     * @return this builder for chaining options together
     */
    public abstract Builder startTime(@NonNull Long startTime);

    /**
     * Time when incident finished.
     *
     * @param endTime Long value describing when incident finished
     * @return this builder for chaining options together
     */
    public abstract Builder endTime(@NonNull Long endTime);

    /**
     * Time when incident created.
     *
     * @param creationTime Long value describing when incident created
     * @return this builder for chaining options together
     */
    public abstract Builder creationTime(@NonNull Long creationTime);

    /**
     * Id of the incident.
     *
     * @param id int value describing incident's identifier
     * @return this builder for chaining options together
     */
    public abstract Builder id(@NonNull Integer id);

    /**
     * Build a new {@link Incident} object.
     *
     * @return a new {@link Incident} using the provided values in this builder
     */
    public abstract Incident build();
  }
}
