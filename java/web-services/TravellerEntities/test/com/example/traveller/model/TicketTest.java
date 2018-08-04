/*
 */

package com.example.traveller.model;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
public class TicketTest extends GenericTest<Ticket> {

  private static final Calendar calendar = Calendar.getInstance();

  private static final String EXPECTED_AIRLINE = "PanAm";
  private static final String EXPECTED_NUMBER_1 = "123";
  private static final String EXPECTED_NUMBER_2 = "321";
  private static Airport EXPECTED_DEPARTS =
          new Airport( "JFK", "New York Kennedy" );
  private static Airport EXPECTED_ARRIVES =
          new Airport( "SFO", "San Francisco International");
  private static final Date EXPECTED_DEPARTURE_DATE_1;
  private static final Date EXPECTED_DEPARTURE_DATE_2;
  private static final Date EXPECTED_ARRIVAL_DATE_1;
  private static final Date EXPECTED_ARRIVAL_DATE_2;
  private static final int EXPECTED_MAX_SEATS = 100;
  private static final Flight EXPECTED_FLIGHT_1;
  private static final Flight EXPECTED_FLIGHT_2;

  private static Date EXPECTED_ISSUE_DATE;
  private static String EXPECTED_CONFIRMATION_CODE = "AAABBB";
  private static double EXPECTED_PRICE = 150.0;
  private static Passenger EXPECTED_PASSENGER =
          new Passenger( "Tracy", "Smith", "1234567890", "212-555-1234" );

  private static Date NEW_ISSUE_DATE;
  private static String NEW_CONFIRMATION_CODE = "BBBAAA";
  private static double NEW_PRICE = 250.0;
  private static Passenger NEW_PASSENGER =
          new Passenger( "Kelly", "Jones", "0987654321", "212-555-4321" );

  private static Payment EXPECTED_PAYMENT;
  private static Payment NEW_PAYMENT;

  static
  {
    calendar.set( 2011, 11, 1, 12, 0 );
    EXPECTED_ISSUE_DATE = calendar.getTime();
    calendar.set( 2011, 11, 2, 12, 0 );
    NEW_ISSUE_DATE = calendar.getTime();
    calendar.set( 2012, 0, 1, 12, 0 );
    EXPECTED_DEPARTURE_DATE_1 = calendar.getTime();
    calendar.set( 2012, 0, 1, 18, 0 );
    EXPECTED_ARRIVAL_DATE_1 = calendar.getTime();
    calendar.set( 2012, 1, 1, 15, 0 );
    EXPECTED_DEPARTURE_DATE_2 = calendar.getTime();
    calendar.set( 2012, 1, 1, 21, 0 );
    EXPECTED_ARRIVAL_DATE_2 = calendar.getTime();

    EXPECTED_FLIGHT_1 =
      new Flight( EXPECTED_AIRLINE, EXPECTED_NUMBER_1,
                  EXPECTED_DEPARTS, EXPECTED_ARRIVES,
                  EXPECTED_DEPARTURE_DATE_1, EXPECTED_ARRIVAL_DATE_1,
                  EXPECTED_MAX_SEATS );
    EXPECTED_FLIGHT_2 =
      new Flight( EXPECTED_AIRLINE, EXPECTED_NUMBER_2,
                  EXPECTED_ARRIVES, EXPECTED_DEPARTS,
                  EXPECTED_DEPARTURE_DATE_2, EXPECTED_ARRIVAL_DATE_2,
                  EXPECTED_MAX_SEATS );

    EXPECTED_PAYMENT =
      new Payment( "First National", "1234-5678-9012",
                   EXPECTED_ISSUE_DATE );
    NEW_PAYMENT =
      new Payment( "Second National", "4321-5678-9012",
                   NEW_ISSUE_DATE );
  }

