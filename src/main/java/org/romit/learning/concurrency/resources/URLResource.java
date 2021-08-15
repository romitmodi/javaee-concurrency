package org.romit.learning.concurrency.resources;

import org.romit.learning.concurrency.runnables.URLHealthProcessor;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.TimeUnit;

@Path("healthCheck")
public class URLResource {
    @Resource(lookup = "")
    ManagedScheduledExecutorService managedScheduledExecutorService;

    @GET
    public void checkHealth() {
        String message = "";
        managedScheduledExecutorService.schedule(new URLHealthProcessor(), 3, TimeUnit.SECONDS);
        message = "Health check of application is scheduled";
    }
}
