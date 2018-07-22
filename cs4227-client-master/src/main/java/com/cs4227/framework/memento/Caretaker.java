package com.cs4227.framework.memento;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> savedImageFrames = new ArrayList<>();

    public void addMemento(Memento m){
        savedImageFrames.add(m);
    }

    public Memento getMemento(int index) {
        return savedImageFrames.get(index);
    }

}