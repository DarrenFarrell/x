package com.cs4227.ui.commands;

import com.cs4227.ui.models.ExplorerModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.ExplorerView;

import javax.swing.*;


public class SaveImageCommand implements Command {

    private ImageModel imageModel;
    private ExplorerModel explorerModel;
    private ExplorerView explorerView;

    public SaveImageCommand(ExplorerView explorerView, ImageModel imageModel, ExplorerModel explorerModel){
        this.imageModel = imageModel;
        this.explorerView = explorerView;
        this.explorerModel = explorerModel;
    }

    @Override
    public void execute() {
        String path = explorerView.getFileChooser().getSelectedFile().getAbsolutePath();
        imageModel.saveImage(path);
        explorerModel.close();
        explorerView.setVisible(explorerModel.getIsExplorerOpen());
        JOptionPane.showMessageDialog (null, imageModel.getAlertMessage(), "Alert", JOptionPane.INFORMATION_MESSAGE);
    }
}
