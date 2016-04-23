package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.ProcessInnovation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProcessEditMenuController extends Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField usedAmountEquipment;

    @FXML
    private TextField alowableAmountEquipment;

    @FXML
    private TextField yearlyFundOfTime;

    @FXML
    private TextField manufacturingArea;

    @FXML
    private TextField costsExploitation;

    @FXML
    private Button addItem;

    public void setController(ProcessInnovation process) {

        name.setText(process.getName());
        name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                process.setName(newValue);
            }
        });

        usedAmountEquipment.setText(String.valueOf(process.getUsedAmountEquipment()));
        alowableAmountEquipment.setText(String.valueOf(process.getAlowableAmountEquipment()));
        yearlyFundOfTime.setText(String.valueOf(process.getYearlyFundOfTime()));
        manufacturingArea.setText(String.valueOf(process.getManufacturingArea()));
        costsExploitation.setText(String.valueOf(process.getCostsExploitation()));


        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                process.setUsedAmountEquipment(Integer.valueOf(usedAmountEquipment.getText()));
                process.setAlowableAmountEquipment(Integer.valueOf(alowableAmountEquipment.getText()));
                process.setYearlyFundOfTime(Integer.valueOf(yearlyFundOfTime.getText()));
                process.setManufacturingArea(Integer.valueOf(manufacturingArea.getText()));
                process.setCostsExploitation(Integer.valueOf(costsExploitation.getText()));

                mainStage.close();
            }
        });
    }

}
