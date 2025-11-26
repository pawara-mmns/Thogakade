package service.impl;

import model.dto.CustomerDTO;
import model.dto.ItemDTO;
import service.CustomerService;
import service.ItemService;
import service.PlaceOrderService;

public class PlaceOrderServiceImpl implements PlaceOrderService {

    ItemService itemService = new ItemServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    public CustomerDTO getCustomer(String customerID) {
        return customerService.searchCustomer(customerID, null);
    }

    @Override
    public ItemDTO getItem(String itemCode) {
        return itemService.searchItemDetails(itemCode, null);
    }
}
