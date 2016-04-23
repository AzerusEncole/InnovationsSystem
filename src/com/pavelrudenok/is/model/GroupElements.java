package com.pavelrudenok.is.model;

import java.util.HashMap;

public class GroupElements extends Content {

    private int applicabilityFactor;
    private HashMap<Integer, Integer> complexityProcessings = new HashMap<>();

    public GroupElements() {
        super();
    }

    public GroupElements(String name) {
        super(name);
    }

    public int getApplicabilityFactor() {
        return applicabilityFactor;
    }

    public void setApplicabilityFactors(int applicabilityFactor) {
        this.applicabilityFactor = applicabilityFactor;
    }

    public HashMap<Integer, Integer> getComplexityProcessings() {
        return complexityProcessings;
    }

    public void setComplexityProcessings(int processIndex, int complexityOfProcessing) {
        complexityProcessings.put(processIndex, complexityOfProcessing);
    }
}