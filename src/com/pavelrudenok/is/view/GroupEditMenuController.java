package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.GroupElements;
import com.pavelrudenok.is.util.Parser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class GroupEditMenuController extends Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField applicabilityFactor;

    @FXML
    private TextField complexityProcessings;

    @FXML
    private Button addItem;

    protected void setController(GroupElements group) {

        name.setText(group.getName());
        name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                group.setName(newValue);
            }
        });

        applicabilityFactor.setText(String.valueOf(group.getApplicabilityFactor()));
        complexityProcessings.setText(Parser.hashMapToString(group.getComplexityProcessings()));

        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                group.setApplicabilityFactors(Integer.valueOf(applicabilityFactor.getText()));

                HashMap<Integer, Integer> hashMap = group.getComplexityProcessings();
                hashMap.clear();

                String str = complexityProcessings.getText().trim();

                if (str.length() != 0) {
                    hashMap.putAll(Parser.stringToHashMap(str));
                }

                mainStage.close();
            }
        });
    }
}
