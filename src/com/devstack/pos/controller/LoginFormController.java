package com.devstack.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void btnCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }

    public void btnSignInOnAction(ActionEvent actionEvent) {
        // login
    }

    private void setUi(String url) throws IOException {
        Stage stage = (Stage)context.getScene().getWindow();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );
        stage.centerOnScreen();
    }

}
