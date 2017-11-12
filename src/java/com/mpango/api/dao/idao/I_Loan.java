/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.dao.idao;

import com.mpango.api.bus.LoanDTO;
import com.mpango.api.business.LoanApplication;
import com.mpango.api.business.LoanType;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jmulutu
 */
public interface I_Loan {
    
    List getLoanStatement(String loanRef, Connection con);
    
    List<LoanType> getAllLoanProducts(Connection con);
    
    List<LoanDTO> getAllLoans(Connection con);

    LoanDTO getLoanByID(int loanID, Connection con);

    LoanDTO getLoanByRef(String loanRef, Connection con);
    
    int loanApplication ( LoanApplication loanapplication, Connection con );   
    
}
