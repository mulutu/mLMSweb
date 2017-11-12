/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.dao.lms;

import com.mpango.api.bus.CustomerBUS;
import com.mpango.api.bus.CustomerDTO;
import com.mpango.api.bus.LoanBUS;
import com.mpango.api.bus.LoanDTO;
import com.mpango.api.customer.Customer;
import com.mpango.api.dao.idao.I_Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmulutu
 */
public class CustomerDAO implements I_Customer {

    @Override
    public int hasExistingLoanApplication(String IDNumber, Connection con) {
        int status = 0;
        String SQL = "  SELECT * \n"
                + "FROM loan_applications as la, customers as c \n"
                + "WHERE  c.customer_id = la.customer_id \n"
                + "AND c.id_number = '" + IDNumber + "' "
                + "AND la.STATUS='PENDING'";
        Statement st;
        System.out.println("hasExistingLoanApplication:  " + SQL);
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            if (!rs.isBeforeFirst()) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int hasExistingLoan(String IDNumber, Connection con) {
        int status = 0;
        String SQL = "  SELECT * \n"
                + "FROM loan_disbursements as d, customers as c \n"
                + "WHERE  c.customer_id = d.customer_id \n"
                + "AND c.id_number = '" + IDNumber + "' "
                + "AND d.STATUS='ACTIVE'";
        Statement st;
        System.out.println("hasExistingLoan:  " + SQL);
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            if (!rs.isBeforeFirst()) {
                status = 0;
            } else {
                status = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public int createCustomer(Customer customer, Connection con) {
        int result = 0;

        String SQL = "INSERT INTO customers(`ID_NUMBER`, `MSISDN`, `FIRST_NAME`, `MIDDLE_NAME`, `SURNAME`,`LOAN_LIMIT`) "
                + " VALUES('" + customer.getCustomerIDNumber() + "', '" + customer.getMsisdn() + "', '" + customer.getFirstName()
                + "','" + customer.getMiddleName() + "','" + customer.getSurname() + "'," + customer.getLoanLimit() + ")";

        Statement st;
        try {
            st = con.prepareStatement(SQL);
            int rowsUpdated = st.executeUpdate(SQL);
            if (rowsUpdated > 0) {
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<CustomerDTO> getAllCustomers(Connection con) {
        List<CustomerDTO> customers = new ArrayList<>();
        String SQL = "SELECT * FROM customers";
        Statement st;
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                CustomerDTO customer = CustomerBUS.getCustomerByID(rs.getString("ID_NUMBER"), con);
                customers.add(customer);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public CustomerDTO getCustomerByID(String IDNumber, Connection con) {
        CustomerDTO customer = new CustomerDTO();

        String SQL = "SELECT * FROM customers cu, company co WHERE cu.company_id = co.company_id AND cu.ID_NUMBER = '" + IDNumber + "'";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                customer.setNationalID(rs.getString("ID_NUMBER"));
                customer.setCRBStatus(0);
                customer.setCustomerID(rs.getInt("CUSTOMER_ID"));
                customer.setFirstName(rs.getString("FIRST_NAME"));
                customer.setMiddleName(rs.getString("MIDDLE_NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setMsisdn(rs.getString("MSISDN"));
                customer.setLoanLimit(rs.getBigDecimal("LOAN_LIMIT"));
                customer.setCompanyID(rs.getInt("COMPANY_ID"));
                customer.setCompanyName(rs.getString("COMPANY_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public CustomerDTO getCustomerByMSISDN(String MSISDN, Connection con) {
        CustomerDTO customer = new CustomerDTO();

        String SQL = "select * from customers where MSISDN = '" + MSISDN + "'";
        Statement st;
        try {
            st = con.prepareStatement(SQL);
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                customer.setNationalID(rs.getString("ID_NUMBER"));
                customer.setCRBStatus(0);
                customer.setCustomerID(rs.getInt("CUSTOMER_ID"));
                customer.setFirstName(rs.getString("FIRST_NAME"));
                customer.setMiddleName(rs.getString("MIDDLE_NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setMsisdn(rs.getString("MSISDN"));
                customer.setLoanLimit(rs.getBigDecimal("LOAN_LIMIT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public CustomerDTO CustomerLogin(String MSISDN, String password, Connection con) {
        CustomerDTO customer = new CustomerDTO();

        String SQL = "select * from customers where MSISDN = '" + MSISDN + "' AND password = '" + password + "'";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                customer.setNationalID(rs.getString("ID_NUMBER"));
                customer.setCRBStatus(0);
                customer.setCustomerID(rs.getInt("CUSTOMER_ID"));
                customer.setFirstName(rs.getString("FIRST_NAME"));
                customer.setMiddleName(rs.getString("MIDDLE_NAME"));
                customer.setSurname(rs.getString("SURNAME"));
                customer.setMsisdn(rs.getString("MSISDN"));
                customer.setLoanLimit(rs.getBigDecimal("LOAN_LIMIT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

}
