/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.bus;

import com.mpango.api.business.LoanApplication;
import com.mpango.api.business.LoanType;
import com.mpango.api.dao.factory.DAOFactory;
import com.mpango.api.dao.idao.I_Loan;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jmulutu
 */
public class LoanBUS {
    
    public static List getLoanStatement(String loanRef, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.getLoanStatement(loanRef, con);
    }
    
    public static List<LoanType> getAllLoanProducts(Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.getAllLoanProducts(con);
    }
    
    public static List<LoanDTO> getAllLoans(Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.getAllLoans(con);
    }

    public static LoanDTO getLoanByID(int loanID, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.getLoanByID(loanID, con);
    }

    public static LoanDTO getLoanByRef(String loanRef, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.getLoanByRef(loanRef, con);
    }

    public static int loanApplication(LoanApplication loanapplication, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Loan myLoan = factory.get_Loan();
        return myLoan.loanApplication(loanapplication, con);
    }
}
