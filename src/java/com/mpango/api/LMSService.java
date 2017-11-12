package com.mpango.api;

import com.mpango.api.bus.LoanDTO;
import com.mpango.api.business.LoanApplication;
import com.mpango.api.business.Login;
import com.mpango.api.customer.Customer;
import com.mpango.api.loan.Loan;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
//@Path("/mlmsweb")
@Path("/mlmsweb/")
//@Produces({"application/xml", "application/json"})
@Produces("application/json")
public interface LMSService {
    
    @GET
    @Path("/customers/")
    public Response getAllCustomers(); 
    
    /*@GET
    @Path("/customer/details/{id}")
    public Response getCustomerByNatID( @PathParam("id") String msg );
    
    @GET
    @Path("/customer/loans/{id}")
    public Response getCustomerLoans( @PathParam("id") String msg ); */
    
    @POST
    @Path("/createcustomer")
    //@Consumes("{\"application/xml\", \"application/json\"}")
    public Response createCustomer(Customer customer);
    
    /*@GET
    @Path("/login/username/{username}/password/{password}")
    public Response login( @PathParam("username") String username, @PathParam("password") String password ); */
    
    @POST
    @Path("/login")
    public Response login( Login login );

    @GET
    @Path("/loan/id/{id}")
    public LoanDTO getLoanByID(@PathParam("id") String msg);
    
    @GET
    @Path("/loan/ref/{id}")
    public Response getLoanByRef(@PathParam("id") String msg);
    
    @GET
    @Path("/loanstatement/ref/{id}")
    public Response getLoanStatement(@PathParam("id") String msg);
    
    @GET
    @Path("/loans/")
    public Response getAllLoans(); 
    
    @GET
    @Path("/loanproducts/")
    public Response getAllLoanProducts(); 

    @PUT
    @Path("/loan/")
    public Response updateLoan(Loan loan);

    @POST
    @Path("/loanapplication/")
    public Response loanApplication(LoanApplication loan);

    @DELETE
    @Path("/loan/{id}")
    public Response deleteLoan(@PathParam("id") String msg);

}
