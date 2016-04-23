package com.pavelrudenok.is;

import com.pavelrudenok.is.model.*;
import com.pavelrudenok.is.view.MainController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    private Stage primaryStage;
    private MainController mainController;
    private ObservableList<Project> projects;
    private ProjectsChecker checker;

    public static void main(String[] args) {
        launch(args);
    }

    public void setStartValues() {
        Project[] pr = new Project[9];

        for (int i = 0; i < pr.length; i++) {
            pr[i] = new Project("Проект №" + (i + 1));
            pr[i].setNeededArea(600);
        }

        ///////////////////////////////////////////////////////Project1///////////////////////////////////////////////
        ProductInnovation prod0 = pr[0].getProductInnovations().get(0);
        ProductInnovation prod1 = new ProductInnovation("Прод. инновация №2");
        ProductInnovation prod2 = new ProductInnovation("Прод. инновация №3");
        ProductInnovation prod3 = new ProductInnovation("Прод. инновация №4");
        pr[0].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(25);
        prod0.setHighLimitVolumeIssue(400);
        prod0.setVolumeIssue(40);
        prod0.setPriceImplementationVolumeIssue(99);
        prod0.setMaterialCoastsImplementation(21);

        GroupElements gr0 = prod0.getGroupsElements().get(0);
        GroupElements gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(3);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(143);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        GroupElements gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(25);
        prod2.setHighLimitVolumeIssue(400);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(20);
        prod3.setHighLimitVolumeIssue(150);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        ProcessInnovation prc0 = pr[0].getProcessInnovations().get(0);
        ProcessInnovation prc1 = new ProcessInnovation("Проц. инновация №2");
        ProcessInnovation prc2 = new ProcessInnovation("Проц. инновация №3");
        ProcessInnovation prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[0].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);

        //////////////////////////////////////////////////Project2//////////////////////////////////////////////////


        prod0 = pr[1].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[1].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(34);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(41);
        prod0.setPriceImplementationVolumeIssue(99);
        prod0.setMaterialCoastsImplementation(21);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(3);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 7);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[1].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[1].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


        //////////////////////////////////////////////////Project3//////////////////////////////////////////////////


        prod0 = pr[2].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[2].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(34);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(37);
        prod0.setPriceImplementationVolumeIssue(103);
        prod0.setMaterialCoastsImplementation(21);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(3);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 7);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[2].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[2].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


        //////////////////////////////////////////////////Project4//////////////////////////////////////////////////


        prod0 = pr[3].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[3].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(34);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(37);
        prod0.setPriceImplementationVolumeIssue(99);
        prod0.setMaterialCoastsImplementation(18);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(3);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 9);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 5);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[3].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[3].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


        //////////////////////////////////////////////////Project5//////////////////////////////////////////////////


        prod0 = pr[4].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[4].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(34);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(38);
        prod0.setPriceImplementationVolumeIssue(99);
        prod0.setMaterialCoastsImplementation(18);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 6);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 3);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[4].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[4].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


//////////////////////////////////////////////////Project6//////////////////////////////////////////////////


        prod0 = pr[5].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[5].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(35);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(37);
        prod0.setPriceImplementationVolumeIssue(104);
        prod0.setMaterialCoastsImplementation(21);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 6);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 3);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[5].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[5].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


//////////////////////////////////////////////////Project7//////////////////////////////////////////////////


        prod0 = pr[6].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[6].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(15);
        prod0.setHighLimitVolumeIssue(140);
        prod0.setVolumeIssue(28);
        prod0.setPriceImplementationVolumeIssue(131);
        prod0.setMaterialCoastsImplementation(18);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 6);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 3);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[6].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[6].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


//////////////////////////////////////////////////Project8//////////////////////////////////////////////////


        prod0 = pr[7].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[7].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(20);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(25);
        prod0.setPriceImplementationVolumeIssue(140);
        prod0.setMaterialCoastsImplementation(18);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 6);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 3);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[7].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[7].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


