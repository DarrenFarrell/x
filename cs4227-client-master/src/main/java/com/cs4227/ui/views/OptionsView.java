package com.cs4227.ui.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventListener;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Button;
import com.cs4227.ui.components.Component;

public class OptionsView extends JFrame implements ComponentView{

    private ArrayList<Component> components;
    private Button btnOpen;
    private Button btnSave;
    private Button btnUndo;
    private Button btnRedo;
    private Button btnSaveSt;

    public OptionsView() {
        super("Main");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(620, 80);
        this.setLocation(650, 150);

        //Button Panel
        JPanel buttonPanel = new JPanel();
        components = new ArrayList<Component>();

        //Layout
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;

        //Create buttons
        btnOpen = new Button("OPEN");
        btnOpen.setMnemonic(KeyEvent.VK_O);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(btnOpen, gbc);
        buttonPanel.add(btnOpen);
        components.add(btnOpen);

        btnSave = new Button("SAVE");
        btnSave.setMnemonic(KeyEvent.VK_T);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gridbag.setConstraints(btnSave, gbc);
        buttonPanel.add(btnSave);
        components.add(btnSave);

        btnUndo = new Button("UNDO");
        btnUndo.setMnemonic(KeyEvent.VK_U);
        gbc.gridx = 3;
        gbc.gridy = 0;
        gridbag.setConstraints(btnUndo, gbc);
        buttonPanel.add(btnUndo);
        components.add(btnUndo);

        btnRedo = new Button("REDO");
        btnRedo.setMnemonic(KeyEvent.VK_R);
        gbc.gridx = 4;
        gbc.gridy = 0;
        gridbag.setConstraints(btnRedo, gbc);
        buttonPanel.add(btnRedo);
        components.add(btnRedo);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public ArrayList<Component> getAllComponents(){
        return components;
    }
}