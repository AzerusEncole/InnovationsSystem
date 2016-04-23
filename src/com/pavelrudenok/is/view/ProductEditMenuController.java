package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.ProductInnovation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ProductEditMenuController extends Controller {
    @FXML
    private TextField name;

    @FXML
    private TextField lowLimitVolumeIssue;

    @FXML
    private TextField highLimitVolumeIssue;

    @FXML
    private TextField volumeIssue;

    @FXML
    private TextField priceImplementationVolumeIssue;

    @FXML
    private TextField materialCoastsImplementation;

    @FXML
    private Button groupElement;

    @FXML
    private Button addProduct;

    public void setController(ProductInnovation product) {

        name.setText(product.getName());
        name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                product.setName(newValue);
            }
        });

        lowLimitVolumeIssue.setText(String.valueOf(product.getLowLimitVolumeIssue()));
        highLimitVolumeIssue.setText(String.valueOf(product.getHighLimitVolumeIssue()));
        volumeIssue.setText(String.valueOf(product.getVolumeIssue()));
        priceImplementationVolumeIssue.setText(String.valueOf(product.getPriceImplementationVolumeIssue()));
        materialCoastsImplementation.setText(String.valueOf(product.getMaterialCoastsImplementation()));


        addProduct.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                product.setLowLimitVolumeIssue(Integer.valueOf(lowLimitVolumeIssue.getText()));
                product.setHighLimitVolumeIssue(Integer.valueOf(highLimitVolumeIssue.getText()));
                product.setVolumeIssue(Integer.valueOf(volumeIssue.getText()));
                product.setPriceImplementationVolumeIssue(Integer.valueOf(priceImplementationVolumeIssue.getText()));
                product.setMaterialCoastsImplementation(Integer.valueOf(materialCoastsImplementation.getText()));

                mainStage.close();
            }
        });

        groupElement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ContentListCreator.create(new GroupListController(), mainStage, product.getGroupsElements());
            }
        });
    }

}
