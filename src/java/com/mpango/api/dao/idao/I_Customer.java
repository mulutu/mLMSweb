/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.dao.idao;

import com.mpango.api.bus.CustomerDTO;
import com.mpango.api.customer.Customer;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jmulutu
 */
public interface I_Customer {
    
    public int hasExistingLoan(String IDNumber, Connection con);
    
    public int createCustomer( Customer customer, Connection con);
    
    public List<CustomerDTO> getAllCustomers(Connection con);

    public CustomerDTO CustomerLogin(String MSISDN, String password, Connection con);

    public CustomerDTO getCustomerByID(String IDNumber, Connection con);

    public CustomerDTO getCustomerByMSISDN(String MSISDN, Connection con);
    
    public int hasExistingLoanApplication(String IDNumber, Connection con);
    
}
