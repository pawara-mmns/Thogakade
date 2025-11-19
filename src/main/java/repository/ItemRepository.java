package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemRepository {

    void addItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    void deleteItem(String itemCode);

    void updateItem(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand);

    ResultSet getAllItems () throws SQLException;

}
