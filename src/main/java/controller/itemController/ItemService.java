package controller.itemController;

import javafx.collections.ObservableList;
import model.dto.ItemDTO;

public interface ItemService {

    void addItemDetails(String itemName, String itemCode, double itemPrice, int itemQuantity);

    void deleteItemDetails(String itemCode);

    void updateItemDetails(String itemName, String itemCode, double itemPrice, int itemQuantity);

    ObservableList<ItemDTO> getAllItemDetails();
}
