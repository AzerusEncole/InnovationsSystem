package com.pavelrudenok.is.view;

import javafx.stage.Stage;

public abstract class Controller {

    protected Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
