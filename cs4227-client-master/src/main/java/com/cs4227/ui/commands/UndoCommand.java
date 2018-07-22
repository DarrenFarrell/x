package com.cs4227.ui.commands;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.views.ImageView;

import java.awt.image.BufferedImage;

public class UndoCommand implements Command {

    public ImageView imageView;

    public UndoCommand(ImageView imageView){
        this.imageView = imageView;
    }

    public void execute() {
        System.out.print("Undo");

        int currentImage = MementoControl.getCurrentPathIndex();
        System.out.println(currentImage);
        if (currentImage >= 1) {

            currentImage--;
            MementoControl.setCurrentPathIndex(currentImage);

            BufferedImage imagePath = MementoControl.restoreFromMemento( MementoControl.getMementoFromCaretaker(currentImage) );
            try {
                imageView.setImage(imagePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Previous Pressed.");
        }
    }
}
