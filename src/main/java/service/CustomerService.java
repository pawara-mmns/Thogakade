package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

public interface CustomerService {

    void addCustomer(String custID, String custTitle, String custName, String dob, double salary, String custAddress, String city, String province, String postalCode);

    void deleteCustomer();

    void updateCustomer();

    ObservableList<CustomerDTO> getAllCustomers();
}
