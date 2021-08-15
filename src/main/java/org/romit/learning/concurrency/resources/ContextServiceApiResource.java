package org.romit.learning.concurrency.resources;

import org.romit.learning.concurrency.runnables.ContextServiceRunnable;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("contextService")
public class ContextServiceApiResource {

    @Resource(lookup = "")
    private ContextService service;

    @GET
    public void accessSecurityInformation() {
        //Via this way, since we are using S£ way of creating thread, it's not guaranteed that contextual information will
        // be available for this thread.
        ContextServiceRunnable contextServiceRunnable = new ContextServiceRunnable();
        Thread thread = new Thread(contextServiceRunnable);
        thread.start();

        //via use of proxy using contextService, its guaranteed that contextual info will be available as we are
        //using ContextService Api whose implementation will be provided by J2EE product provider.
        Runnable runnable = service.createContextualProxy(contextServiceRunnable, Runnable.class);
        thread = new Thread(runnable);
        thread.start();
    }
}
