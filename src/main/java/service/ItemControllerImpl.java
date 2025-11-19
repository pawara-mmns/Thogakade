package service;

import db.DBConnection;
import javafx.collections.ObservableList;
import model.dto.ItemDTO;
import repository.ItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemControllerImpl implements ItemService {

    ItemRepository itemRepository = new ItemRepository();

    @Override
    public void addItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {

        itemRepository.addItem(itemCode,description,PackSize,unitPrice,qtyOnHand);

    }

    @Override
    public void deleteItemDetails(String itemCode) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM item WHERE ItemCode = ?");

            pstm.setObject(1,itemCode);
            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateItemDetails(String itemCode, String description, String PackSize, double unitPrice, int qtyOnHand) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            String SQL = "UPDATE item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setObject(1, description);
            preparedStatement.setObject(2, PackSize);
            preparedStatement.setObject(3, unitPrice);
            preparedStatement.setObject(4, qtyOnHand);
            preparedStatement.setObject(5, itemCode);

            preparedStatement.executeUpdate();

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<ItemDTO> getAllItemDetails() {
        ObservableList<ItemDTO> itemDetails = javafx.collections.FXCollections.observableArrayList();

        try {

            ResultSet allItems = itemRepository.getAllItems();

            while (allItems.next()){
                itemDetails.add(new ItemDTO(
                        allItems.getString("ItemCode"),
                        allItems.getString("Description"),
                        allItems.getString("PackSize"),
                        allItems.getDouble("UnitPrice"),
                        allItems.getInt("QtyOnHand")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return itemDetails;
    }
}
