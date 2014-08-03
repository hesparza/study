package Model;

import java.util.ArrayList; 
import java.util.List; 

/**
 *
 * @author education@oracle.com
 */
public class BiddingEventManager {

  /**
   *
   */
  private List<BiddingListener> listeners;

  /**
   *
   */
  public BiddingEventManager () {
  }

  /**
   *
   * @param bl
   * @param a
   */
  public void registerInterest (BiddingListener bl, Auction a) {

  }

  /**
   *
   * @param newBid
   */
  public void notifyListeners (Bid newBid) {
      BiddingEvent event =
        new BiddingEvent(newBid.getAuction(), newBid.getCurrentValue());
      List<BiddingListener> listeners =
        new ArrayList<BiddingListener>(this.listeners);
      for ( BiddingListener listener : listeners ) {
          listener.bidPlaced(event);
      }
  }

  /**
   *
   * @return
   */
  public List<BiddingListener> getListeners () {
      return listeners;
  }

  /**
   *
   * @param val
   */
  public void setListeners (List<BiddingListener> val) {
      this.listeners = val;
  }
}

