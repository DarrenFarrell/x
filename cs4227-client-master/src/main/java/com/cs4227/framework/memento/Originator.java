package com.cs4227.framework.memento;

import java.awt.image.BufferedImage;

public class Originator {

    private BufferedImage imagePath;

    public void set(BufferedImage savedImagePath){
        System.out.println("From Originator: Current Version of Image\n");
        imagePath = savedImagePath;
    }

    public Memento storeInMemento(){
        System.out.println("From Originator: Saving to memento");
        return new Memento(imagePath);
    }

    // This can be removed but I'll keep it for now in case of a change.
    public BufferedImage restoreFromMemento(Memento memento){
        imagePath = memento.getImagePath();
        System.out.println("From Originator: Restoring Path from memento");
        return imagePath;
    }

}
