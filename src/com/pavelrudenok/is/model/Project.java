package com.pavelrudenok.is.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Project extends Listed {

    private ObservableList<ProductInnovation> productInnovations = FXCollections.observableArrayList();
    private ObservableList<ProcessInnovation> processInnovations = FXCollections.observableArrayList();

    private int neededArea;
    private int criterion;

    public Project() {
        this("Безымянный");
    }

    public Project(String name) {
        super(name);
        productInnovations.add(new ProductInnovation("Прод. инновация №1"));
        processInnovations.add(new ProcessInnovation("Проц. инновация №1"));
    }

    public ObservableList<ProductInnovation> getProductInnovations() {
        return productInnovations;
    }

    public ObservableList<ProcessInnovation> getProcessInnovations() {
        return processInnovations;
    }

    public int getNeededArea() {
        return neededArea;
    }

    public void setNeededArea(int neededArea) {
        this.neededArea = neededArea;
    }

    public void calculateOptimalityCriterion() {
        criterion = 0;

        for (ProductInnovation product : productInnovations) {
            criterion += (product.getPriceImplementationVolumeIssue()
                    - product.getMaterialCoastsImplementation())
                    * product.getVolumeIssue();
        }

        for (ProcessInnovation process : processInnovations) {
            criterion -= process.getCostsExploitation()
                    * process.getYearlyFundOfTime()
                    * process.getUsedAmountEquipment();
        }

    }

    public int getCriterion() {
        return criterion;
    }
}