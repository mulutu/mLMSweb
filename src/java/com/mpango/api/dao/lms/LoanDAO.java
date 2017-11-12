/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.dao.lms;

import com.mpango.api.bus.LoanBUS;
import com.mpango.api.bus.LoanDTO;
import com.mpango.api.business.LoanApplication;
import com.mpango.api.business.LoanType;
import com.mpango.api.dao.idao.I_Loan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jmulutu
 */
public class LoanDAO implements I_Loan {
    
    @Override
    public List getLoanStatement(String loanRef, Connection con){
        List loanstatement = new ArrayList<>();
        
        String SQL = "SELECT * FROM loan_emi_receive e, loan_repayments r WHERE e.loan_ref='" + loanRef + "' AND e.loan_ref = r.loan_ref AND e.INSTALLMENT_NO=r.INSTALLMENT_NO" ;

        Statement st;
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            //loanstatement.add(rs);
            while (rs.next()) {
                loanstatement.add(rs.getInt("EMI_ID"));
                loanstatement.add(rs.getInt("CUSTOMER_ID"));
                loanstatement.add(rs.getInt("INSTALLMENT_NO"));
                loanstatement.add(rs.getString("LOAN_REF"));
                loanstatement.add(rs.getBigDecimal("EMI_AMOUNT"));
                loanstatement.add(rs.getDate("RECEIPT_DATE"));
                loanstatement.add(rs.getBigDecimal("PENALTY"));
                loanstatement.add(rs.getBigDecimal("OUTSTANDING_AMOUNT"));
                loanstatement.add(rs.getBigDecimal("TOTAL_RECEIVABLE"));
                loanstatement.add(rs.getBigDecimal("AMOUNT_RECEIVED"));
                loanstatement.add(rs.getString("TRX_REF_NUMBER"));
                loanstatement.add(rs.getBigDecimal("AMOUNT"));
                loanstatement.add(rs.getDate("PAYMENT_DATE"));
                loanstatement.add(rs.getString("STATUS"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return loanstatement;
    }
    
    @Override
    public List<LoanType> getAllLoanProducts(Connection con) {
        List<LoanType> loanproducts = new ArrayList<>();

        String SQL = "select * from loan_types";

        Statement st;
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                LoanType loantype = new LoanType();
                
                loantype.setLoanTypeID(rs.getInt("LOAN_TYPE_ID"));
                loantype.setLoanTypeCode(rs.getString("LOAN_TYPE_CODE"));
                loantype.setLoanTypeDesc(rs.getString("LOAN_TYPE_DESC"));
                loantype.setActive(rs.getInt("ACTIVE"));
                loantype.setDateAdded(rs.getDate("DATE_ADDED"));

                loanproducts.add(loantype);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loanproducts;
    }

    @Override
    public List<LoanDTO> getAllLoans(Connection con) {
        List<LoanDTO> loans = new ArrayList<>();

        String SQL = "select * from loan_disbursements";

        Statement st;
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                LoanDTO loan = LoanBUS.getLoanByRef(rs.getString("LOAN_REF"), con);
                loans.add(loan);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loans;
    }

    @Override
    public LoanDTO getLoanByID(int loanID, Connection con) {
        LoanDTO loan = new LoanDTO();

        String SQL = "select * from loan_disbursements where ID = " + loanID + "";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                loan.setLoanID(rs.getInt("ID"));
                loan.setLoanRef(rs.getString("LOAN_REF"));
                loan.setDateDisbursed(rs.getDate("DATE_DISBURSED"));
                loan.setDueDate(rs.getDate("DUE_DATE"));
                loan.setAmount(rs.getBigDecimal("PRINCIPAL_AMOUNT"));
                loan.setLoanTerm(rs.getInt("LOAN_TERM"));
                loan.setLoanBalance(rs.getBigDecimal("LOAN_BALANCE"));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loan;
    }

    @Override
    public LoanDTO getLoanByRef(String loanRef, Connection con) {
        LoanDTO loan = new LoanDTO();
        String SQL = "SELECT * "
                + "FROM loan_disbursements ld, loan_applications la, customers c, interest_rates ir, loan_types lt, loan_emi_receive emi "
                + "WHERE ld.LOAN_REF = '" + loanRef + "' "
                + "AND ld.LOAN_REF=la.LOAN_REF "
                + "AND la.loan_type_id = ir.loan_type_id "
                + "AND c.customer_id = la.customer_id "
                + "AND ld.LOAN_REF = emi.loan_ref "
                + "AND emi.SCHEDULE = 'CURRENT' "
                + "AND ir.rate=ld.interest_rate AND lt.loan_type_id=la.loan_type_id";
        Statement st;

        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                loan.setLoanID(rs.getInt("ID"));
                loan.setAmount(rs.getBigDecimal("TOTAL_LOAN_AMOUNT"));
                loan.setLoanTerm(rs.getInt("LOAN_TERM"));
                loan.setLoanRef(rs.getString("LOAN_REF"));
                loan.setDateDisbursed(rs.getDate("DATE_DISBURSED"));
                loan.setDueDate(rs.getDate("DUE_DATE"));
                loan.setCustomerID(rs.getInt("CUSTOMER_ID"));
                loan.setCustomerMSISDN(rs.getString("MSISDN"));
                loan.setLoanTerm(rs.getInt("DURATION"));
                loan.setLoanTerms(rs.getInt("LOAN_TERM"));
                loan.setLoanBalance(rs.getBigDecimal("LOAN_BALANCE"));
                loan.setTotalRepayments(rs.getBigDecimal("TOTAL_REPAYMENTS"));
                loan.setInterestRate(rs.getBigDecimal("INTEREST_RATE"));
                loan.setInterestRateType(rs.getString("RATE_TYPE"));
                loan.setLoanType(rs.getString("LOAN_TYPE_DESC"));
                loan.setLoanTypeID(rs.getInt("LOAN_TYPE_ID"));
                loan.setPrincipal(rs.getBigDecimal("PRINCIPAL_AMOUNT"));
                loan.setTrxRefNumber(rs.getString("TRX_REF_NUMBER"));
                loan.setCurrentEMIID(rs.getInt("EMI_ID"));
                loan.setEmiAmount(rs.getBigDecimal("EMI_AMOUNT"));
                loan.setEmiDueDate(rs.getDate("EMI_DATE"));
                loan.setEmiOutstandingAmount(rs.getBigDecimal("OUTSTANDING_AMOUNT"));
                loan.setEmiPenalty(rs.getBigDecimal("PENALTY"));
                loan.setEmiSchedule(rs.getString("SCHEDULE"));
                loan.setEmiTotalReceivable(rs.getBigDecimal("TOTAL_RECEIVABLE"));
                loan.setTotalPenalties(rs.getBigDecimal("TOTAL_PENALTIES"));
                loan.setEmiAmountReceived(rs.getBigDecimal("AMOUNT_RECEIVED"));
                loan.setCurrentEMIInstallmentNumber(rs.getInt("INSTALLMENT_NO"));
                loan.setStatus(rs.getString("ld.STATUS"));
                loan.setRequestDate(rs.getDate("la.REQUEST_DATE"));

            } else {
                loan = null;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    @Override
    public int loanApplication(LoanApplication loanapplication, Connection con) {
        //LoanDTO loan = null;
        int result = 0;

        String SQL = "INSERT INTO `loan_applications`( `CUSTOMER_ID`, `TRX_REF_NUMBER`, `LOAN_REF`, `LOAN_TYPE_ID`, `AMOUNT`, `DURATION`, `REQUEST_DATE` ) "
                + "VALUES ( "
                + "" + loanapplication.getCustomerID() + ","
                + "'" + loanapplication.getTransactionRef() + "',"
                + "'" + loanapplication.getLoanRef() + "',"
                + "" + loanapplication.getLoanTypeID() + ","
                + "" + loanapplication.getAmount() + ","
                + "" + loanapplication.getRepaymentDuration() + ","
                + "NOW() "
                + ")";

        Statement st;
        try {
            //st = con.createStatement();
            st = con.prepareStatement(SQL);
            int rowsUpdated = st.executeUpdate(SQL);
            if (rowsUpdated > 0) {
                //loan = this.getLoanByRef(loanapplication.getLoanRef(), con);
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
