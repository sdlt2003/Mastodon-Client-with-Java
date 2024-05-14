package eus.ehu.socialnetwork;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.*;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import static eus.ehu.socialnetwork.domain.Utils.getAvatar;


public class MainAppController {

    @FXML
    private ImageView avatarImg;
    @FXML
    private Button favButton;

    @FXML
    private Button flwerButton;

    @FXML
    private Button flwingButton;

    @FXML
    private Button homeButton;

    @FXML
    private Button myTootsButton;

    @FXML
    private Button notButton;

    @FXML
    private Button pmsgButtn;
    private Window tootsWin, followersAndFollowing;

    public class Window {
        @FXML
        private BorderPane mainWrapper;
        @FXML
        private Button retootButton;
        private FxController controller;
        private Parent ui;
    }

    private Window load(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent ui = loader.load();
            FxController controller = loader.getController();

            Window window = new Window();
            window.controller = controller;
            window.ui = ui;
            return window;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void actionMyToots(ActionEvent event) {
        showScene("Toots");
    }

    @FXML
    void actionFollowers(ActionEvent event) {
        showScene("Followers");
    }

    @FXML
    void actionFollowing(ActionEvent event) {
        showScene("Following");
    }

    @FXML
    private BorderPane mainWrapper;

    @FXML
    void initialize() {

        Image img = null;
        try {
            img = new Image(getClass().getResourceAsStream(getAvatar("109897234224245358")));
        } catch (NullPointerException e) {
            e.getStackTrace();
        }
        avatarImg.setImage(img);
        tootsWin = load("toots.fxml");
        followersAndFollowing = load("FollowersAndFollowing.fxml");
        showScene("Toots");
    }


    private void showScene(String scene) {
        switch (scene) {
            case "Following" -> {
                followersAndFollowing.controller.trampa(false);
                mainWrapper.setCenter(followersAndFollowing.ui);
            }
            case "Followers" -> {

                followersAndFollowing.controller.trampa(true);
                mainWrapper.setCenter(followersAndFollowing.ui);
            }
            case "Toots" -> mainWrapper.setCenter(tootsWin.ui);
        }
    }


}
