package com.example.traveller.model;


import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlType
public class Flight extends DomainEntity implements Serializable
{
  @ManyToOne(optional=false,cascade=CascadeType.PERSIST)
  private Airport departs;
  @ManyToOne(optional=false,cascade=CascadeType.PERSIST)
  private Airport arrives;
  @Temporal(TemporalType.TIME) @Basic(optional=false)
  private Date departure;
  @Temporal(TemporalType.TIME) @Basic(optional=false)
  private Date arrival;
  @Basic(optional=false)
  private String airline;
  @Basic(optional=false)
  private String number;
  private int maxSeats;
  @ManyToMany(mappedBy="flights")
  private List<Ticket> tickets;

  public Flight() {}

  public Flight( String airline, String flightNum,
          Airport departs, Airport arrives, Date departure,
          Date arrival, int maxSeats ) {
    this.airline = airline;
    this.number = flightNum;
    this.departs = departs;
    this.arrives = arrives;
    this.departure = departure;
    this.arrival = arrival;
    this.maxSeats = maxSeats;
  }

  /**
   * @return the departs
   */
  public Airport getDeparts() {
    return departs;
  }

  /**
   * @param departs the departs to set
   */
  public void setDeparts( Airport departs ) {
    this.departs = departs;
  }

  /**
   * @return the arrives
   */
  public Airport getArrives() {
    return arrives;
  }

  /**
   * @param arrives the arrives to set
   */
  public void setArrives( Airport arrives ) {
    this.arrives = arrives;
  }

  /**
   * @return the departure
   */
  public Date getDeparture() {
    return departure;
  }

  /**
   * @param departure the departure to set
   */
  public void setDeparture( Date departure ) {
    this.departure = departure;
  }

  /**
   * @return the arrival
   */
  public Date getArrival() {
    return arrival;
  }

  /**
   * @param arrival the arrival to set
   */
  public void setArrival( Date arrival ) {
    this.arrival = arrival;
  }

  /**
   * @return the airline
   */
  public String getAirline() {
    return airline;
  }

  /**
   * @param airline the airline to set
   */
  public void setAirline( String airline ) {
    this.airline = airline;
  }

  /**
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * @param number the number to set
   */
  public void setNumber( String number ) {
    this.number = number;
  }

  /**
   * @return the maxSeats
   */
  public int getMaxSeats() {
    return maxSeats;
  }

  /**
   * @param maxSeats the maxSeats to set
   */
  public void setMaxSeats( int maxSeats ) {
    this.maxSeats = maxSeats;
  }

  /**
   * @return the tickets
   */
  public List<Ticket> getTickets() {
    return Collections.unmodifiableList( tickets );
  }

  /**
   * Adds a new ticket to the list of tickets associated with this
   * flight.  This function only manages one half of the bidirectional
   * relationship between tickets and flights, so it should only
   * be called from Ticket (which manages the other half).
   * @param ticket to add
   */
  void addTicket( Ticket ticket ) {
    tickets.add( ticket );
  }

  /**
   * @param tickets the tickets to set
   */
  public void setTickets( List<Ticket> tickets ) {
    this.tickets = tickets;
  }

  @Override
  public boolean equals( Object obj ) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Flight other = (Flight) obj;
    if (this.departure != other.departure && (this.departure == null || !this.departure.equals( other.departure ))) {
      return false;
    }
    if ((this.airline == null) ? (other.airline != null) : !this.airline.equals( other.airline )) {
      return false;
    }
    if ((this.number == null) ? (other.number != null) : !this.number.equals( other.number )) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 23 * hash + (this.number != null ? this.number.hashCode() : 0);
    return hash;
  }

  private static final long serialVersionUID = 0L;
}
