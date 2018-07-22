package com.cs4227.ui.commands;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.Start;
import com.cs4227.ui.views.ImageView;

import java.awt.image.BufferedImage;

public class RedoCommand implements Command {

    public ImageView imageView;

    public RedoCommand(ImageView imageView){
        this.imageView = imageView;
    }
    public void execute() {
        System.out.print("Redo");

        int numberOfSaves = MementoControl.getImageCount();
        int currentIndex = MementoControl.getCurrentPathIndex();
        if ((numberOfSaves - 1) > currentIndex) {
            currentIndex++;
            MementoControl.setCurrentPathIndex(currentIndex);

            BufferedImage imagePath = MementoControl.restoreFromMemento( MementoControl.getMementoFromCaretaker(currentIndex) );
            try {
                imageView.setImage(imagePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
