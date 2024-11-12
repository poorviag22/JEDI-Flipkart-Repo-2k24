package com.flipfit.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

import com.flipfit.bean.*;
import com.flipfit.business.*;


@Path("/admin-menu")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitAdminRestController {
    GymAdminBusiness service = new GymAdminBusinessImpl();
    GymUserBusiness userService = new GymUserBusinessImpl();

    /**
     *
     * @return the list of all the bookings
     */
    @GET
    @Path("/viewbookings")
    public List<GymBooking> viewBookings() {

        return service.viewBookings();
    }

    /**
     *
     * @return the list of all the customers
     */
    @GET
    @Path("/viewcustomers")
    public List<GymCustomer> viewCustomer() {
        return userService.viewAllCustomers();

    }

    /**
     *
     * @return the list of all the owners
     */
    @GET
    @Path("/viewowners")
    public List<GymOwner> viewOwner() {
        return userService.viewAllGymOwners();
    }

    /**
     *
     * @return the list of all the pending requests
     */
    @GET
    @Path("/viewpendingrequests")
    public List<GymOwnerRequest> viewPendingRequests() {
        return service.pendingRequests();
    }

    /**
     *
     * @param requestId
     * @param statuss
     * @return
     * updates the request status
     */
    @PUT
    @Path("/{requestId}/updateOwnerRequest")
    public String aprroveOwnerRequest(@PathParam("requestId") Integer requestId, String statuss) {
        service.approveOwnerRegistration(requestId, statuss);
        return "Approved";
    }

}