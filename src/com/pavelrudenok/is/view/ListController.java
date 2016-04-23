package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.Listed;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract class ListController extends Controller {

    protected ObservableList<? extends Listed> items;
    protected String oneInListPath;

    @FXML
    protected Button addItem;

    @FXML
    protected VBox itemList;

    public void setController(ObservableList<? extends Listed> items) {

    }

    protected void setItemsListener() {
        items.addListener(new ListChangeListener<Listed>() {
            @Override
            public void onChanged(Change<? extends Listed> c) {
                showList();
            }
        });
    }

    public void showList() {
        itemList.getChildren().clear();

        try {

            for (int i = 0; i < items.size(); i++) {
                final AnchorPane contentInList = FXMLLoader.load(getClass().getResource(oneInListPath));

                HBox buttons = (HBox) contentInList.getChildren().get(0);
                Button editItem = (Button) buttons.getChildren().get(0);
                Button deleteItem = (Button) buttons.getChildren().get(1);
                Label name = (Label) contentInList.getChildren().get(1);

                name.setText(items.get(i).getName());

                deleteItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        if (items.size() == 1) return;
                        int index = ((VBox) contentInList.getParent()).getChildren().indexOf(contentInList);
                        items.remove(index);
                    }
                });

                final int closureIndex = i;
                editItem.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createEditMenu(items.get(closureIndex));
                    }
                });

                items.get(i).nameProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        name.setText(newValue);
                    }
                });

                itemList.getChildren().add(contentInList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void createEditMenu(Listed listed);
}
