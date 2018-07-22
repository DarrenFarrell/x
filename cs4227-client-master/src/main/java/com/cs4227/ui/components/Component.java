package com.cs4227.ui.components;

import com.cs4227.ui.commands.Command;

import java.awt.event.ActionListener;
import java.util.EventListener;

public interface Component {
    void onAction();
    void setCommand(Command command);
    void addEventListener(EventListener componentListener);
    String getName();
}

