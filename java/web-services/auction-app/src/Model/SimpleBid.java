package Model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author education@oracle.com
 */
@Entity @XmlRootElement
public class SimpleBid extends Bid {

  /**
   *
   */
  public SimpleBid () {
  }

 public SimpleBid(Auction auction, User bidder, double maxValue ) {
   super(auction, bidder, maxValue, maxValue);
 }
}

