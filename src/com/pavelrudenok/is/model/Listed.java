package com.pavelrudenok.is.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Listed {
    protected StringProperty name = new SimpleStringProperty();

    public Listed() {
        this("Безымянный");
    }

    public Listed(String name) {
        setName(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        name = name.trim();

        if (name.length() == 0) {
            name = "Безымянный";
        } else if (name.length() > 50) {
            name = name.substring(0, 50);
        }

        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }
}