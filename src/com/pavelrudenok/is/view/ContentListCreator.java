package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.Listed;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ContentListCreator {

    public static void create(ListController controller, Stage ownerStage, ObservableList<? extends Listed> items) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ContentListCreator.class.getResource("templates/ContentList.fxml"));
            fxmlLoader.setController(controller);

            AnchorPane itemList = fxmlLoader.load();

            Stage stage = new Stage();
            stage.initOwner(ownerStage);

            Scene scene = new Scene(itemList);
            stage.setScene(scene);

            controller.setController(items);
            controller.setMainStage(stage);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
