package service;

import javafx.collections.ObservableList;
import model.dto.CustomerDTO;

public interface CustomerService {

    void addCustomer();

    void deleteCustomer();

    void updateCustomer();

    ObservableList<CustomerDTO> getAllCustomers();
}
