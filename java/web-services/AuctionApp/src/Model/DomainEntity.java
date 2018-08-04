/*
 */

package Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author education@oracle.com
 */
@MappedSuperclass
public class DomainEntity implements java.io.Serializable {

  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  @XmlAttribute
  private long id;

  @Version
  @XmlAttribute
  protected Integer version;

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

}
