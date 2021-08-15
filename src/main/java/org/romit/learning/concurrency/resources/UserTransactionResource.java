package org.romit.learning.concurrency.resources;

import org.romit.learning.concurrency.runnables.UserTransactionProcessor;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("user-transaction")
public class UserTransactionResource {

    @Resource(lookup = "java:*")
    ManagedExecutorService managedExecutorService;

    @POST
    public String performUserAccountTransaction() throws NamingException {
        managedExecutorService.execute(new UserTransactionProcessor());
        return "User transaction is submited for processing. please check console for result";
    }
}
