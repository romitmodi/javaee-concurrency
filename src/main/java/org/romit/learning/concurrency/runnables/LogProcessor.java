package org.romit.learning.concurrency.runnables;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogProcessor implements Runnable {

    @Override
    public void run() {
        Logger.getLogger(LogProcessor.class.getName()).log(Level.INFO, "Logging Data from loggingresource");
        System.out.println(Thread.currentThread().getName());
    }
}
