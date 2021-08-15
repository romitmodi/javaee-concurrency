package org.romit.learning.concurrency.resources;

import org.romit.learning.concurrency.runnables.LogProcessor;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Path("logging")
public class LoggingResource {

    @Resource(lookup = "")
    private ManagedThreadFactory threadFactory;

    @GET
    public void logData() {
        Thread thread = threadFactory.newThread(new LogProcessor());
        thread.setName("Logging Thread");
        thread.start();
        ExecutorService service = getApplicationPool();
        for (int i = 0; i < 10; i++) {
            service.submit(new LogProcessor());
        }
    }

    public ExecutorService getApplicationPool() {
        ExecutorService service = new ThreadPoolExecutor(3, 20, 7,
                TimeUnit.SECONDS, new ArrayBlockingQueue(2), threadFactory);
        return service;
    }
}
