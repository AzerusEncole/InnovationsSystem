package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.Project;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProjectEditMenuController extends Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField neededArea;

    @FXML
    private Button product;

    @FXML
    private Button process;

    public void setController(Project project) {

        name.setText(project.getName());
        name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                project.setName(newValue);
            }
        });

        neededArea.setText(Integer.toString(project.getNeededArea()));
        neededArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() == 0) {
                    newValue = "0";
                }
                project.setNeededArea(Integer.valueOf(newValue));
            }
        });

        product.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContentListCreator.create(new ProductListController(), mainStage, project.getProductInnovations());
            }
        });

        process.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContentListCreator.create(new ProcessListController(), mainStage, project.getProcessInnovations());
            }
        });
    }
}