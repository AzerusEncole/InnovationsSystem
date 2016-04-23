package com.pavelrudenok.is.view;

import com.pavelrudenok.is.model.Listed;
import javafx.collections.ObservableList;

public abstract class ContentListController extends ListController {

    public void setController(ObservableList<? extends Listed> items) {
        this.items = items;

        oneInListPath = "templates/ContentInList.fxml";

        showList();
        setItemsListener();
    }
}
