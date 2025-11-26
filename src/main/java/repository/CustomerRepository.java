package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {

    void addCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode);

    void deleteCustomer(String custID);

    void updateCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode);

    ResultSet getAllCustomers() throws SQLException;

    ResultSet searchCustomer(String custID, String custName) throws SQLException;
}
