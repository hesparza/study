/*
 */

package com.example.traveller.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author education@oracle.com
 */
public class FlightTest extends GenericTest<Flight> {

  private static final Calendar calendar = Calendar.getInstance();

  private static final String EXPECTED_AIRLINE = "PanAm";
  private static final String EXPECTED_NUMBER = "123";
  private static Airport EXPECTED_DEPARTS =
          new Airport( "JFK", "New York Kennedy" );
  private static Airport EXPECTED_ARRIVES =
          new Airport( "SFO", "San Francisco International");
  private static final Date EXPECTED_DEPARTURE_DATE;
  private static final Date EXPECTED_ARRIVAL_DATE;
  private static final int EXPECTED_MAX_SEATS = 100;

  private static final String NEW_AIRLINE = "TWA";
  private static final String NEW_NUMBER = "321";
  private static Airport NEW_DEPARTS =
          new Airport( "LGA", "New York LaGuardia" );
  private static Airport NEW_ARRIVES =
          new Airport( "OAK", "Oakland" );
  private static final Date NEW_DEPARTURE_DATE;
  private static final Date NEW_ARRIVAL_DATE;
  private static final int NEW_MAX_SEATS = 120;

  private static Map<String,DomainEntity> paramsExpected =
          new HashMap<String,DomainEntity>();

  static
  {
    calendar.set( 2012, 0, 1, 12, 0 );
    EXPECTED_DEPARTURE_DATE = calendar.getTime();
    calendar.set( 2012, 0, 1, 18, 0 );
    EXPECTED_ARRIVAL_DATE = calendar.getTime();
    calendar.set( 2012, 1, 1, 15, 0 );
    NEW_DEPARTURE_DATE = calendar.getTime();
    calendar.set( 2012, 1, 1, 21, 0 );
    NEW_ARRIVAL_DATE = calendar.getTime();

    paramsExpected.put( "EXPECTED_DEPARTS", EXPECTED_DEPARTS );
    paramsExpected.put( "EXPECTED_ARRIVES", EXPECTED_ARRIVES );
    paramsExpected.put( "NEW_DEPARTS", NEW_DEPARTS );
    paramsExpected.put( "NEW_ARRIVES", NEW_ARRIVES );
  }

  @Before
  public void setUp() {
    super.setUp();
    
    try {
      beginTransaction();
      testObject = new Flight(EXPECTED_AIRLINE, EXPECTED_NUMBER,
                              (Airport)params.get("EXPECTED_DEPARTS"),
                              (Airport)params.get("EXPECTED_ARRIVES"),
                              EXPECTED_DEPARTURE_DATE,
                              EXPECTED_ARRIVAL_DATE,
                              EXPECTED_MAX_SEATS);
      em.persist(testObject);
      commitTransaction();
    } finally {
      testObjectId = testObject.getId();
    }
  }

  @After
  public void tearDown() {
    if (testObject != null) {
      beginTransaction();
      em.remove( testObject );
      commitTransaction();
    }

    super.tearDown();
  }

  public FlightTest() {
    super( paramsExpected );
  }

  @Test
  public void testGetDeparts() {
    log( "getDeparts" );

    beginTransaction();
    Flight instance = em.find(Flight.class, testObjectId);
    assertEquals(params.get("EXPECTED_DEPARTS"), instance.getDeparts());
    commitTransaction();
  }

  @Test(expected=AssertionError.class)
  public void testGetDepartsShouldFail() {
    log( "getDepartsShouldFail" );

    try {
      beginTransaction();
      Flight instance = em.find( Flight.class, testObjectId );
      assertEquals( params.get( "NEW_DEPARTS" ), instance.getDeparts() );
    } finally {
      commitTransaction();
    }
  }

