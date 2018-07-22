package com.cs4227.framework.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monochrome implements FilterAPI {

    BufferedImage  image;
    int width;
    int height;

    public BufferedImage convert(BufferedImage image){
        try {
            this.image = image;
            width = image.getWidth();
            height = image.getHeight();

            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,

                            red+green+blue,red+green+blue);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            return image;

        } catch (Exception e) {}
        return null;
    }
}