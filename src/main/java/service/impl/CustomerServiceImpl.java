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
    public void addCustomer() {

    }

    @Override
    public void deleteCustomer() {

    }

    @Override
    public void updateCustomer() {

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
}
