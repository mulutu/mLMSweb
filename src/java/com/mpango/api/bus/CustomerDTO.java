/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.bus;

import java.math.BigDecimal;

/**
 *
 * @author jmulutu
 */
public class CustomerDTO {
    private  int CustomerID;
    private  String firstName;
    private  String middleName;
    private  String surname;
    private  String nationalID;
    private  String msisdn;
    private  String gender;
    private  int CRBStatus;
    private BigDecimal loanLimit;
    
    /* company details */
    private int CompanyID;
    private String CompanyName;

    public CustomerDTO() {}
    
    /*CustomerID = 0;
        firstName = "";
        middleName = "";
        surname = "";
        nationalID = "";
        msisdn = "";
        gender = "";
        CRBStatus = 0;
        loanLimit = null;
    }*/

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
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
     * @return the nationalID
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the CRBStatus
     */
    public int getCRBStatus() {
        return CRBStatus;
    }

    /**
     * @return the loanLimit
     */
    public BigDecimal getLoanLimit() {
        return loanLimit;
    }

    /**
     * @return the CompanyID
     */
    public int getCompanyID() {
        return CompanyID;
    }

    /**
     * @return the CompanyName
     */
    public String getCompanyName() {
        return CompanyName;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
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
     * @param nationalID the nationalID to set
     */
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @param CRBStatus the CRBStatus to set
     */
    public void setCRBStatus(int CRBStatus) {
        this.CRBStatus = CRBStatus;
    }

    /**
     * @param loanLimit the loanLimit to set
     */
    public void setLoanLimit(BigDecimal loanLimit) {
        this.loanLimit = loanLimit;
    }

    /**
     * @param CompanyID the CompanyID to set
     */
    public void setCompanyID(int CompanyID) {
        this.CompanyID = CompanyID;
    }

    /**
     * @param CompanyName the CompanyName to set
     */
    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    
}
