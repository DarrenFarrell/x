package com.cs4227.framework;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class BrightnessEnhancer {
    public BufferedImage convert(BufferedImage image, int brightnessValue) {
        float scaleFactor = 1.0f + (float) brightnessValue/100;
        RescaleOp rescaleOp = new RescaleOp(scaleFactor, 15, null);
        return rescaleOp.filter(image,null);
    }
}
