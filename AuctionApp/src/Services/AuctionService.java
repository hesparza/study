package Services;

import Model.Auction;
import Model.Bid;
import java.util.ArrayList; 
import java.util.Map;

/**
 *
 * @author education@oracle.com
 */
public class AuctionService {

  /**
   *
   */
  public AuctionService () {
  }

  /**
   *
   * @param params
   * @return
   */
  public Auction createAuction (Map params) {
      return null;
  }

  /**
   *
   * @param query
   * @return
   */
  public ArrayList<Auction> findAuctions (String query) {
      return null;
  }

  /**
   *
   * @param auction
   * @param bid
   */
  public void placeBid (Auction auction, Bid bid) {
  }

  /**
   *
   * @param auction
   * @return
   */
  public ArrayList<Bid> getWinningBid (Auction auction) {
      return null;
  }

  /**
   *
   * @return
   */
  public Bid getHighBid () {
      return null;
  }
}

