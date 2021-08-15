package org.romit.learning.concurrency.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetUser")
public class GreetResource {

    @GET
    public String greetUser() {
        return "Hello User, Greeting from Rest API";
    }

}
