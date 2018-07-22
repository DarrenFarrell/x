package com.cs4227.ui;

import com.cs4227.ui.commands.*;
import com.cs4227.ui.components.Component;
import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.models.ExplorerSaveModel;
import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.models.ExplorerOpenModel;
import com.cs4227.ui.views.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;


public class EditorController {

    private ImageView imageView;
    private OptionsView optionsView;
    private AdjustmentsView adjustmentsView;
    private TransformView transformView;
    private ExplorerView explorerOpen;
    private ExplorerView explorerSave;

    private ImageModel imageModel;
    private ExplorerOpenModel explorerOpenModel;
    private ExplorerSaveModel explorerSaveModel;

    public EditorController(ImageView imageView, OptionsView optionsView, AdjustmentsView adjustmentsView, TransformView transformView) {

        //Views
        this.imageView = imageView;
        this.optionsView = optionsView;
        this.adjustmentsView = adjustmentsView;
        this.transformView = transformView;

        this.explorerOpen = new ExplorerView("OPEN");
        this.explorerSave = new ExplorerView("SAVE");

        //Models
        imageModel = new ImageModel(this.imageView.getImage());
        explorerOpenModel = new ExplorerOpenModel();
        explorerSaveModel = new ExplorerSaveModel();


        //Wire Views -> Commands -> Models
        ComponentListener componentListener = new ComponentListener();
        initializeImageView(componentListener);
        initializeOptionsView(componentListener);
        initializeAdjustmentsView(componentListener);
        initializeTransformView(componentListener);

        initializeExplorerOpen();
        initializeExplorerClose();
    }

    private void initializeImageView(ComponentListener componentListener) {
    }

    private void initializeOptionsView(ComponentListener componentListener) {
        ArrayList<Component> components = this.optionsView.getAllComponents();
        addComponentListener(components, componentListener);

        addCommandToComponent(components, "OPEN", new OpenExplorerCommand(explorerOpenModel,   explorerOpen));
        addCommandToComponent(components,"OPEN", new OpenExplorerCommand(explorerOpenModel, explorerOpen));
        addCommandToComponent(components,"SAVE", new OpenExplorerCommand(explorerSaveModel, explorerSave));
        addCommandToComponent(components,"UNDO", new UndoCommand(imageView));
        addCommandToComponent(components,"REDO", new RedoCommand(imageView));
    }

    private void initializeAdjustmentsView(ComponentListener componentListener) {
        ArrayList<Component> components = this.adjustmentsView.getAllComponents();
        addComponentListener(components, componentListener);

        addCommandToComponent(components,"sldBrightness", new AdjustBrightnessCommand(adjustmentsView,imageView,imageModel));
        addCommandToComponent(components,"APPLY", new ApplyFilterCommand(adjustmentsView, imageView, imageModel));
    }

    private void initializeTransformView(ComponentListener componentListener) {
        ArrayList<Component> components = this.transformView.getAllComponents();
        addComponentListener(components, componentListener);

        addCommandToComponent(components,"ROTATE", new RotateCommand(transformView, imageView, imageModel));
        addCommandToComponent(components,"CHANGE SIZE", new ChangeSizeCommand(transformView, imageView, imageModel));
    }

    private void initializeExplorerOpen() {
        FileChooser fileChooser = this.explorerOpen.getFileChooser();

        addApproveCommand(fileChooser,new OpenImageCommand(imageModel, imageView, explorerOpen, explorerOpenModel));
        addCancelCommand(fileChooser, new CloseExplorerCommand(explorerOpenModel, explorerOpen));
    }

    private void initializeExplorerClose() {
        FileChooser fileChooser = this.explorerSave.getFileChooser();

        addApproveCommand(fileChooser, new SaveImageCommand(explorerSave, imageModel, explorerSaveModel));
        addCancelCommand(fileChooser, new CloseExplorerCommand(explorerOpenModel, explorerSave));
    }

    public void addComponentListener(ArrayList<Component> components, EventListener componentListener){
        for(Component c: components){
            c.addEventListener(componentListener);
        }
    }

    public void addCommandToComponent(ArrayList<Component> components, String name,Command command){
        for(Component c: components){
            if(c.getName().equals(name)){
                c.setCommand(command);
            }
        }
    }

    public void addApproveCommand(FileChooser fileChooser, Command command) {
        fileChooser.setApproveCommandCommand(command);
    }

    public void addCancelCommand(FileChooser fileChooser, Command command) {
        fileChooser.setCancelCommand(command);
    }

    class ComponentListener implements ActionListener, ChangeListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Component component = (Component) e.getSource();
            component.onAction();
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            Component component = (Component) e.getSource();
            component.onAction();
        }
    }
}
