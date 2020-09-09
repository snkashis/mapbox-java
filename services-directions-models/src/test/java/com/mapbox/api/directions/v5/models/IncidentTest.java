package com.mapbox.api.directions.v5.models;

import com.mapbox.core.TestUtils;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncidentTest extends TestUtils {

  @Test
  public void sanity() {
    assertNotNull(buildDefaultIncident());
  }

  @Test
  public void testSerializable() throws Exception {
    Incident incident = buildDefaultIncident();
    byte[] serialized = TestUtils.serialize(incident);
    assertEquals(incident, deserialize(serialized, Incident.class));
  }

  @Test
  public void testFromJson() {
    String incidentJsonString = "{"
        + "\"incident_type\": \"road_closure\","
        + "\"start_time\": 1598575905,"
        + "\"end_time\": 1598577876,"
        + "\"creation_time\": 1598572305,"
        + "\"id\": 5"
        + "}";
    Incident incident = Incident.fromJson(incidentJsonString);

    Assert.assertEquals("road_closure", incident.incidentType());
    Assert.assertEquals(1598572305, incident.creationTime(), 0);
    Assert.assertEquals(1598575905, incident.startTime(), 0);
    Assert.assertEquals(1598577876, incident.endTime(), 0);
    Assert.assertEquals(5, incident.id(), 0);

    String jsonStr = incident.toJson();

    compareJson(incidentJsonString, jsonStr);
  }

  @Test
  public void testToFromJson() {
    Incident incident = buildDefaultIncident();

    String jsonString = incident.toJson();
    Incident incidentFromJson = Incident.fromJson(jsonString);

    Assert.assertEquals(incident, incidentFromJson);
  }

  private Incident buildDefaultIncident() {
    return Incident.builder()
        .startTime(DEFAULT_START_TIME)
        .endTime(DEFAULT_END_TIME)
        .creationTime(DEFAULT_CREATION_TIME)
        .incidentType(DEFAULT_TYPE)
        .id(DEFAULT_ID)
        .build();
  }

  private static final Long DEFAULT_START_TIME = 1L;
  private static final Long DEFAULT_END_TIME = 2L;
  private static final Long DEFAULT_CREATION_TIME = 3L;
  private static final String DEFAULT_TYPE = "test";
  private static final Integer DEFAULT_ID = 111;
}
