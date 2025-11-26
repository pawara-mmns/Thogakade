package service.impl;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void addCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {

            customerRepository.addCustomer(custID, custTitle, custName, dob, salary, custAddress, city, province, postalCode);

    }

    @Override
    public void deleteCustomer(String custID) {
        customerRepository.deleteCustomer(custID);

    }

    @Override
    public void updateCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode) {
        customerRepository.updateCustomer(custID, custTitle, custName, dob, salary, custAddress, city, province, postalCode);


    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomers() {

        ObservableList <CustomerDTO> allCustomers = javafx.collections.FXCollections.observableArrayList();

        try {
            ResultSet resultSet = customerRepository.getAllCustomers();

            while (resultSet.next()){
                allCustomers.add(new CustomerDTO(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getDate("DOB").toLocalDate(),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")

                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allCustomers;

    }

    @Override
    public CustomerDTO searchCustomer(String custID, String custName) {

        try {
            ResultSet resultSet = customerRepository.searchCustomer(custID, custName);
            resultSet.next();
            return new CustomerDTO(
                    resultSet.getString("CustID"),
                    resultSet.getString("CustTitle"),
                    resultSet.getString("CustName"),
                    resultSet.getDate("DOB").toLocalDate(),
                    resultSet.getDouble("salary"),
                    resultSet.getString("CustAddress"),
                    resultSet.getString("City"),
                    resultSet.getString("Province"),
                    resultSet.getString("PostalCode")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
