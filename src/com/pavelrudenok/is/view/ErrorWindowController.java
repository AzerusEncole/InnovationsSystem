package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.ProjectsChecker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ErrorWindowController extends Controller {
    @FXML
    private VBox firstLimitation;

    @FXML
    private VBox secondLimitation;

    @FXML
    private VBox thirdLimitation;

    public void setController(ProjectsChecker checker) {
        ArrayList<String> firstErrors = checker.getErrorsFirstLimitation();
        ArrayList<String> secondErrors = checker.getErrorsSecondLimitation();
        ArrayList<String> thirdErrors = checker.getErrorsThirdLimitation();


        for (String error : firstErrors) {
            firstLimitation.getChildren().add(new Label(error));
        }

        for (String error : secondErrors) {
            secondLimitation.getChildren().add(new Label(error));
        }

        for (String error : thirdErrors) {
            thirdLimitation.getChildren().add(new Label(error));
        }
    }
}