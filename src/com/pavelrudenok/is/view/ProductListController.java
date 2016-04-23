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

public class ProductListController extends ContentListController {

    public void setMainStage(Stage mainStage) {
        super.setMainStage(mainStage);

        mainStage.setTitle("Продуктовые инновации");
    }

    @Override
    public void setController(ObservableList<? extends Listed> items) {
        super.setController(items);

        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ObservableList<? super ProductInnovation>) items).add(new ProductInnovation());
            }
        });
    }

    public void createEditMenu(Listed listed) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ProductEditMenu.fxml"));

            AnchorPane productEditMenu = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Продуктовая инновация");
            stage.initOwner(mainStage);
            stage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(productEditMenu);
            stage.setScene(scene);

            ProductEditMenuController productEditMenuController = fxmlLoader.getController();
            productEditMenuController.setMainStage(stage);
            productEditMenuController.setController((ProductInnovation) listed);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
