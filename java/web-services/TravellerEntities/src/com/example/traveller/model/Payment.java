package com.example.traveller.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * @(#) Payment.java
 */
@Entity
@XmlType
public class Payment extends DomainEntity
        implements Serializable {

    @XmlEnum(String.class)
    public static enum Status {
        pending, processing, accepted, rejected
    };

    @OneToOne(mappedBy = "payment")
    private Ticket ticket;
    @Basic(optional = false)
    private String creditCardNum;
    @Basic(optional = false)
    private String bankName;
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    private Date expirationDate;
    private Status status = Status.pending;

    public Payment() {
    }

    public Payment(String bankName, String ccNum, Date expDate) {
        this.bankName = bankName;
        creditCardNum = ccNum;
        expirationDate = expDate;
    }

    /**
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the creditCardNum
     */
    public String getCreditCardNum() {
        return creditCardNum;
    }

    /**
     * @param creditCardNum the creditCardNum to set
     */
    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    private static final long serialVersionUID = 0L;
}
