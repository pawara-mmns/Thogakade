package controller.itemController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {

    ItemService itemService = new ItemController();

    ObservableList<ItemDTO> itemDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colitemCode;

    @FXML
    private TableView<ItemDTO> tblItemView;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    //--------------------------------------Initialize method------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    //load table  columns
    colitemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
    colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
    colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
    colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    loadAllItems();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }


    //--------------------------------------All methods------------------------------------
    private void loadAllItems(){

        itemDTOS.clear();
        tblItemView.setItems(itemService.getAllItemDetails());
    }
}