  @Test
  public void testSetDeparts() {
    log( "setDeparts" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setDeparts( (Airport) params.get("NEW_DEPARTS") );
    assertEquals( params.get("NEW_DEPARTS"), instance.getDeparts() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( params.get("NEW_DEPARTS"), instance.getDeparts() );
    commitTransaction();
  }

  @Test
  public void testGetArrives() {
    log( "getArrives" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( params.get("EXPECTED_ARRIVES"), instance.getArrives() );
    commitTransaction();
  }

  @Test
  public void testSetArrives() {
    log( "setArrives" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setArrives( (Airport) params.get("NEW_ARRIVES") );
    assertEquals( params.get("NEW_ARRIVES"), instance.getArrives() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( params.get("NEW_ARRIVES"), instance.getArrives() );
    commitTransaction();
  }

  @Test
  public void testGetDeparture() {
    log( "getDeparture" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( EXPECTED_DEPARTURE_DATE, instance.getDeparture() );
    commitTransaction();
  }

  @Test
  public void testSetDeparture() {
    log( "setDeparture" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setDeparture( NEW_DEPARTURE_DATE );
    assertEquals( NEW_DEPARTURE_DATE, instance.getDeparture() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( NEW_DEPARTURE_DATE, instance.getDeparture() );
    commitTransaction();
  }

  @Test
  public void testGetArrival() {
    log( "getArrival" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( EXPECTED_ARRIVAL_DATE, instance.getArrival() );
    commitTransaction();
  }

  @Test
  public void testSetArrival() {
    log( "setArrival" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setArrival( NEW_ARRIVAL_DATE );
    assertEquals( NEW_ARRIVAL_DATE, instance.getArrival() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( NEW_ARRIVAL_DATE, instance.getArrival() );
    commitTransaction();
  }

  @Test
  public void testGetAirline() {
    log( "getAirline" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( EXPECTED_AIRLINE, instance.getAirline() );
    commitTransaction();
  }

  @Test
  public void testSetAirline() {
    log( "setAirline" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setAirline( NEW_AIRLINE );
    assertEquals( NEW_AIRLINE, instance.getAirline() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( NEW_AIRLINE, instance.getAirline() );
    commitTransaction();
  }

  @Test
  public void testGetNumber() {
    log( "getNumber" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( EXPECTED_NUMBER, instance.getNumber() );
    commitTransaction();
  }

  @Test
  public void testSetNumber() {
    log( "setNumber" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setNumber( NEW_NUMBER );
    assertEquals( NEW_NUMBER, instance.getNumber() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( NEW_NUMBER, instance.getNumber() );
    commitTransaction();
  }

  @Test
  public void testGetMaxSeats() {
    log( "getMaxSeats" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    assertEquals( EXPECTED_MAX_SEATS, instance.getMaxSeats() );
    commitTransaction();
  }

  @Test
  public void testSetMaxSeats() {
    log( "setMaxSeats" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setMaxSeats( NEW_MAX_SEATS );
    assertEquals( NEW_MAX_SEATS, instance.getMaxSeats() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    assertEquals( NEW_MAX_SEATS, instance.getMaxSeats() );
    commitTransaction();
  }

  @Test @Ignore( "Tested with class Ticket")
  public void testGetTickets() {
    log( "getTickets" );
  }

  @Test @Ignore( "Tested with class Ticket")
  public void testSetTickets() {
    log( "setTickets" );
  }

  @Test
  public void testGetVersion() {
    log( "getVersion" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    Integer expected = 1;
    assertEquals( expected, instance.getVersion() );
    commitTransaction();
  }

  @Test
  public void testSetVersion() {
    log( "setVersion" );

    beginTransaction();
    Flight instance = em.find( Flight.class, testObjectId );
    instance.setAirline( NEW_AIRLINE );
    assertEquals( NEW_AIRLINE, instance.getAirline() );
    commitTransaction();

    beginTransaction();
    instance = em.find( Flight.class, testObjectId );
    Integer expected = 2;
    assertEquals( expected, instance.getVersion() );
    commitTransaction();
  }
}
