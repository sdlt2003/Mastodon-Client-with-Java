package eus.ehu.socialnetwork.controllers;

import eus.ehu.socialnetwork.FxController;
import eus.ehu.socialnetwork.domain.AccountCell;
import eus.ehu.socialnetwork.domain.Status;
import eus.ehu.socialnetwork.domain.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class FollowController implements FxController {

    @FXML
    private ListView<Status.Account> accountsView;

    private List<Status.Account> itemList;
    @FXML
    private Label descriptor;

    public void showFollowers(){

        assert itemList != null;
        ObservableList<Status.Account> items = FXCollections.observableList(itemList);
        if(accountsView!=null){
            accountsView.setItems(items);
            accountsView.setCellFactory(param ->{
                var cell=new AccountCell();
                return cell;
            });
        }
    }
    @FXML
    void initialize(){

    }
    public void trampa(boolean followers){
        if(followers){
            itemList=(List<Status.Account>) Utils.MainProgram(Utils.followersLink());
            descriptor.setText("Showing followers");
        }
        else{
            itemList=(List<Status.Account>) Utils.MainProgram(Utils.followingLink());
            descriptor.setText("Showing follows");
        }
        showFollowers();
    }


}



















