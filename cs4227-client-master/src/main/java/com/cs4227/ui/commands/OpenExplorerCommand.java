package com.cs4227.ui.commands;

import com.cs4227.ui.models.ExplorerModel;
import com.cs4227.ui.models.ExplorerOpenModel;
import com.cs4227.ui.views.ExplorerView;

public class OpenExplorerCommand implements Command {

    private ExplorerView explorerView;
    private ExplorerModel explorerModel;

    public OpenExplorerCommand(ExplorerModel explorerModel, ExplorerView explorerView){
        this.explorerModel = explorerModel;
        this.explorerView = explorerView;
    }

    @Override
    public void execute() {
        explorerModel.open();
        explorerView.setVisible(explorerModel.getIsExplorerOpen());
    }
}
