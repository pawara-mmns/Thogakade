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
    public void deleteCustomer(String custID) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "DELETE FROM customer WHERE CustID = ?";
            PreparedStatement psTm = connection.prepareStatement(SQL);
            psTm.setObject(1,custID);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String SQL = "UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";
            PreparedStatement psTm = connection.prepareStatement(SQL);

            psTm.setObject(1,custTitle);
            psTm.setObject(2,custName);
            psTm.setObject(3,dob);
            psTm.setObject(4,salary);
            psTm.setObject(5,custAddress);
            psTm.setObject(6,city);
            psTm.setObject(7,province);
            psTm.setObject(8,postalCode);
            psTm.setObject(9,custID);

            psTm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        return preparedStatement.executeQuery();
    }

    @Override
    public ResultSet searchCustomer(String custID, String custName) throws SQLException {
        String SQL = "SELECT * FROM customer WHERE CustID = ? OR CustName = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setObject(1,custID);
        preparedStatement.setObject(2,custName);
        return preparedStatement.executeQuery();

    }
}
