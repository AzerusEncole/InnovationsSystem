package com.pavelrudenok.is.model;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectsChecker {
    private ObservableList<Project> projects;
    private ArrayList<String> errorsFirstLimitation = new ArrayList<>();
    private ArrayList<String> errorsSecondLimitation = new ArrayList<>();
    private ArrayList<String> errorsThirdLimitation = new ArrayList<>();

    public ProjectsChecker(ObservableList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<String> getErrorsFirstLimitation() {
        return errorsFirstLimitation;
    }

    public ArrayList<String> getErrorsSecondLimitation() {
        return errorsSecondLimitation;
    }

    public ArrayList<String> getErrorsThirdLimitation() {
        return errorsThirdLimitation;
    }

    public boolean isValid() {
        check();

        return errorsFirstLimitation.size() == 0
                && errorsSecondLimitation.size() == 0
                && errorsThirdLimitation.size() == 0;
    }

    private void check() {
        checkFirstLimitation();
        checkSecondLimitation();
        checkThirdLimitation();
    }

    private void checkFirstLimitation() {
        errorsFirstLimitation.clear();

        for (Project project : projects) {

            for (ProductInnovation product : project.getProductInnovations()) {

                if (product.getVolumeIssue() < product.getLowLimitVolumeIssue()
                        || product.getVolumeIssue() >= product.getHighLimitVolumeIssue()) {

                    errorsFirstLimitation.add(project.getName() + " -> " + product.getName());
                }
            }
        }
    }

    private void checkSecondLimitation() {
        errorsSecondLimitation.clear();

        for (Project project : projects) {
            ObservableList<ProcessInnovation> processes = project.getProcessInnovations();
            int result = 0;

            for (ProductInnovation product : project.getProductInnovations()) {
                for (GroupElements group : product.getGroupsElements()) {
                    HashMap<Integer, Integer> complexities = group.getComplexityProcessings();

                    for (Map.Entry<Integer, Integer> entry : complexities.entrySet()) {
                        ProcessInnovation process = processes.get(entry.getKey());
                        int complexity = entry.getValue();

                        result += complexity
                                * group.getApplicabilityFactor()
                                * product.getVolumeIssue()
                                - process.getYearlyFundOfTime()
                                * process.getUsedAmountEquipment();

                    }
                }
            }

            if (result > 0) {
                errorsSecondLimitation.add(project.getName());
            }

            for (ProcessInnovation process : processes) {
                if (process.getUsedAmountEquipment() - process.getAlowableAmountEquipment() != 0
                        || process.getUsedAmountEquipment() < 0) {

                    errorsSecondLimitation.add(project.getName() + " -> " + process.getName());
                }
            }
        }
    }

    private void checkThirdLimitation() {
        errorsThirdLimitation.clear();

        for (Project project : projects) {
            int result = 0;

            for (ProcessInnovation process : project.getProcessInnovations()) {
                result += process.getManufacturingArea() * process.getUsedAmountEquipment();
            }

            if (result - project.getNeededArea() != 0) {
                errorsThirdLimitation.add(project.getName());
            }
        }
    }
}