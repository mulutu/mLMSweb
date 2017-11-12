/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mpango.api.bus;

import com.mpango.api.customer.Customer;
import com.mpango.api.dao.factory.DAOFactory;
import com.mpango.api.dao.idao.I_Customer;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jmulutu
 */
public class CustomerBUS {
    
    public static int hasExistingLoanApplication(String IDNumber, Connection con){
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.hasExistingLoanApplication(IDNumber, con);
    }
    
    public static int hasExistingLoan(String IDNumber, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.hasExistingLoan(IDNumber, con);
    }
    
    public static int createCustomer( Customer customer, Connection con){
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.createCustomer(customer, con);
    }
    
    public static List<CustomerDTO> getAllCustomers(Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.getAllCustomers(con);
    }

    public static CustomerDTO getCustomerByID(String IDNumber, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.getCustomerByID(IDNumber, con);
    }

    public static CustomerDTO getCustomerByMSISDN(String MSISDN, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.getCustomerByMSISDN(MSISDN, con);
    }

    public static CustomerDTO customerLogin(String MSISDN, String password, Connection con) {
        DAOFactory factory = DAOFactory.getInstances();
        I_Customer myCustomer = factory.get_Customer();
        return myCustomer.CustomerLogin(MSISDN, password, con);
    }

}
