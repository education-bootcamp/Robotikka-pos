package com.devstack.pos.controller;

import com.devstack.pos.bo.BoFactory;
import com.devstack.pos.bo.custom.ProductBo;
import com.devstack.pos.bo.custom.impl.ProductBoImpl;
import com.devstack.pos.dto.ProductDto;
import com.devstack.pos.enums.BoType;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.sql.SQLException;

public class ProductMainPageController {
    public TextArea txtProductDescription;
    public JFXButton btnSaveUpdate;
    public JFXTextField txtProductCode;


    ProductBo bo = BoFactory.getInstance().getBo(BoType.PRODUCT);


    private String searchText = "";

    public void initialize() {
        //--- load new Product Id
        loadProductId();
        //--- load new Product Id
    }

    private void loadProductId() {
        try {
            txtProductCode.setText(String.valueOf(bo.getLastProductId()));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnNewProductOnAction(ActionEvent actionEvent) {
        try {
            if (btnSaveUpdate.getText().equals("Save Product")) {

                if (bo.saveProduct(new ProductDto(Integer.parseInt(txtProductCode.getText()), txtProductDescription.getText()))) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Product Saved!").show();
                    clearFields();
                    loadAllProducts(searchText);
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }
            } else {
                if (bo.saveProduct(new ProductDto(Integer.parseInt(txtProductCode.getText()), txtProductDescription.getText()))) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Product Updated!").show();
                    clearFields();
                    loadAllProducts(searchText);
                    //---------
                    btnSaveUpdate.setText("Save Product");
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again!").show();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void loadAllProducts(String searchText) {
    }

    private void clearFields() {
        txtProductCode.clear();
        txtProductDescription.clear();
        loadProductId();
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
    }
}
