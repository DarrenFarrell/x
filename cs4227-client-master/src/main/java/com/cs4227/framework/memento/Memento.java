package com.cs4227.framework.memento;

import java.awt.image.BufferedImage;

public class Memento {

    private BufferedImage imagePath;

    public Memento(BufferedImage savedImagePath) {
        imagePath = savedImagePath;
    }

    public BufferedImage getImagePath() {
        return imagePath;
    }
}
