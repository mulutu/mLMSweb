/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api;

import com.mpango.api.bus.CustomerBUS;
import com.mpango.api.bus.CustomerDTO;
import com.mpango.api.bus.LoanBUS;
import com.mpango.api.bus.LoanDTO;
import com.mpango.api.business.LoanApplication;
import com.mpango.api.business.Login;
import com.mpango.api.business.ResponseCode;
import com.mpango.api.customer.Customer;
import com.mpango.api.dao.lms.DataProvider;
import com.mpango.api.loan.Loan;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author jmulutu
 */
public class LMSServiceImpl implements LMSService {

    private long currentLoanId = 123;
    Map<Long, LoanDTO> loans;
    //private Loan loan;

    public LMSServiceImpl() {
        this.loans = new HashMap<Long, LoanDTO>();
    }

    @Override
    public Response getAllCustomers() {
        Connection con = DataProvider.getConnection();
        List customers = CustomerBUS.getAllCustomers(con);
        return Response.ok(customers).build();
    }

    @Override
    public Response createCustomer(Customer customer) {
        Connection con = DataProvider.getConnection();

        ResponseCode response = new ResponseCode();

        int createCustResult = CustomerBUS.createCustomer(customer, con);

        if (createCustResult == 1) {
            response.setResponseCode("00");
            response.setResponse("Customer Created");
        } else {
            response.setResponseCode("12");
            response.setResponse("Customer Creation failed");
        }
        return Response.ok(response).build();
    }

    @Override
    public Response login(Login logindetails) {
        String username = logindetails.getUsername();
        String password = logindetails.getPassword();
        Login loginResponse = new Login();
        
        System.out.println( username + " username::password " + password );

        if (username.equals("admin") && password.equals("admin")) {
            loginResponse.setAccessToken("accessTokenfor" + username);
            loginResponse.setUserRole(username);
            loginResponse.setPassword(password);
            loginResponse.setUsername(username);
        } else if (username.equalsIgnoreCase("editor")) {

        } else if (username.equalsIgnoreCase("guest")) {

        }
        return Response.ok(loginResponse).build();
    }

    @Override
    public LoanDTO getLoanByID(@PathParam("param") String msg) {
        Connection con = DataProvider.getConnection();
        int loanID = Integer.parseInt(msg, 32);
        LoanDTO loan = LoanBUS.getLoanByID(loanID, con);
        return loan;
    }

    @Override
    public Response getLoanByRef(@PathParam("param") String msg) {
        Connection con = DataProvider.getConnection();
        String loanRef = msg.trim();
        //String result = "";
        LoanDTO result = null;
        LoanDTO loan = LoanBUS.getLoanByRef(loanRef, con);
        if (loan != null) {
            result = loan;
            //result = JsonGenerator.generateJson(loan);
        }
        return Response.ok(result).build();
    }
    
    @Override
    public Response getLoanStatement(@PathParam("param") String msg) {
        Connection con = DataProvider.getConnection();
        String loanRef = msg.trim();
        List result = null;
        List loanstatement = LoanBUS.getLoanStatement(loanRef, con);
        if (loanstatement != null) {
            result = loanstatement;
        }
        return Response.ok(result).build();
    }

    @Override
    public Response getAllLoans() {
        Connection con = DataProvider.getConnection();
        List loans = LoanBUS.getAllLoans(con);
        return Response.ok(loans).build();
    }

    @Override
    public Response getAllLoanProducts() {
        Connection con = DataProvider.getConnection();
        List loanproducts = LoanBUS.getAllLoanProducts(con);
        return Response.ok(loanproducts).build();
    }

    @Override
    public Response updateLoan(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response loanApplication(LoanApplication loanapplication) {
        Connection con = DataProvider.getConnection();
        IdGenerator randomGen = new IdGenerator();
        ResponseCode response = new ResponseCode();

        /* Check if customer has an existing loan  */
        int hasExistingLoanApplication = CustomerBUS.hasExistingLoanApplication(loanapplication.getNationalID(), con);

        if (hasExistingLoanApplication == 1) {
            response.setResponseCode("12");
            response.setResponse("customer has existing loan application");
        } else {
            /* Check if customer has an existing loan */
            int hasExistingLoan = CustomerBUS.hasExistingLoan(loanapplication.getNationalID(), con);

            if (hasExistingLoan == 1) {
                response.setResponseCode("14");
                response.setResponse("customer has existing loan");
            } else {
                CustomerDTO customer = CustomerBUS.getCustomerByID(loanapplication.getNationalID(), con);

                String transactionRef = "LR" + randomGen.generateId(5);
                String loanRef = "LN" + randomGen.generateId(5);

                loanapplication.setLoanRef(loanRef);
                loanapplication.setTransactionRef(transactionRef);
                loanapplication.setCustomerID(customer.getCustomerID());

                int loanAppResponse = LoanBUS.loanApplication(loanapplication, con);

                if (loanAppResponse == 1) {
                    response.setResponseCode("00");
                    response.setResponse("loan application successful");
                } else {
                    response.setResponseCode("12");
                    response.setResponse("loan application failed");
                }
            }
        }

        return Response.ok(response).build();
    }

    @Override
    public Response deleteLoan(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String formatAmount(BigDecimal loanAmount) {

        //loanAmount = loanAmount.multiply(new BigDecimal(100)); // make to cents
        //loanAmount = loanAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
        String formattedAmount = StringUtils.leftPad(loanAmount.toString(), 12, '0');

        return formattedAmount;
    }

}
