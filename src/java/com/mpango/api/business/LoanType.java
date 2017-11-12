/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.business;

import java.util.Date;

/**
 *
 * @author jmulutu
 */
public class LoanType {
    
    private int LoanTypeID;
    private String LoanTypeCode;
    private String LoanTypeDesc;
    private int active;
    private Date DateAdded;
    
    public LoanType(){
    }

    /**
     * @return the LoanTypeID
     */
    public int getLoanTypeID() {
        return LoanTypeID;
    }

    /**
     * @return the LoanTypeCode
     */
    public String getLoanTypeCode() {
        return LoanTypeCode;
    }

    /**
     * @return the LoanTypeDesc
     */
    public String getLoanTypeDesc() {
        return LoanTypeDesc;
    }

    /**
     * @return the active
     */
    public int getActive() {
        return active;
    }

    /**
     * @return the DateAdded
     */
    public Date getDateAdded() {
        return DateAdded;
    }

    /**
     * @param LoanTypeID the LoanTypeID to set
     */
    public void setLoanTypeID(int LoanTypeID) {
        this.LoanTypeID = LoanTypeID;
    }

    /**
     * @param LoanTypeCode the LoanTypeCode to set
     */
    public void setLoanTypeCode(String LoanTypeCode) {
        this.LoanTypeCode = LoanTypeCode;
    }

    /**
     * @param LoanTypeDesc the LoanTypeDesc to set
     */
    public void setLoanTypeDesc(String LoanTypeDesc) {
        this.LoanTypeDesc = LoanTypeDesc;
    }

    /**
     * @param active the active to set
     */
    public void setActive(int active) {
        this.active = active;
    }

    /**
     * @param DateAdded the DateAdded to set
     */
    public void setDateAdded(Date DateAdded) {
        this.DateAdded = DateAdded;
    }
    
}
