package com.cs4227.framework.filters;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GreenFilter implements FilterAPI {

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
                    int red = c.getRed();
                    int green = 255;
                    int blue = c.getBlue();
                    Color newColor = new Color(red, green,blue);

                    image.setRGB(j,i,newColor.getRGB());
                }
            }
            return image;
        } catch (Exception e) {e.printStackTrace();}
        return null;
    }
}