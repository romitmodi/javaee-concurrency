package org.romit.learning.concurrency.runnables;

import org.romit.learning.concurrency.beans.UserTransactionBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class UserTransactionProcessor implements Runnable {
    private UserTransactionBean userTransactionBean;
    private UserTransaction userTransaction;

    public UserTransactionProcessor() throws NamingException {
        InitialContext initialContext = new InitialContext();
        userTransaction = (UserTransaction) initialContext.lookup("java:comp/UserTransation");
        userTransactionBean = (UserTransactionBean) initialContext.lookup("java:module/transactionBean");
    }

    @Override
    public void run() {
        try {
            userTransaction.begin();
            userTransactionBean.saveUserBankTransaction();
            userTransactionBean.saveUserBankTransactionLog();
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                userTransaction.rollback();
            } catch (SystemException ex) {
                ex.printStackTrace();
            }
        }
    }
}
