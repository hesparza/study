/*
 */

package com.example.traveller.model;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author education@oracle.com
 */
public class PassengerTest extends GenericTest<Passenger> {

  private static final String EXPECTED_FIRST_NAME = "Tracy";
  private static final String EXPECTED_LAST_NAME = "Smith";
  private static final String EXPECTED_FREQ_FLYER_NUM = "1234567890";
  private static final String EXPECTED_PHONE_NUM = "212-555-1234";

  private static final String NEW_FIRST_NAME = "Kelly";
  private static final String NEW_LAST_NAME = "Jones";
  private static final String NEW_FREQ_FLYER_NUM = "0987654321";
  private static final String NEW_PHONE_NUM = "212-555-4321";

  public PassengerTest() {
    super( new Passenger( EXPECTED_FIRST_NAME, EXPECTED_LAST_NAME,
                          EXPECTED_FREQ_FLYER_NUM, EXPECTED_PHONE_NUM ) );
  }

  @Test
  public void testGetFirstName() {
    log( "getFirstName" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    assertEquals( EXPECTED_FIRST_NAME, instance.getFirstName() );
    tx.commit();
  }

  @Test
  public void testSetFirstName() {
    log( "setFirstName" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    instance.setFirstName( NEW_FIRST_NAME );
    assertEquals( NEW_FIRST_NAME, instance.getFirstName() );
    tx.commit();

    tx.begin();
    instance = em.find( Passenger.class, testObjectId );
    assertEquals( NEW_FIRST_NAME, instance.getFirstName() );
    tx.commit();
  }

  @Test
  public void testGetLastName() {
    log( "getLastName" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    assertEquals( EXPECTED_LAST_NAME, instance.getLastName() );
    tx.commit();
  }

  @Test
  public void testSetLastName() {
    log( "setLastName" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    instance.setLastName( NEW_LAST_NAME );
    assertEquals( NEW_LAST_NAME, instance.getLastName() );
    tx.commit();

    tx.begin();
    instance = em.find( Passenger.class, testObjectId );
    assertEquals( NEW_LAST_NAME, instance.getLastName() );
    tx.commit();
  }

  @Test
  public void testGetPhoneNumber() {
    log( "getPhoneNumber" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    assertEquals( EXPECTED_PHONE_NUM, instance.getPhoneNumber() );
    tx.commit();
  }

  @Test
  public void testSetPhoneNumber() {
    log( "setPhoneNumber" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    instance.setPhoneNumber( NEW_PHONE_NUM );
    assertEquals( NEW_PHONE_NUM, instance.getPhoneNumber() );
    tx.commit();

    tx.begin();
    instance = em.find( Passenger.class, testObjectId );
    assertEquals( NEW_PHONE_NUM, instance.getPhoneNumber() );
    tx.commit();
  }

  @Test
  public void testGetFreqFlyerId() {
    log( "getFreqFlyerId" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    assertEquals( EXPECTED_FREQ_FLYER_NUM, instance.getFreqFlyerId() );
    tx.commit();
  }

  @Test
  public void testSetFreqFlyerId() {
    log( "setFreqFlyerId" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    instance.setFreqFlyerId( NEW_FREQ_FLYER_NUM );
    assertEquals( NEW_FREQ_FLYER_NUM, instance.getFreqFlyerId() );
    tx.commit();

    tx.begin();
    instance = em.find( Passenger.class, testObjectId );
    assertEquals( NEW_FREQ_FLYER_NUM, instance.getFreqFlyerId() );
    tx.commit();
  }

  @Test @Ignore
  public void testGetTickets() {
    log( "getTickets" );
  }

  @Test @Ignore
  public void testSetTickets() {
    log( "setTickets" );
  }

  @Test
  public void testGetVersion() {
    log( "getVersion" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    Integer expected = 1;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }

  @Test
  public void testSetVersion() {
    log( "setVersion" );

    tx = em.getTransaction();
    tx.begin();
    Passenger instance = em.find( Passenger.class, testObjectId );
    instance.setFirstName( NEW_FIRST_NAME );
    assertEquals( NEW_FIRST_NAME, instance.getFirstName() );
    tx.commit();

    tx.begin();
    instance = em.find( Passenger.class, testObjectId );
    Integer expected = 2;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }
}
