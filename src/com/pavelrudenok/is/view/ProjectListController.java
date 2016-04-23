package com.pavelrudenok.is.view;

import com.pavelrudenok.is.Main;
import com.pavelrudenok.is.model.Listed;
import com.pavelrudenok.is.model.Project;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ProjectListController extends ListController {

    private Main app;

    @FXML
    private Button calculateStatistic;

    @FXML
    private Button clearProjectList;

    public void setController(Main app) {
        this.app = app;

        items = app.getProjects();

        oneInListPath = "templates/ProjectInList.fxml";

        setItemsListener();
        showList();

        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((ObservableList<? super Project>) items).add(new Project());
            }
        });

        calculateStatistic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!app.getProjectChecker().isValid()) {
                    createErrorWindow();
                    app.clearStatistic();
                    return;
                }

                for (Project p : app.getProjects()) {
                    p.calculateOptimalityCriterion();
                }

                app.showStatistic();
            }
        });

        clearProjectList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                items.clear();
                ((ObservableList<? super Project>) items).add(new Project());
            }
        });
    }

    public void createErrorWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ErrorWindow.fxml"));

            ScrollPane errorWindow = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Ошибки");
            stage.initOwner(app.getPrimaryStage());
            stage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(errorWindow);
            stage.setScene(scene);

            ErrorWindowController errorWindowController = fxmlLoader.getController();
            errorWindowController.setMainStage(stage);
            errorWindowController.setController(app.getProjectChecker());

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createEditMenu(Listed listed) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ProjectEditMenu.fxml"));

            AnchorPane projectEditMenu = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Компоненты проекта");
            stage.initOwner(app.getPrimaryStage());
            stage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(projectEditMenu);
            stage.setScene(scene);

            ProjectEditMenuController projectEditMenuController = fxmlLoader.getController();
            projectEditMenuController.setMainStage(stage);
            projectEditMenuController.setController((Project) listed);

            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
