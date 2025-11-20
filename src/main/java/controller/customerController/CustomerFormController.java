package controller.customerController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.CustomerDTO;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    CustomerService customerService = new CustomerServiceImpl();

    ObservableList<CustomerDTO> customerDTOS = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostelCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<CustomerDTO> tblViewCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtCustomerTitle;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostelCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCusId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostelCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        loadAllItems();


        tblViewCustomers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValues) -> {
            if (newValues!= null) {
                setSelectedValue(newValues);
            }
        });

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

    //---------------------------All method---------------------------------------------
    private void loadAllItems(){
        customerDTOS.clear();
        tblViewCustomers.setItems(customerService.getAllCustomers());
    }

    private void setSelectedValue(CustomerDTO selectedValue){
        if(selectedValue == null){
            clearFields();
            return;
        }
        txtCustomerId.setText(selectedValue.getCustomerId());
        txtCustomerTitle.setText(selectedValue.getTitle());
        txtName.setText(selectedValue.getName());
        txtDob.setText(String.valueOf(selectedValue.getDateOfBirth()));
        txtSalary.setText(String.valueOf(selectedValue.getSalary()));
        txtAddress.setText(selectedValue.getAddress());
        txtCity.setText(selectedValue.getCity());
        txtProvince.setText(selectedValue.getProvince());
        txtPostelCode.setText(selectedValue.getPostalCode());

    }
    private void clearFields(){

    }


}
