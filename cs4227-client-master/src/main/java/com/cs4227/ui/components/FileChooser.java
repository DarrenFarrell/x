package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;

public class FileChooser extends JFileChooser  {

    Command approveCommand;
    Command cancelCommand;

    public FileChooser(String name){
        this.setName(name);
    }

    public void setApproveCommandCommand(Command command) {
        this.approveCommand = command;
    }

    public void setCancelCommand(Command command) {
        this.cancelCommand = command;
    }

    @Override
    public void approveSelection() {
        approveCommand.execute();
    }

    @Override
    public void cancelSelection() {
        cancelCommand.execute();
    }
}
