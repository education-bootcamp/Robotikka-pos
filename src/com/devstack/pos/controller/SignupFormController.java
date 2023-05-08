package com.devstack.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField textPassword;

    public void btnAlreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void btnRegisterNowOnAction(ActionEvent actionEvent) {
    }

    private void setUi(String url) throws IOException {
        Stage stage = (Stage)context.getScene().getWindow();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );
        stage.centerOnScreen();
    }
}
