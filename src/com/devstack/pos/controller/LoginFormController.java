package com.devstack.pos.controller;

import com.devstack.pos.dao.DatabaseAccessCode;
import com.devstack.pos.dto.UserDto;
import com.devstack.pos.util.PasswordManager;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {
    public AnchorPane context;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;

    public void btnCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignupForm");
    }

    public void btnSignInOnAction(ActionEvent actionEvent) {

        try {
            UserDto ud= DatabaseAccessCode.findUser(txtEmail.getText());
            if (ud!=null) {
                if (PasswordManager.checkPassword(txtPassword.getText(), ud.getPassword())) {
                    setUi("DashboardForm");
                } else {
                    new Alert(Alert.AlertType.WARNING, "check your password and try again!").show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "User email not found!").show();
            }


        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    private void setUi(String url) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/" + url + ".fxml")))
        );
    }

}
