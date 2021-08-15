package org.romit.learning.concurrency.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Stateless(name = "transactionBean")
public class UserTransactionBean {

    @Resource(lookup = "datasource1")
    DataSource dataSource1;

    @Resource(lookup = "datasource2")
    DataSource dataSource2;

    public void saveUserBankTransaction() throws SQLException {
        Connection connection = dataSource1.getConnection();
        PreparedStatement statement = connection.prepareStatement("");
        statement.execute();
    }

    public void saveUserBankTransactionLog() throws SQLException {
        Connection connection = dataSource1.getConnection();
        Statement statement = connection.prepareStatement("");
        statement.executeBatch();
    }
}
