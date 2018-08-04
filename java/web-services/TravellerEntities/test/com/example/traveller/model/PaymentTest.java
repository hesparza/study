/*
 */

package com.example.traveller.model;

import java.util.Calendar;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author education@oracle.com
 */
public class PaymentTest extends GenericTest<Payment> {

  private static final String EXPECTED_BANK_NAME = "First National";
  private static final String EXPECTED_CC_NUMBER = "1234-5678-9012";
  private static final Calendar calendar = Calendar.getInstance();
  private static final Date EXPECTED_EXP_DATE;

  private static final String NEW_BANK_NAME = "Second National";
  private static final String NEW_CC_NUMBER = "4321-5678-9012";
  private static final Date NEW_EXP_DATE;

  static
  {
    calendar.set( 2012, 0, 1 );
    EXPECTED_EXP_DATE = calendar.getTime();
    calendar.set( 2012, 1, 1 );
    NEW_EXP_DATE = calendar.getTime();
  }

  public PaymentTest() {
    super( new Payment( EXPECTED_BANK_NAME, EXPECTED_CC_NUMBER,
                        EXPECTED_EXP_DATE ) );
  }

  @Test @Ignore( "Tested with Ticket class" )
  public void testGetTicket() {
    log( "getTicket" );
  }

  @Test @Ignore( "Tested with Ticket class" )
  public void testSetTicket() {
    log( "setTicket" );
  }

  @Test
  public void testGetCreditCardNum() {
    log( "getCreditCardNum" );

    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    assertEquals( EXPECTED_CC_NUMBER, instance.getCreditCardNum() );
    tx.commit();
  }

  @Test
  public void testSetCreditCardNum() {
    log( "setCreditCardNum" );

    tx = em.getTransaction();
    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    instance.setCreditCardNum( NEW_CC_NUMBER );
    assertEquals( NEW_CC_NUMBER, instance.getCreditCardNum() );
    tx.commit();

    tx.begin();
    instance = em.find( Payment.class, testObjectId );
    assertEquals( NEW_CC_NUMBER, instance.getCreditCardNum() );
    tx.commit();
  }

  @Test
  public void testGetBankName() {
    log( "getBankName" );

    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    assertEquals( EXPECTED_BANK_NAME, instance.getBankName() );
    tx.commit();
  }

  @Test
  public void testSetBankName() {
    log( "setBankName" );

    tx = em.getTransaction();
    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    instance.setBankName( NEW_BANK_NAME );
    assertEquals( NEW_BANK_NAME, instance.getBankName() );
    tx.commit();

    tx.begin();
    instance = em.find( Payment.class, testObjectId );
    assertEquals( NEW_BANK_NAME, instance.getBankName() );
    tx.commit();
  }

  @Test
  public void testGetExpirationDate() {
    log( "getExpirationDate" );

    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    assertEquals( EXPECTED_EXP_DATE, instance.getExpirationDate() );
    tx.commit();
  }

  @Test
  public void testSetExpirationDate() {
    log( "setExpirationDate" );

    tx = em.getTransaction();
    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    instance.setExpirationDate( NEW_EXP_DATE );
    assertEquals( NEW_EXP_DATE, instance.getExpirationDate() );
    tx.commit();

    tx.begin();
    instance = em.find( Payment.class, testObjectId );
    assertEquals( NEW_EXP_DATE, instance.getExpirationDate() );
    tx.commit();
  }

  @Test
  public void testGetVersion() {
    log( "getVersion" );

    tx = em.getTransaction();
    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    Integer expected = 1;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }

  @Test
  public void testSetVersion() {
    log( "setVersion" );

    tx = em.getTransaction();
    tx.begin();
    Payment instance = em.find( Payment.class, testObjectId );
    instance.setBankName( NEW_BANK_NAME );
    assertEquals( NEW_BANK_NAME, instance.getBankName() );
    tx.commit();

    tx.begin();
    instance = em.find( Payment.class, testObjectId );
    Integer expected = 2;
    assertEquals( expected, instance.getVersion() );
    tx.commit();
  }
}
