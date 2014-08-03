/*
 */

package com.example.traveller.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author education@oracle.com
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.example.traveller.model.AirportTest.class,
                     com.example.traveller.model.FlightTest.class,
                     com.example.traveller.model.PassengerTest.class,
                     com.example.traveller.model.PaymentTest.class})
public class AllTests {

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

  }
