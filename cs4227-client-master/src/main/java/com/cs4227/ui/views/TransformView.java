package com.cs4227.ui.views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventListener;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Button;
import com.cs4227.ui.components.ComboBox;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.components.Slider;

public class TransformView extends JFrame implements ComponentView{

    private ArrayList<Component> components;
    private ComboBox cmbRotateDir, cmbRotateDeg;
    private Button btnApplyR, btnApplyS;
    private TextField txtImageWidth, txtImageHeight;

    private JLabel lblRotateDir, lblRotateDeg, lblSizeWidth, lblSizeHeight;

    public TransformView() {
        super("Transform");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(260, 400);
        this.setLocation(390, 450);

        //Button Panel
        JPanel buttonPanel = new JPanel();
        components = new ArrayList<Component>();

        lblRotateDir = new JLabel("Direction:");
        lblRotateDeg = new JLabel("Degrees:");

        String tempDir[] = {"Clockwise", "Anti-Clockwise"};
        cmbRotateDir = new ComboBox(tempDir, "Direction");

        String tempDeg[] = {"90 Degrees", "45 Degrees"};
        cmbRotateDeg = new ComboBox(tempDeg, "Degree");

        btnApplyR = new Button("ROTATE");
        btnApplyR.setMnemonic(KeyEvent.VK_R);

        lblSizeWidth = new JLabel("Width:");
        lblSizeHeight = new JLabel("Height:");

        txtImageWidth = new TextField(5);
        txtImageHeight = new TextField(5);

        btnApplyS = new Button("CHANGE SIZE");
        btnApplyS.setMnemonic(KeyEvent.VK_S);

        //Layout
        GridBagLayout gridbag = new GridBagLayout();
        buttonPanel.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;
        gbc.insets.left = 5;
        gbc.insets.right = 5;



        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblRotateDir, gbc);
        buttonPanel.add(lblRotateDir);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(cmbRotateDir, gbc);
        buttonPanel.add(cmbRotateDir,gbc);
        //components.add(cmbRotateDir);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblRotateDeg, gbc);
        buttonPanel.add(lblRotateDeg);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(cmbRotateDeg, gbc);
        buttonPanel.add(cmbRotateDeg,gbc);
        //components.add(cmbRotateDeg);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(btnApplyR, gbc);
        buttonPanel.add(btnApplyR);
        components.add(btnApplyR);


        gbc.gridx = 0;
        gbc.gridy = 7;
        gridbag.setConstraints(lblSizeWidth, gbc);
        buttonPanel.add(lblSizeWidth);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gridbag.setConstraints(txtImageWidth, gbc);
        buttonPanel.add(txtImageWidth);


        gbc.gridx = 0;
        gbc.gridy = 9;
        gridbag.setConstraints(lblSizeHeight, gbc);
        buttonPanel.add(lblSizeHeight);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gridbag.setConstraints(txtImageHeight, gbc);
        buttonPanel.add(txtImageHeight);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gridbag.setConstraints(btnApplyS, gbc);
        buttonPanel.add(btnApplyS);
        components.add(btnApplyS);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public ArrayList<Component> getAllComponents(){
        return components;
    }

    public int getInputWidth() {
        return Integer.parseInt(txtImageWidth.getText());
    }

    public int getInputHeight() {
        return Integer.parseInt(txtImageHeight.getText());
    }

    public String getRotateDirection(){
        return cmbRotateDir.getSelectedItem().toString();
    }

    public String getRotateDegree(){
        return cmbRotateDeg.getSelectedItem().toString();
    }
}