package service;

import model.dto.CustomerDTO;
import model.dto.ItemDTO;

public interface PlaceOrderService {
    CustomerDTO getCustomer(String customerID);

    ItemDTO getItem(String itemCode);
}
