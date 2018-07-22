package com.cs4227.framework.visitor;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AverageImage implements Visitable {
    BufferedImage bufferedImage;
    double value;

    AverageImage(BufferedImage bi){
       bufferedImage = bi;
    }

    public double getValue(){
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int num = w * h;

        long sumr = 0, sumg = 0, sumb = 0;

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {

                Color pixel = new Color(bufferedImage.getRGB(x, y));
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();

            }
        }

        // Average Colour is here if needed.
        // Color averageColor = new Color(sumr / num, sumg / num, sumb / num);

        // Honestly I don't know what the point to getting this grey colour is.
        value = (int) ( ((sumr / num ) + (sumg / num ) + ( sumb / num )) / 3);
        return value;
    }

    @Override
    public double accept(Visitor visitor){
        return visitor.visit(this);
    }

}
