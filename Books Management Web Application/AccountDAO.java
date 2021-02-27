package com.ICS2609JSPCRUDample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public AccountDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public List<Account> listAllAccounts() throws SQLException {
    	//arraylist of records from the database
        List<Account> listAccount = new ArrayList<>();
         
        String sql = "SELECT * FROM tblaccounts ORDER BY username";
         
        connect();
        //creating the statement on the connection
        Statement statement = jdbcConnection.createStatement();
        //resultset contains the records retrieve on executing the sql
        ResultSet resultSet = statement.executeQuery(sql);
         //looping all the records on the result set
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String usertype = resultSet.getString("usertype");
            String status = resultSet.getString("status");
             
            Account account = new Account(id, username, password, usertype, status);
            listAccount.add(account);
        }
         
        resultSet.close();
        statement.close();
        disconnect();
        return listAccount;
    }
}
