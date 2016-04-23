package com.pavelrudenok.is.view;

import com.pavelrudenok.is.Main;
import com.pavelrudenok.is.model.Project;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class StatisticController extends Controller {

    private Main app;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private NumberAxis numberAxis;

    public void setController(Main app) {
        this.app = app;
    }

    public void show() {
        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        ObservableList<Project> projects = app.getProjects();

        for (Project p : projects) {
            series.getData().add(new XYChart.Data<>(p.getName(), p.getCriterion()));
        }

        numberAxis.setLabel("Критерий оптимальности");
        barChart.getData().add(series);
    }

    public void clear() {
        barChart.getData().clear();
    }
}