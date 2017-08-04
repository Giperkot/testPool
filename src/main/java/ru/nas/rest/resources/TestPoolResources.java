package ru.nas.rest.resources;

import ru.nas.ejb.TestPool;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by admin on 04.08.2017.
 */

@ApplicationScoped
@Path("private/testPool")
@Produces("application/json")
public class TestPoolResources {

    @EJB
    private TestPool pool;

    @GET
    public Response select(@QueryParam("id") UUID id) {
        return Response.ok().build();
    }
}
