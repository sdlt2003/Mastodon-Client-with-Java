package eus.ehu.socialnetwork.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField signUpUser;

    @FXML
    private TextField SignUpPass;

    @FXML
    private TextField SignUpPass2;


    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTxt;

    @FXML
    void onSignUpButton(ActionEvent event) {

    }

    @FXML
    private ImageView leftImageView2;
    @FXML
    private ImageView nijikaIMG;
    @FXML
    private ImageView signUp;
    @FXML
    private ImageView logoImageView2;
    @FXML
    private ImageView Ryo;
    
    @FXML
    void initialize() {

        Image leftImage = new Image(getClass().getResourceAsStream("/Images/leftLogin.jpg"));
        leftImageView2.setImage(leftImage);
        Image nijika = new Image(getClass().getResourceAsStream("/Images/nijikaMaid-removebg-preview.png"));
        nijikaIMG.setImage(nijika);
        Image ryo = new Image(getClass().getResourceAsStream("/Images/HangedRyoFinal.png"));
        Ryo.setImage(ryo);
        Image signUpImage = new Image(getClass().getResourceAsStream("/Images/signUp.png"));
        signUp.setImage(signUpImage);
        Image logo = new Image(getClass().getResourceAsStream("/Images/logo.png"));
        logoImageView2.setImage(logo);


    }

}
