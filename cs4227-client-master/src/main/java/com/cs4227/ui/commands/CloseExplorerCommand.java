package com.cs4227.ui.commands;

import com.cs4227.ui.models.ExplorerOpenModel;
import com.cs4227.ui.views.ExplorerView;

public class CloseExplorerCommand implements Command {

    private ExplorerView explorerView;
    private ExplorerOpenModel explorerOpenModel;

    public CloseExplorerCommand(ExplorerOpenModel explorerOpenModel, ExplorerView explorerView){
        this.explorerOpenModel = explorerOpenModel;
        this.explorerView = explorerView;
    }

    @Override
    public void execute() {
        explorerOpenModel.close();
        explorerView.setVisible(explorerOpenModel.getIsExplorerOpen());
    }
}
