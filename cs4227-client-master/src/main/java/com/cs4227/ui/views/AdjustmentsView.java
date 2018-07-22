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

public class AdjustmentsView extends JFrame implements ComponentView{

    private ArrayList<Component> components;
    private ComboBox cmbFilter;
    private Button btnApplyF;
    private Slider sldBrightness;

    private JLabel lblFilter, lblBrightness, lblBrightnessValues;

    public AdjustmentsView() {
        super("Adjustments");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(260, 220);
        this.setLocation(390, 230);

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

        //Components
        lblFilter = new JLabel("FilterAPI Type:");
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblFilter, gbc);
        buttonPanel.add(lblFilter,gbc);

        String tempTypes[] = {"Select FilterAPI", "Monochrome", "Red", "Green", "Blue"};
        cmbFilter = new ComboBox(tempTypes, "FilterTypes");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(cmbFilter, gbc);
        buttonPanel.add(cmbFilter);
        //components.add(cmbFilter);

        btnApplyF = new Button("APPLY");
        btnApplyF.setMnemonic(KeyEvent.VK_F);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(btnApplyF, gbc);
        buttonPanel.add(btnApplyF);
        components.add(btnApplyF);

        lblBrightness = new JLabel("Brightness");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gridbag.setConstraints(lblBrightness, gbc);
        buttonPanel.add(lblBrightness,gbc);

        sldBrightness = new Slider(-100,100, 0, "sldBrightness");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gridbag.setConstraints(sldBrightness, gbc);
        buttonPanel.add(sldBrightness);
        components.add(sldBrightness);

        lblBrightnessValues = new JLabel("-100       -50       0        50        100");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gridbag.setConstraints(lblBrightnessValues, gbc);
        buttonPanel.add(lblBrightnessValues,gbc);

        //Add the buttons and the log to the frame
        Container contentPane = getContentPane();
        contentPane.add(buttonPanel, BorderLayout.NORTH);
    }

    @Override
    public ArrayList<Component> getAllComponents(){
        return components;
    }

    public int getBrightnessValue() {
        return sldBrightness.getValue();
    }

    public String getFilterType(){
        return cmbFilter.getSelectedItem().toString();
    }
}