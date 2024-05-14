package eus.ehu.socialnetwork.controllers;

import eus.ehu.socialnetwork.FxController;
import eus.ehu.socialnetwork.domain.Status;
import eus.ehu.socialnetwork.domain.Utils;
import eus.ehu.socialnetwork.domain.HyperLinkRedirectListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;

public class TootsController implements FxController {

    @FXML
    private Button nextButton;
    @FXML
    private CheckBox boostedCheck;
    @FXML
    private TextField author;
    @FXML
    private Button previousButton;
    @FXML
    private TextField date;
    @FXML
    private WebView contents;
    @FXML
    private Label noNext;
    @FXML
    private Label noPrev;

    private int currentToot = 0;
    private List<Status> localList = new ArrayList<>();
    private String temp1;
    private String temp2;


    public void getInfo() {

        temp1 = "";
        temp2 = "";

        Status toot= localList.get(currentToot);
        if (toot.getReblog() != null) {
            boostedCheck.setSelected(true);
            author.setText(toot.getReblog().getAccount().getUsername());
            date.setText(toot.getReblog().getCreated_at());
            temp1 = toot.getReblog().getContent();
            try {
                for(int i=0; i<toot.getReblog().getMedia_attachment_list().size(); i++) {
                    temp2 = temp2 + toot.getReblog().getMedia_attachment_list().get(i).getUrl() +"\n";
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        } else {
            boostedCheck.setSelected(false);
            author.setText(toot.getAccount().getUsername());
            date.setText(toot.getCreated_at());
            temp1 = toot.getContent();
            try {
                for(int i=0; i<toot.getMedia_attachment_list().size(); i++) {
                    temp2 = temp2 + toot.getMedia_attachment_list().get(i).getUrl() +"\n";
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        }
        contents.getEngine().loadContent(temp1 + temp2);

    }

    @FXML
    void nextToot(ActionEvent event){
        try{
            if(currentToot <localList.size()-1){
                noPrev.setVisible(false);
                currentToot++;
                getInfo();
            }
        } catch (IndexOutOfBoundsException e){
            e.getMessage();
        }
        if(currentToot ==localList.size()-1){
            noNext.setVisible(true);
        }
    }

    @FXML
    void previousToot(ActionEvent event) {
        try{
            if(currentToot >0){
                noNext.setVisible(false);
                currentToot--;
                getInfo();
            }
        } catch (IndexOutOfBoundsException e){
            e.getMessage();
        }
        if(currentToot ==0){
            noPrev.setVisible(true);
        }
    }

    @FXML
    void initialize(){
        localList= (List<Status>) Utils.MainProgram(Utils.statutesLink());
        contents.getEngine().getLoadWorker().stateProperty().addListener(new HyperLinkRedirectListener(contents));
        boostedCheck.setStyle("-fx-opacity: 1");
        getInfo();
    }

    public void trampa(boolean follower){}
}