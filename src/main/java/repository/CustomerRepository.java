package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {

    void addCustomer();

    void deleteCustomer();

    void updateCustomer();

    ResultSet getAllCustomers() throws SQLException;
}
