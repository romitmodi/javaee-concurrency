package org.romit.learning.concurrency.resources;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.sql.ConnectionPoolDataSource;
import javax.ws.rs.Path;

@Path("reports")
public class ReportsResource {

    @Resource(lookup = "")
    ManagedExecutorService managedExecutorService;

    public ReportsResource() {
        ConnectionPoolDataSource poolDataSource = null;
    }
}
