package com.cs4227.framework;

import com.cs4227.framework.abstractfactory.FactoryProducer;
import com.cs4227.framework.abstractfactory.Rotate90;
import com.cs4227.framework.abstractfactory.Rotate45;
import com.cs4227.framework.abstractfactory.AbstractRotateFactory;
import com.cs4227.framework.filters.Filter;
import com.cs4227.framework.filters.FilterFactory;
import com.cs4227.framework.filehandler.FileHandlerManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Img4u {

    private FileHandlerManager fileHandlerManager;
    private FilterFactory filterFactory;
    private BrightnessEnhancer brightnessEnhancer;

    public Img4u(){
        this.fileHandlerManager = new FileHandlerManager();
        this.filterFactory = new FilterFactory();
        this.brightnessEnhancer = new BrightnessEnhancer();
    }

    public BufferedImage openImage(String directory){
        return fileHandlerManager.openImage(directory);
    }

    public String saveImage(String directory, BufferedImage image) {
        return fileHandlerManager.saveImage(directory,image);
    }

    public BufferedImage adjustImageBrightness(BufferedImage image, int brightnessValue) {
        System.out.print("Brightness value: " + brightnessValue);
        return brightnessEnhancer.convert(image, brightnessValue);
    }

    public BufferedImage applyFilter(BufferedImage image, String filterType) {
        Filter filter = filterFactory.createFilter(filterType);
        return filter.convert(image);
    }

    public BufferedImage applyRotate(BufferedImage image, String rotateDir, String rotateDeg) {
        AbstractRotateFactory rotateFactory = FactoryProducer.getFactory(rotateDir);
        if(rotateDeg.equals("45")){
            Rotate45 imageRotate = rotateFactory.createRotater45();
            return imageRotate.rotate(image);
        }else{
            Rotate90 imageRotate = rotateFactory.createRotater90();
            return imageRotate.rotate(image);
        }
    }

    public BufferedImage applySizeChange(BufferedImage image, int w, int h) {
        String result = "\nNew Size:\nWidth =  " + w + "\nHeight = " + h;
        System.out.println(result);

        Image tmp = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;

        //return image;//no change to image yet
    }
}
