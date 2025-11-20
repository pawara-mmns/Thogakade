package repository.impl;

import db.DBConnection;
import repository.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public void addCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, custID);
            preparedStatement.setObject(2, custTitle);
            preparedStatement.setObject(3, custName);
            preparedStatement.setObject(4, dob);
            preparedStatement.setObject(5, salary);
            preparedStatement.setObject(6, custAddress);
            preparedStatement.setObject(7, city);
            preparedStatement.setObject(8, province);
            preparedStatement.setObject(9, postalCode);

            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

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
