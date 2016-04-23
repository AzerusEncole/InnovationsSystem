package com.pavelrudenok.is.view;

import com.pavelrudenok.is.Main;

import javafx.fxml.FXML;

public class MainController {

    @FXML
    private ProjectListController projectListController;

    @FXML
    private StatisticController statisticController;

    @FXML
    private void initialize() {

    }

    public MainController() {

    }

    public StatisticController getStatisticController() {
        return statisticController;
    }

    public void setController(Main app) {
        projectListController.setController(app);
        statisticController.setController(app);
    }


}
