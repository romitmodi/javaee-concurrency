package org.romit.learning.concurrency.runnables;

import javax.security.auth.Subject;
import java.security.AccessController;

public class ContextServiceRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running contextServiceRunnable via normal runnable");
        Subject subject = Subject.getSubject(AccessController.getContext());
        subject.getPrincipals();
        System.out.println("subject information is: " + subject);
    }
}
