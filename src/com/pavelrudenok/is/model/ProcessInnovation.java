package com.pavelrudenok.is.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProcessInnovation extends Content {

    private int usedAmountEquipment;
    private int alowableAmountEquipment;
    private int yearlyFundOfTime;
    private int manufacturingArea;
    private int costsExploitation;
    private ObservableList<GroupElements> groups = FXCollections.observableArrayList();

    public ProcessInnovation() {
        super();
        groups.add(new GroupElements("Безымянный"));
    }

    public ProcessInnovation(String name) {
        super(name);
    }

    public int getUsedAmountEquipment() {
        return usedAmountEquipment;
    }

    public void setUsedAmountEquipment(int usedAmountEquipment) {
        this.usedAmountEquipment = usedAmountEquipment;
    }

    public int getAlowableAmountEquipment() {
        return alowableAmountEquipment;
    }

    public void setAlowableAmountEquipment(int alowableAmountEquipment) {
        this.alowableAmountEquipment = alowableAmountEquipment;
    }

    public int getYearlyFundOfTime() {
        return yearlyFundOfTime;
    }

    public void setYearlyFundOfTime(int yearlyFundOfTime) {
        this.yearlyFundOfTime = yearlyFundOfTime;
    }

    public int getManufacturingArea() {
        return manufacturingArea;
    }

    public void setManufacturingArea(int manufacturingArea) {
        this.manufacturingArea = manufacturingArea;
    }

    public int getCostsExploitation() {
        return costsExploitation;
    }

    public void setCostsExploitation(int costsExploitation) {
        this.costsExploitation = costsExploitation;
    }
}