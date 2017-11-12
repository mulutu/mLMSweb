/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.business;

import java.math.BigDecimal;

/**
 *
 * @author jmulutu
 */
public class LoanApplication {

    private int CustomerID;
    private String nationalID;
    private String TransactionRef;
    private String LoanRef; // unique
    private int LoanTypeID;
    private BigDecimal Amount;
    private int RepaymentDuration;

    public LoanApplication() {
    }

    public LoanApplication(int CustomerID, String nationalID, String TransactionRef, String LoanRef, int LoanTypeID, BigDecimal Amount, int RepaymentDuration) {
        this.CustomerID = CustomerID;
        this.nationalID = nationalID;
        this.TransactionRef = TransactionRef;
        this.LoanRef = LoanRef;
        this.Amount = Amount;
        this.LoanTypeID = LoanTypeID;
        this.RepaymentDuration = RepaymentDuration;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @return the nationalID
     */
    public String getNationalID() {
        return nationalID;
    }

    /**
     * @return the TransactionRef
     */
    public String getTransactionRef() {
        return TransactionRef;
    }

    /**
     * @return the LoanRef
     */
    public String getLoanRef() {
        return LoanRef;
    }

    /**
     * @return the LoanTypeID
     */
    public int getLoanTypeID() {
        return LoanTypeID;
    }

    /**
     * @return the Amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @return the RepaymentDuration
     */
    public int getRepaymentDuration() {
        return RepaymentDuration;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @param nationalID the nationalID to set
     */
    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    /**
     * @param TransactionRef the TransactionRef to set
     */
    public void setTransactionRef(String TransactionRef) {
        this.TransactionRef = TransactionRef;
    }

    /**
     * @param LoanRef the LoanRef to set
     */
    public void setLoanRef(String LoanRef) {
        this.LoanRef = LoanRef;
    }

    /**
     * @param LoanTypeID the LoanTypeID to set
     */
    public void setLoanTypeID(int LoanTypeID) {
        this.LoanTypeID = LoanTypeID;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    /**
     * @param RepaymentDuration the RepaymentDuration to set
     */
    public void setRepaymentDuration(int RepaymentDuration) {
        this.RepaymentDuration = RepaymentDuration;
    }
    
   

}
