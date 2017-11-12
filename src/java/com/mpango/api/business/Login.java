/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.business;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmulutu
 */
@XmlRootElement(name="Loan")
public class Login  implements Serializable{
    
    private String username;
    private String password;
    private String accessToken;
    private String userRole;
    
    public Login(){}

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param accessToken the accessToken to set
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

  
    
}
