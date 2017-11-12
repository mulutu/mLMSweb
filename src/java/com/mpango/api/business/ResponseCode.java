/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mpango.api.business;

/**
 *
 * @author jmulutu
 */
public class ResponseCode {
    private String responseCode;
    private String Response;
    
    public ResponseCode(){}

    /**
     * @return the responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @return the ResponseCode
     */
    public String getResponse() {
        return Response;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @param Response the ResponseCode to set
     */
    public void setResponse(String Response) {
        this.Response = Response;
    }
    
    
    
}
