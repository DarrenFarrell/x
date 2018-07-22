package com.cs4227.framework.memento;

import java.awt.image.BufferedImage;

public class MementoControl {

    // External to prevent getting caught up in the commmands.
    private static int imageCount;
    private static int currentPathNumber;

    private String imagePath;

    public static final Caretaker caretaker = new Caretaker();
    public static final Originator originator = new Originator();

    public static Memento storeInMemento(){
        return originator.storeInMemento();
    }

    public static BufferedImage restoreFromMemento(Memento mem){
        return originator.restoreFromMemento(mem);
    }

    public static void originatorSetImage(BufferedImage image){
        originator.set(image);
    }

    public static Memento getMementoFromCaretaker(int index){
        return caretaker.getMemento(index);
    }

    public static void addMemento(Memento mem){
        caretaker.addMemento(mem);
    }

    public static void setCurrentPathIndex(int NextCountValue) {
        currentPathNumber = NextCountValue;
    }

    public static void setImagePathCount(int NextCountValue) {
        imageCount = NextCountValue;
    }

    public static int getCurrentPathIndex() {
        return currentPathNumber;
    }

    public static int getImageCount(){
        return imageCount;
    }

}
