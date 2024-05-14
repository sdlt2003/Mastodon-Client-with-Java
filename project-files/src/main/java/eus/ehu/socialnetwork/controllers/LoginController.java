package eus.ehu.socialnetwork.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView bocchiImageView;

    @FXML
    private ImageView kitaImageView;

    @FXML
    private ImageView leftImageView;

    @FXML
    private Button loginButton;
    
    @FXML
    private ImageView loginImageView;

    @FXML
    private ImageView logoImageView;

    @FXML
    private TextField passwrdTxt;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTxt;

    @FXML
    void onRegisterButtonClick(ActionEvent event) {

    }

    @FXML
    void onLoginButtonClick(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
            Image leftImage = new Image(getClass().getResourceAsStream("/Images/leftLogin.jpg"));
            leftImageView.setImage(leftImage);
            Image kita = new Image(getClass().getResourceAsStream("/Images/kita.png"));
            kitaImageView.setImage(kita);
            Image bocchi = new Image(getClass().getResourceAsStream("/Images/bocchi.png"));
            bocchiImageView.setImage(bocchi);
            Image loginImage = new Image(getClass().getResourceAsStream("/Images/login.png"));
            loginImageView.setImage(loginImage);
            Image logo = new Image(getClass().getResourceAsStream("/Images/logo.png"));
            logoImageView.setImage(logo);
        

    }

}
