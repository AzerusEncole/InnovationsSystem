package com.pavelrudenok.is.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductInnovation extends Content {

    private int lowLimitVolumeIssue;
    private int highLimitVolumeIssue;
    private int volumeIssue;
    private int priceImplementationVolumeIssue;
    private int materialCoastsImplementation;
    private ObservableList<GroupElements> groupsElements = FXCollections.observableArrayList();

    public ProductInnovation() {
        super();
    }

    public ProductInnovation(String name) {
        super(name);

        groupsElements.add(new GroupElements("Группа элементов №1"));
    }

    public int getLowLimitVolumeIssue() {
        return lowLimitVolumeIssue;
    }

    public void setLowLimitVolumeIssue(int lowLimitVolumeIssue) {
        this.lowLimitVolumeIssue = lowLimitVolumeIssue;
    }

    public int getHighLimitVolumeIssue() {
        return highLimitVolumeIssue;
    }

    public void setHighLimitVolumeIssue(int highLimitVolumeIssue) {
        this.highLimitVolumeIssue = highLimitVolumeIssue;
    }

    public int getVolumeIssue() {
        return volumeIssue;
    }

    public void setVolumeIssue(int volumeIssue) {
        this.volumeIssue = volumeIssue;
    }

    public int getPriceImplementationVolumeIssue() {
        return priceImplementationVolumeIssue;
    }

    public void setPriceImplementationVolumeIssue(int priceImplementationVolumeIssue) {
        this.priceImplementationVolumeIssue = priceImplementationVolumeIssue;
    }

    public int getMaterialCoastsImplementation() {
        return materialCoastsImplementation;
    }

    public void setMaterialCoastsImplementation(int materialCoastsImplementation) {
        this.materialCoastsImplementation = materialCoastsImplementation;
    }

    public ObservableList<GroupElements> getGroupsElements() {
        return groupsElements;
    }
}