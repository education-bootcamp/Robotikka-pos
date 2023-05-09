package com.devstack.pos.controller;

import com.devstack.pos.dao.DatabaseAccessCode;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class CustomerFormController {

    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public JFXButton btnSaveUpdate;
    public TextField txtSearch;
    public TableView tbl;
    public TableColumn colId;
    public TableColumn colEmail;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colSalary;
    public TableColumn colOperate;

    public void btnSaveUpdateOnAction(ActionEvent actionEvent) {
        try{
            if (
                    DatabaseAccessCode.createCustomer(
                            txtEmail.getText(),txtName.getText(),
                            txtContact.getText(),Double.parseDouble(txtSalary.getText())
                    )
            ){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer Saved!").show();
                clearFields();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void clearFields() {
        txtEmail.clear();
        txtName.clear();
        txtContact.clear();
        txtSalary.clear();
    }
}
