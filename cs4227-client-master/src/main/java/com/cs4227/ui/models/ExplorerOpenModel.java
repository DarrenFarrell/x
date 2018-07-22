package com.cs4227.ui.models;

public class ExplorerOpenModel implements ExplorerModel {
    boolean isExplorerOpen;

    public void open() {
        isExplorerOpen = true;
    }

    public void close() {
        isExplorerOpen = false;
    }

    public boolean getIsExplorerOpen(){
        return isExplorerOpen;
    }
}
