package Model;

import java.util.ArrayList; 
import java.util.Calendar;
import java.util.Date;
import java.util.List; 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author education@oracle.com
 */

@Entity @XmlRootElement @XmlSeeAlso({SimpleAuction.class})
@XmlAccessorType(XmlAccessType.FIELD)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Auction extends DomainEntity {

  @XmlTransient
  @OneToMany(mappedBy="auction",cascade={CascadeType.PERSIST,CascadeType.MERGE})
  private List<Bid> bids;

  @ManyToOne
  private User seller;

  @OneToOne
  private Item item;

  @Temporal(TemporalType.DATE)
  private Date startDate;

  @Temporal(TemporalType.DATE)
  private Date endDate;

  private double startPrice;

  // @XmlTransient
  // transient private BiddingEventManager beManager;

  /**
   * 
   */
  public Auction ()
  {}
  /**
   * 
   * @param seller
   * @param item
   */
  public Auction( User seller, Item item, int nDays, double startPrice ) {
    this.seller = seller;
    this.item = item;
    this.startPrice = startPrice;
    Calendar cal = Calendar.getInstance();
    this.startDate = cal.getTime();
    cal.add( Calendar.DAY_OF_YEAR, nDays );
    this.endDate = cal.getTime();

  }

  /**
   *
   * @param params
   * @return
   */
  protected abstract Bid createBid (User user, double bidAmount);

  /**
   *
   * @param b
   */
  public Bid placeBid (User user, double bidAmount) {
    Bid b = createBid(user,bidAmount);
    if (! isValidBid(b)) {
      return null;
    } else {
      getBids().add( 0, b );
      // beManager.notifyListeners( b );
      return b;
    }
  }

  /**
   *
   * @return
   */
  public abstract Bid getHighBid ();

  /**
   * 
   * @return
   */
  public List<Bid> getBids () {
    return (bids != null) ? bids : (bids = new ArrayList<Bid>());
  }

  /**
   *
   * @param val
   */
  public void setBids (List<Bid> val) {
    if (bids == null) {
        bids = new ArrayList<Bid>( val );
    } else {
        bids.clear();
        bids.addAll( val );
    }
  }

  /**
   *
   * @return
   */
  public abstract List<Bid> getWinningBid ();

  /**
   *
   */
  public abstract void close ();

  /**
   *
   * @param bl
   */
  public void registerInterest (BiddingListener bl) {
      // beManager.registerInterest(bl, this);
  }

  /**
   *
   * @return
   */
  // public BiddingEventManager getBeManager () {
  //    return beManager;
  // }

  /**
   *
   * @param val
   */
  // public void setBeManager (BiddingEventManager val) {
  //    this.beManager = val;
  // }

  /**
   *
   * @return
   */
  public User getSeller () {
      return seller;
  }

  /**
   *
   * @param val
   */
  public void setSeller (User val) {
      this.seller = val;
  }

  /**
   *
   * @param b
   * @return
   */
  protected abstract boolean isValidBid (Bid b);

  /**
   * @return the item
   */
  public Item getItem() {
    return item;
  }

  /**
   * @param item the item to set
   */
  public void setItem( Item item ) {
    this.item = item;
  }

  public List<User> getBidders() {
    return null;
  }

  /**
   * @return the startDate
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * @param startDate the startDate to set
   */
  public void setStartDate( Date startDate ) {
    this.startDate = startDate;
  }

  /**
   * @return the endDate
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * @param endDate the endDate to set
   */
  public void setEndDate( Date endDate ) {
    this.endDate = endDate;
  }

  /**
   * @return the startPrice
   */
  public double getStartPrice() {
    return startPrice;
  }

  /**
   * @param startPrice the startPrice to set
   */
  public void setStartPrice( double startPrice ) {
    this.startPrice = startPrice;
  }

}

