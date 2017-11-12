/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.loan;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmulutu
 */
@XmlRootElement(name="Loan")
public class Loan {
    
    private Long loanId;
    private BigDecimal loanAmount;
    private Date dueDate;
    private int CustomerID;
    private int LoanTypeID;
    private int loanTerm;
    
    public Loan(){
    }    

    /**
     * @return the loanId
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * @return the loanAmount
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @return the CustomerID
     */
    public int getCustomerID() {
        return CustomerID;
    }

    /**
     * @return the LoanTypeID
     */
    public int getLoanTypeID() {
        return LoanTypeID;
    }

    /**
     * @return the loanTerm
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param loanId the loanId to set
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @param CustomerID the CustomerID to set
     */
    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    /**
     * @param LoanTypeID the LoanTypeID to set
     */
    public void setLoanTypeID(int LoanTypeID) {
        this.LoanTypeID = LoanTypeID;
    }

    /**
     * @param loanTerm the loanTerm to set
     */
    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    
}
