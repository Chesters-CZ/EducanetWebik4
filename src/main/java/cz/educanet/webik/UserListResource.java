package cz.educanet.webik;

import org.graalvm.compiler.lir.LIRInstruction;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("userlist") // <-- localhost:8080/[nazevAppky]/api/payment-method
@Produces(MediaType.APPLICATION_JSON) // <--  nastavuji jak chci komunikovat
public class UserListResource {
    public Uzivatel[] userlist;

    public Uzivatel createuzivatel(String jmeno, String heslo, int identifikator) {
        Uzivatel uzivatel = new Uzivatel();
        uzivatel.username = jmeno;
        uzivatel.password = heslo;
        uzivatel.id = identifikator;

        return uzivatel;
    }

    @PUT
    public Response adduzivateltouserlist(
            @QueryParam("username") String nazev,
            @QueryParam("password") String pass,
            @DefaultValue("-2147483648") @QueryParam("id") int ajdy,
            @DefaultValue("-2147483648") @QueryParam("pos") int posinarray
    ) {
        if (userlist[posinarray] != null || nazev == null || pass == null || ajdy == -2147483648 || posinarray == -2147483648) return Response.status(400).build();

        userlist[posinarray] = createuzivatel(nazev, pass, ajdy);
        return Response.ok().build();
    }

    @GET
    public Response getuserlist(@DefaultValue("-2147483648") @QueryParam("pos") int whichone) {
        if (whichone != -2147483648) return Response.ok(userlist[whichone]).build();
        return Response.ok(userlist).build();
    }

    @DELETE
    public Response removefromlist(int whichone) {
        userlist[whichone] = null;
        return Response.ok().build();
    }
}
