package cz.educanet.webik;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("payment-method") // <-- localhost:8080/[nazevAppky]/api/payment-method
@Produces(MediaType.APPLICATION_JSON) // <--  nastavuji jak chci komunikovat
public class PaymentMethodResource {

    private static int counter = 69;

    @GET
    public Response getAllPayments() { // [GET] localhost:8080/[nazevAppky]/api/payment-method
        return Response.ok(String.valueOf(counter)).build();
    }

    @PUT
    public Response increment() { // [GET] localhost:8080/[nazevAppky]/api/payment-method
        counter++;
        return Response.ok().build();
    }

    @DELETE
    public Response decrement() { // [GET] localhost:8080/[nazevAppky]/api/payment-method
        counter--;
        return Response.ok().build();
    }
}