//////////////////////////////////////////////////Project9//////////////////////////////////////////////////


        prod0 = pr[8].getProductInnovations().get(0);
        prod1 = new ProductInnovation("Прод. инновация №2");
        prod2 = new ProductInnovation("Прод. инновация №3");
        prod3 = new ProductInnovation("Прод. инновация №4");
        pr[8].getProductInnovations().addAll(prod1, prod2, prod3);

        prod0.setLowLimitVolumeIssue(34);
        prod0.setHighLimitVolumeIssue(410);
        prod0.setVolumeIssue(34);
        prod0.setPriceImplementationVolumeIssue(110);
        prod0.setMaterialCoastsImplementation(21);

        gr0 = prod0.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod0.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 3);
        gr0.setComplexityProcessings(1, 6);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 3);

        gr1.setApplicabilityFactors(1);
        gr1.setComplexityProcessings(0, 4);
        gr1.setComplexityProcessings(1, 6);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 10);

        ////////////////////////////////////////////

        prod1.setLowLimitVolumeIssue(15);
        prod1.setHighLimitVolumeIssue(144);
        prod1.setVolumeIssue(45);
        prod1.setPriceImplementationVolumeIssue(90);
        prod1.setMaterialCoastsImplementation(21);

        gr0 = prod1.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        gr2 = new GroupElements("Группа элементов №3");
        prod1.getGroupsElements().addAll(gr1, gr2);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 9);
        gr1.setComplexityProcessings(3, 5);

        gr2.setApplicabilityFactors(1);
        gr2.setComplexityProcessings(0, 2);
        gr2.setComplexityProcessings(1, 5);
        gr2.setComplexityProcessings(2, 5);
        gr2.setComplexityProcessings(3, 5);

        ///////////////////////////////////////////


        prod2.setLowLimitVolumeIssue(23);
        prod2.setHighLimitVolumeIssue(250);
        prod2.setVolumeIssue(36);
        prod2.setPriceImplementationVolumeIssue(99);
        prod2.setMaterialCoastsImplementation(18);

        gr0 = prod2.getGroupsElements().get(0);
        gr1 = new GroupElements("Группа элементов №2");
        prod2.getGroupsElements().add(gr1);

        gr0.setApplicabilityFactors(5);
        gr0.setComplexityProcessings(0, 1);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 9);
        gr0.setComplexityProcessings(3, 8);

        gr1.setApplicabilityFactors(4);
        gr1.setComplexityProcessings(0, 5);
        gr1.setComplexityProcessings(1, 4);
        gr1.setComplexityProcessings(2, 5);
        gr1.setComplexityProcessings(3, 5);

        ////////////////////////////////////

        prod3.setLowLimitVolumeIssue(25);
        prod3.setHighLimitVolumeIssue(100);
        prod3.setVolumeIssue(39);
        prod3.setPriceImplementationVolumeIssue(99);
        prod3.setMaterialCoastsImplementation(22);

        gr0 = prod3.getGroupsElements().get(0);

        gr0.setApplicabilityFactors(4);
        gr0.setComplexityProcessings(0, 5);
        gr0.setComplexityProcessings(1, 4);
        gr0.setComplexityProcessings(2, 5);
        gr0.setComplexityProcessings(3, 8);

        /////////////////////////////////////////////////

        prc0 = pr[8].getProcessInnovations().get(0);
        prc1 = new ProcessInnovation("Проц. инновация №2");
        prc2 = new ProcessInnovation("Проц. инновация №3");
        prc3 = new ProcessInnovation("Проц. инновация №4");
        pr[8].getProcessInnovations().addAll(prc1, prc2, prc3);

        prc0.setUsedAmountEquipment(15);
        prc0.setAlowableAmountEquipment(15);
        prc0.setYearlyFundOfTime(50);
        prc0.setManufacturingArea(10);
        prc0.setCostsExploitation(4);

        prc1.setUsedAmountEquipment(15);
        prc1.setAlowableAmountEquipment(15);
        prc1.setYearlyFundOfTime(50);
        prc1.setManufacturingArea(10);
        prc1.setCostsExploitation(4);

        prc2.setUsedAmountEquipment(15);
        prc2.setAlowableAmountEquipment(15);
        prc2.setYearlyFundOfTime(50);
        prc2.setManufacturingArea(10);
        prc2.setCostsExploitation(4);

        prc3.setUsedAmountEquipment(15);
        prc3.setAlowableAmountEquipment(15);
        prc3.setYearlyFundOfTime(50);
        prc3.setManufacturingArea(10);
        prc3.setCostsExploitation(4);


        projects = FXCollections.observableArrayList(pr);
    }

    public ObservableList<Project> getProjects() {
        return projects;
    }

    public ProjectsChecker getProjectChecker() {
        return checker;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Система инноваций");

        setStartValues();
        checker = new ProjectsChecker(projects);
        initRoot();
    }

    private void initRoot() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("view/Main.fxml"));
            TabPane mainPane = fxmlLoader.load();

            Scene scene = new Scene(mainPane);
            primaryStage.setScene(scene);
            primaryStage.show();

            mainController = fxmlLoader.getController();
            mainController.setController(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showStatistic() {
        mainController.getStatisticController().show();
    }

    public void clearStatistic() {
        mainController.getStatisticController().clear();
    }
}
