package Model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author education@oracle.com
 */
public class BiddingEvent {

  /**
   *
   */
  private double currentAmount;

  /**
   *
   */
  private Date bidTime;

  /**
   *
   */
  private Auction auction;

  /**
   *
   */
  private static Calendar CALENDAR = Calendar.getInstance();

  /**
   *
   */
  public BiddingEvent () {
  }

  /**
   *
   * @param auction
   * @param amount
   */
  public BiddingEvent( Auction auction, double amount ) {
      this.auction = auction;
      this.currentAmount = amount;
      this.bidTime = CALENDAR.getTime();
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
  public Date getBidTime () {
      return bidTime;
  }

  /**
   *
   * @param val
   */
  public void setBidTime ( Date val) {
      this.bidTime = val;
  }

  /**
   *
   * @return
   */
  public double getCurrentAmount () {
      return currentAmount;
  }

  /**
   *
   * @param val
   */
  public void setCurrentAmount (double val) {
      this.currentAmount = val;
  }
}

