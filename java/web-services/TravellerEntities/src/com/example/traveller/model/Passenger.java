package com.example.traveller.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlType;

/**
 * @(#) Passenger.java
 */

@Entity @XmlType
public class Passenger extends DomainEntity implements Serializable
{
  @Basic(optional=false)
  private String firstName;
  @Basic(optional=false)
  private String lastName;
  private String phoneNumber;
  private String freqFlyerId;
  @OneToMany(mappedBy="passenger") 
  private List<Ticket> tickets = new ArrayList<Ticket>();

  public Passenger() {
  }

  public Passenger( String first, String last, String freqFlyer,
                    String phoneNum ) {
    firstName = first;
    lastName = last;
    freqFlyerId = freqFlyer;
    phoneNumber = phoneNum;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }

  /**
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber( String phoneNumber ) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the freqFlyerId
   */
  public String getFreqFlyerId() {
    return freqFlyerId;
  }

  /**
   * @param freqFlyerId the freqFlyerId to set
   */
  public void setFreqFlyerId( String freqFlyerId ) {
    this.freqFlyerId = freqFlyerId;
  }

  /**
   * @return the tickets
   */
  public List<Ticket> getTickets() {
    return Collections.unmodifiableList( tickets );
  }

  /**
   * Adds a new ticket to the list of tickets associated with this
   * passenger.  This function only manages one half of the bidirectional
   * relationship between tickets and passengers, so it should only
   * be called from Ticket (which manages the other half).
   * @param ticket to add
   */
  void addTicket( Ticket ticket ) {
    tickets.add( ticket );
  }

  /**
   * Removes a ticket from the list of tickets associated with this
   * passenger.  This function only manages one half of the bidirectional
   * relationship between tickets and passengers, so it should only
   * be called from Ticket (which manages the other half).
   * @param ticket to remove
   */
  void removeTicket( Ticket ticket ) {
    tickets.remove( ticket );
  }

  /**
   * @param tickets the tickets to set
   */
  public void setTickets( List<Ticket> tickets ) {
    this.tickets = tickets;
  }

  private static final long serialVersionUID = 0L;
}
