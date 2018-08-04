package Model;

import java.util.List; 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author education@oracle.com
 */
@Entity @Table(name="AuctionUser") @XmlRootElement
public class User extends DomainEntity {

  private String username;
  private String email;

  /**
   *
   */
  @OneToMany(mappedBy="seller",cascade={CascadeType.PERSIST,CascadeType.MERGE})
  private List<Auction> auctions;

  /**
   *
   */
  @OneToMany(mappedBy="bidder",cascade={CascadeType.PERSIST,CascadeType.MERGE})
  private List<Bid> bids;

  /**
   *
   */
  public User () {
  }

  public User(String username, String email) {
    this.username = username;
    this.email = email;
  }

  /**
   *
   * @return
   */
  public List<Auction> getAuctions () {
      return auctions;
  }

  /**
   *
   * @param val
   */
  public void setAuctions (List<Auction> val) {
      this.auctions = val;
  }

  /**
   *
   * @return
   */
  public List<Bid> getBids () {
      return bids;
  }

  /**
   *
   * @param val
   */
  public void setBids (List<Bid> val) {
      this.bids = val;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername( String username ) {
    this.username = username;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail( String email ) {
    this.email = email;
  }
}

