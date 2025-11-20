package repository.impl;

import db.DBConnection;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void addCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public void updateCustomer() {

    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        return preparedStatement.executeQuery();
    }
}
