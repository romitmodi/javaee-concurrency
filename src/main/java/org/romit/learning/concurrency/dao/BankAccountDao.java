package org.romit.learning.concurrency.dao;

import org.romit.learning.concurrency.entity.BankAccount;
import org.romit.learning.concurrency.entity.BankAccountTransaction;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDao {

    private DataSource dataSource;

    public BankAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<BankAccount> getAllBankAccount() {
        return new ArrayList<>();
    }

    public List<BankAccountTransaction> getBankAccountTransaction(BankAccount bankAccount) {
        return new ArrayList<>();
    }
}
