package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author education@oracle.com
 */
@Entity @XmlRootElement @XmlSeeAlso({SimpleBid.class})
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Bid extends DomainEntity {

  /**
   *
   */
  private double maxValue;

  /**
   *
   */
  private double currentValue;

  /**
   *
   */
  @XmlTransient
  @ManyToOne(cascade = CascadeType.PERSIST)
  // needed because EclipseLink complains when both Auction and Bid are new...
  private Auction auction;

  /**
   *
   */
  @XmlTransient
  @ManyToOne
  private User bidder;

  /**
   *
   */
  public Bid () {
  }

  /**
   *
   * @param auction
   * @param bidder
   * @param maxValue
   */
  public Bid(Auction auction, User bidder, double currentValue,
             double maxValue ) {
      this.bidder = bidder;
      this.auction = auction;
      this.maxValue = maxValue;
      this.currentValue = currentValue;
  }

  /**
   *
   * @return
   */
  public Auction getAuction () {
      return auction;
  }

  /**
   *
   * @param val
   */
  public void setAuction (Auction val) {
      this.auction = val;
  }

  /**
   *
   * @return
   */
  public User getBidder () {
      return bidder;
  }

  /**
   *
   * @param val
   */
  public void setBidder (User val) {
      this.bidder = val;
  }

  /**
   *
   * @return
   */
  public double getCurrentValue () {
      return currentValue;
  }

  /**
   *
   * @param val
   */
  public void setCurrentValue (double val) {
      this.currentValue = val;
  }

  /**
   *
   * @return
   */
  public double getMaxValue () {
      return maxValue;
  }

  /**
   *
   * @param val
   */
  public void setMaxValue (double val) {
      this.maxValue = val;
  }

  /**
   *
   * @return
   */
  boolean isValid() {
      return currentValue <= maxValue;
  }
}

