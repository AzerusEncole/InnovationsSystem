package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ProcessListController extends ContentListController {

    public void setMainStage(Stage mainStage) {
        super.setMainStage(mainStage);

        mainStage.setTitle("Процессные инновации");
    }

    @Override
    public void setController(ObservableList<? extends Listed> items) {
        super.setController(items);

        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ObservableList<? super ProcessInnovation>) items).add(new ProcessInnovation());
            }
        });
    }

    public void createEditMenu(Listed listed) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ProcessEditMenu.fxml"));

            AnchorPane processEditMenu = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Процессная инновация");
            stage.initOwner(mainStage);
            stage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(processEditMenu);
            stage.setScene(scene);

            ProcessEditMenuController processEditMenuController = fxmlLoader.getController();
            processEditMenuController.setMainStage(stage);
            processEditMenuController.setController((ProcessInnovation) listed);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
