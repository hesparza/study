package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author education@oracle.com
 */
@Entity @XmlRootElement
public class SimpleAuction extends Auction {

  /**
   *
   */
  public SimpleAuction () {
  }

  public
  SimpleAuction( User seller, Item item, int nDays, double startPrice ) {
    super(seller,item,nDays,startPrice);
  }

  /**
   *
   * @param params
   * @return
   */
  @Override
  protected Bid createBid (User user, double bidAmount) {
      return new SimpleBid(this,user,bidAmount);
  }

  /**
   *
   * @return
   */
  public Bid getHighBid () {
    List<Bid> bids = getBids();
    Bid highBid = new SimpleBid();

    if (bids.size() == 0){
      return null;
    }else {
      for(Bid bid:bids){
        if (bid.getCurrentValue() > highBid.getCurrentValue()){
          highBid = bid;
        }
      }
      return highBid;
    }
  }

  /**
   *
   * @return
   */
  public List<Bid> getWinningBid () {
      List<Bid> result = new ArrayList<Bid>(1);
      result.add( getHighBid() );
      return result;
  }

  /**
   *
   */
  public void close () {
  }

  /**
   *
   * @param b
   * @return
   */
  protected boolean isValidBid (Bid b) {
      List<Bid> bids = getBids();
      return ((bids.size() == 0) ||
              (b.getMaxValue() > getHighBid().getMaxValue()));
  }
}

