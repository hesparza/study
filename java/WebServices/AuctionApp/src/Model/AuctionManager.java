package Model;

import java.util.ArrayList; 
import java.util.List; 
import java.util.Map;

/**
 *
 * @author education@oracle.com
 */
public class AuctionManager {

  /**
   *
   */
  private List<Auction> auctions;

  /**
   *
   */
  public AuctionManager () {
  }

  /**
   *
   * @param params
   * @return
   */
  public Auction createAuction (Map params) {
      Auction result = new SimpleAuction();
      auctions.add( result );
      return result;
  }

  /**
   *
   * @param query
   * @return
   */
  public List<Auction> findAuctions (String query) {
      return null;
  }

  /**
   *
   * @return
   */
  public List<Auction> getAuctions () {
      return new ArrayList<Auction>( auctions );
  }

  /**
   *
   * @param val
   */
  public void setAuctions (List<Auction> val) {
      if (auctions == null) {
          auctions = new ArrayList<Auction>( val );
      } else {
          auctions.clear();
          auctions.addAll( val );
      }
  }
}

