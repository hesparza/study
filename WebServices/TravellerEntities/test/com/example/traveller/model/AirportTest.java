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
public class AirportTest extends GenericTest<Airport> {

  private static final String EXPECTED_CODE = "MSN";
  private static final String EXPECTED_NAME = "Madison, WI";
  private static final String NEW_CODE = "MXN";
  private static final String NEW_NAME = "Dane County Regional Airport";

  public AirportTest() {
    super( new Airport( EXPECTED_CODE, EXPECTED_NAME ) );
  }

  @Test
  public void testGetCode() {
    log( "getCode" );

    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    String result = instance.getCode();
    tx.commit();
    assertEquals( EXPECTED_CODE, result );
  }

  @Test
  @Ignore("Bug in EclipseLink: ignores updatable=false")
  public void testSetCode() {
    log( "setCode" );
    
    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    instance.setCode( NEW_CODE );
    assertEquals( NEW_CODE, instance.getCode() );
    tx.commit();

    tx.begin();
    instance = em.find( Airport.class, testObjectId );
    assertEquals( NEW_CODE, instance.getCode() );
    tx.commit();
  }

  @Test
  public void testGetName() {
    log( "getName" );

    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    assertEquals( EXPECTED_NAME, instance.getName() );
    tx.commit();
  }

  @Test
  public void testSetName() {
    log( "setName" );

    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    instance.setName( NEW_NAME );
    assertEquals( NEW_NAME, instance.getName() );
    tx.commit();

    tx.begin();
    instance = em.find( Airport.class, testObjectId );
    assertEquals( NEW_NAME, instance.getName() );
    tx.commit();
  }

  @Test
  public void testGetVersion() {
    log( "getVersion" );
    
    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    Integer expected = 1;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }

  @Test
  public void testSetVersion() {
    log( "setVersion" );

    tx = em.getTransaction();
    tx.begin();
    Airport instance = em.find( Airport.class, testObjectId );
    instance.setName( NEW_NAME );
    assertEquals( NEW_NAME, instance.getName() );
    tx.commit();

    tx.begin();
    instance = em.find( Airport.class, testObjectId );
    Integer expected = 2;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }
}
