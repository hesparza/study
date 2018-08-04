/*
 */

package com.example.traveller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author education@oracle.com
 */
@Entity @XmlType
public class Ticket extends DomainEntity implements Serializable
{
  @Temporal(TemporalType.DATE) @Basic(optional=false)
  private Date issueDate;
  @Basic(optional=false) private String confirmationCode;
  private double price;
  @ManyToMany(cascade={CascadeType.PERSIST})
  private List<Flight> flights = new ArrayList<Flight>();
  @ManyToOne(cascade={CascadeType.PERSIST})
  private Passenger passenger;
  private boolean confirmed;
  @OneToOne(cascade={CascadeType.PERSIST})
  private Payment payment;

  public Ticket() {}

  public Ticket( Date issueDate, String confirmationCode,
                 double price, Passenger passenger ) {
    this.issueDate = issueDate;
    this.confirmationCode = confirmationCode;
    this.price = price;
    this.passenger = passenger;

    if (this.passenger != null) this.passenger.addTicket( this );
  }

  /**
   * @return the issueDate
   */
  public Date getIssueDate() {
    return issueDate;
  }

  /**
   * @param issueDate the issueDate to set
   */
  public void setIssueDate( Date issueDate ) {
    this.issueDate = issueDate;
  }

  /**
   * @return the confirmationCode
   */
  public String getConfirmationCode() {
    return confirmationCode;
  }

  /**
   * @param confirmationCode the confirmationCode to set
   */
  public void setConfirmationCode( String confirmationCode ) {
    this.confirmationCode = confirmationCode;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice( double price ) {
    this.price = price;
  }

  /**
   * @return the flights
   */
  public List<Flight> getFlights() {
    return Collections.unmodifiableList( flights );
  }

  public void addFlight( Flight flight ) {
    flights.add( flight );
    flight.addTicket( this );
  }

  /**
   * @param flights the flights to set
   */
  public void setFlights( List<Flight> flights ) {
    this.flights = flights;
  }

  /**
   * @return the confirmed
   */
  public boolean isConfirmed() {
    return confirmed;
  }

  /**
   * @param confirmed the confirmed to set
   */
  public void setConfirmed( boolean confirmed ) {
    this.confirmed = confirmed;
  }

  /**
   * @return the payment
   */
  public Payment getPayment() {
    return payment;
  }

  /**
   * @param payment the payment to set
   */
  public void setPayment( Payment payment ) {
    this.payment = payment;
    setConfirmed( true );
  }

  /**
   * @return the passenger
   */
  public Passenger getPassenger() {
    return passenger;
  }

  /**
   * @param passenger the passenger to set
   */
  public void setPassenger( Passenger passenger ) {
    Passenger oldPassenger = this.passenger;
    this.passenger = passenger;
    if (oldPassenger != null) oldPassenger.removeTicket( this );
    this.passenger.addTicket( this );
  }

  private static final long serialVersionUID = 0L;
}
