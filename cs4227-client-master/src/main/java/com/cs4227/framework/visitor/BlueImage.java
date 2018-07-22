package com.cs4227.framework.visitor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlueImage implements Visitable{
    BufferedImage bufferedImage;
    double value;

    BlueImage(BufferedImage bi){
        bufferedImage = bi;
    }

    public double getValue(){

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int num = w * h;
        long sumb = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Color pixel = new Color(bufferedImage.getRGB(x, y));
                sumb += pixel.getBlue();
            }
        }

        value = (int) ( sumb / num );
        return value;
    }

    @Override
    public double accept(Visitor visitor){
        return visitor.visit(this);
    }
}
