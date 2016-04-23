package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.GroupElements;
import com.pavelrudenok.is.model.Listed;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GroupListController extends ContentListController {
    public void setMainStage(Stage mainStage) {
        super.setMainStage(mainStage);

        mainStage.setTitle("Группы элементов");
    }

    @Override
    public void setController(ObservableList<? extends Listed> items) {
        super.setController(items);

        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ObservableList<? super GroupElements>) items).add(new GroupElements());
            }
        });
    }

    public void createEditMenu(Listed listed) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("GroupEditMenu.fxml"));

            AnchorPane groupEditMenu = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Группа элементов");
            stage.initOwner(mainStage);
            stage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(groupEditMenu);
            stage.setScene(scene);

            GroupEditMenuController groupEditMenuController = fxmlLoader.getController();
            groupEditMenuController.setMainStage(stage);
            groupEditMenuController.setController((GroupElements) listed);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
