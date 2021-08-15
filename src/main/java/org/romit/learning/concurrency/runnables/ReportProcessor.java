package org.romit.learning.concurrency.runnables;

import org.romit.learning.concurrency.dao.BankAccountDao;
import org.romit.learning.concurrency.entity.BankAccount;
import org.romit.learning.concurrency.entity.BankAccountTransaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class ReportProcessor implements Callable<Boolean> {

    private BankAccount bankAccount;
    private BankAccountDao bankAccountDao;

    public ReportProcessor(BankAccount bankAccount, BankAccountDao bankAccountDao) {
        this.bankAccount = bankAccount;
        this.bankAccountDao = bankAccountDao;
    }

    @Override
    public Boolean call() throws Exception {
        List<BankAccountTransaction> transactions = bankAccountDao.getBankAccountTransaction(bankAccount);
        File file = new File("");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("Header");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            transactions.forEach(bankAccountTransaction -> {
                try {
                    bufferedWriter.write("Header");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return true;
    }

}