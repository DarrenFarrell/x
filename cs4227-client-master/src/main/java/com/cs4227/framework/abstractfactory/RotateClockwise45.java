package com.cs4227.framework.abstractfactory;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class RotateClockwise45 implements Rotate45 {
    @Override
    public BufferedImage rotate(BufferedImage imgOld) {
        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(45), (int)(imgOld.getWidth()/2), (int)(imgOld.getHeight()/2));       //initialize and configure transformation
        BufferedImage imgNew = new BufferedImage(imgOld.getWidth(), imgOld.getHeight(), imgOld.getType());                                          //create new bufferedimage with the properties of the image to rotate
        Graphics2D g = (Graphics2D) imgNew.getGraphics();                                                                                           //create Graphics
        g.setTransform(at);                                                                                                                         //apply transformation
        g.drawImage(imgOld, 0, 0, null);                                                                                                            //draw rotated image
        g.dispose();
        imgOld.flush();
        return imgNew;
    }
}
