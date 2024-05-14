package eus.ehu.socialnetwork.domain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class AccountCell extends ListCell<Status.Account> {

    private FXMLLoader loader;
    @FXML
    private AnchorPane listItem;
    @FXML
    private Label accountName;
    @FXML
    private ImageView avatar;
    @FXML
    private Label displayName;
    @FXML
    protected void updateItem(Status.Account item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setGraphic(null);
            setText(null);

            return;
        }

        if (loader == null) {
            loader = new FXMLLoader(getClass().getResource("/eus/ehu/socialnetwork/account-view.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        accountName.setText("@" + item.getUsername());
        displayName.setText(item.getDisplay_name());
        avatar.setImage(new Image(item.getAvatar()));

        setText(null);
        setGraphic(listItem);
    }
}