  @BeforeClass
  public static void initialize() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    em.persist( EXPECTED_DEPARTS );
    em.persist( EXPECTED_ARRIVES );
    em.persist( EXPECTED_FLIGHT_1 );
    em.persist( EXPECTED_FLIGHT_2 );
    em.persist( EXPECTED_PASSENGER );
    em.persist( NEW_PASSENGER );
    em.persist( EXPECTED_PAYMENT );
    em.persist( NEW_PAYMENT );
    tx.commit();
    em.close();
  }

  @Override
  protected Ticket createTestObject() {
    return new Ticket( EXPECTED_ISSUE_DATE, EXPECTED_CONFIRMATION_CODE,
                       EXPECTED_PRICE, getExpectedPassenger() );
  }

  Passenger getExpectedPassenger() {
    return em.find( Passenger.class, EXPECTED_PASSENGER.getId() );
  }
  Passenger getNewPassenger() {
    return em.find( Passenger.class, NEW_PASSENGER.getId() );
  }
  Payment getNewPayment() {
    return em.find( Payment.class, NEW_PAYMENT.getId() );
  }

  @Test
  public void testGetIssueDate() {
    log( "getIssueDate" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals( EXPECTED_ISSUE_DATE, instance.getIssueDate() );
    tx.commit();
  }

  @Test
  public void testSetIssueDate() {
    log( "setIssueDate" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    instance.setIssueDate( NEW_ISSUE_DATE );
    assertEquals( NEW_ISSUE_DATE, instance.getIssueDate() );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( NEW_ISSUE_DATE, instance.getIssueDate() );
    tx.commit();
  }

  @Test
  public void testGetConfirmationCode() {
    log( "getConfirmationCode" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals(EXPECTED_CONFIRMATION_CODE,instance.getConfirmationCode());
    tx.commit();
  }

  @Test
  public void testSetConfirmationCode() {
    log( "setConfirmationCode" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    instance.setConfirmationCode( NEW_CONFIRMATION_CODE );
    assertEquals( NEW_CONFIRMATION_CODE, instance.getConfirmationCode() );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( NEW_CONFIRMATION_CODE, instance.getConfirmationCode() );
    tx.commit();
  }

  @Test
  public void testGetPrice() {
    log( "getPrice" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals( EXPECTED_PRICE, instance.getPrice(), 0.001 );
    tx.commit();
  }

  @Test
  public void testSetPrice() {
    log( "setPrice" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    instance.setPrice( NEW_PRICE );
    assertEquals( NEW_PRICE, instance.getPrice(), 0.001 );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( NEW_PRICE, instance.getPrice(), 0.001 );
    tx.commit();
  }

  @Test @Ignore
  public void testGetFlights() {
    log( "getFlights" );
  }

  @Test @Ignore
  public void testSetFlights() {
    log( "setFlights" );
  }

  @Test
  public void testGetPassenger() {
    log( "getPassenger" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals( getExpectedPassenger(), instance.getPassenger() );
    assertTrue( instance.getPassenger().getTickets().contains(instance));
    tx.commit();
  }

  @Test
  public void testSetPassenger() {
    log( "setPassenger" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    Passenger oldPassenger = instance.getPassenger();
    assertTrue( oldPassenger.getTickets().contains(instance) );
    instance.setPassenger( getNewPassenger() );
    assertEquals( getNewPassenger(), instance.getPassenger() );
    assertTrue( instance.getPassenger().getTickets().contains(instance));
    assertFalse( oldPassenger.getTickets().contains( instance ) );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( getNewPassenger(), instance.getPassenger() );
    assertTrue( instance.getPassenger().getTickets().contains(instance));
    tx.commit();
  }

  @Test
  public void testIsConfirmed() {
    log( "isConfirmed" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals( false, instance.isConfirmed() );
    tx.commit();
  }

  @Test
  public void testSetConfirmed() {
    log( "setConfirmed" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    instance.setConfirmed( true );
    assertEquals( true, instance.isConfirmed() );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( true, instance.isConfirmed() );
    tx.commit();
  }

  @Test
  public void testGetPayment() {
    log( "getPayment" );

    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    assertEquals( null, instance.getPayment() );
    tx.commit();
  }

  @Test
  public void testSetPayment() {
    log( "setPayment" );

    tx = em.getTransaction();
    tx.begin();
    Ticket instance = em.find( Ticket.class, testObjectId );
    instance.setPayment( getNewPayment() );
    assertEquals( getNewPayment(), instance.getPayment() );
    assertTrue( (NEW_PAYMENT != null) == instance.isConfirmed() );
    tx.commit();

    tx.begin();
    instance = em.find( Ticket.class, testObjectId );
    assertEquals( getNewPayment(), instance.getPayment() );
    assertTrue( (NEW_PAYMENT != null) == instance.isConfirmed() );    
    tx.commit();
  }

}
