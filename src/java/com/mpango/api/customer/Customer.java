/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.customer;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmulutu
 */
@XmlRootElement(name="Customer")
public class Customer {
    private int CustomerID;
    private String customerIDNumber;
    private String msisdn;
    private String firstName;
    private String middleName;
    private String surname;
    private String email;
    private BigDecimal loanLimit;
    
    public Customer(){}

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @return the customerIDNumber
     */
    public String getCustomerIDNumber() {
        return customerIDNumber;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the loanLimit
     */
    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @param customerIDNumber the customerIDNumber to set
     */
    public void setCustomerIDNumber(String customerIDNumber) {
        this.customerIDNumber = customerIDNumber;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param loanLimit the loanLimit to set
     */
    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

   
    
}
