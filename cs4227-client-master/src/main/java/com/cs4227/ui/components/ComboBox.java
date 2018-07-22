package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class ComboBox extends JComboBox implements Component{

    Command command;

    public ComboBox(String types[],String name) {
        super(types);
        this.setName(name);
    }

    @Override
    public void onAction() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void addEventListener(EventListener componentListener) {
        this.addActionListener((ActionListener) componentListener);
    }
}
