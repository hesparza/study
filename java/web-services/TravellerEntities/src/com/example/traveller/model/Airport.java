package com.example.traveller.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @(#) Airport.java
 */

@Entity
@XmlRootElement
public class Airport
        extends DomainEntity
        implements Serializable {
  @Basic(optional=false) @Column(updatable=false,unique=true)
  private String code;
  private String name;

  public Airport() {}

  public Airport( String code, String name ) {
    this.code = code;  this.name = name;
  }

  @Override
  public boolean equals( Object obj ) {
    if ((obj == null) || (getClass() != obj.getClass())) {
      return false;
    }
    final Airport other = (Airport) obj;
    if ((this.id != 0) && (other.id != 0) && (this.id != other.id)) {
      return false;
    }
    if ((this.code == null) ? (other.code != null) : !this.code.equals( other.code )) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + (this.code != null ? this.code.hashCode() : 0);
    return hash;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode( String code ) {
    this.code = code;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName( String name ) {
    this.name = name;
  }
  
  /**
   * Construct string representation of instance.
   * @return string representation of instance.
   */
  public String toString() {
    return "[Arport code: '" + code + "' name: '" + name + "']";
  }

  private static final long serialVersionUID = 0L;
}
