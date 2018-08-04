/*
 */

package com.example.traveller.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author education@oracle.com
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public class DomainEntity {
  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  @XmlAttribute
  protected long id;
  @Version
  @XmlAttribute()
  protected Integer version;

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( long id ) {
    this.id = id;
  }

  /**
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion( Integer version ) {
    this.version = version;
  }
}
