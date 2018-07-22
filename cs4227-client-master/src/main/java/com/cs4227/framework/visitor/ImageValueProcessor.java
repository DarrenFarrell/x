package com.cs4227.framework.visitor;

import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;

public class ImageValueProcessor {

    private AverageImage averageImage;
    private RedImage redImage;
    private GreenImage greenImage;
    private BlueImage blueImage;
    private ImageVisitor imageVisitor;
    private Logger logger;

    public ImageValueProcessor(BufferedImage image){

        logger = Logger.getLogger(ImageValueProcessor.class);
        imageVisitor = new ImageVisitor();

        averageImage = new AverageImage(image);
        redImage = new RedImage(image);
        greenImage = new GreenImage(image);
        blueImage = new BlueImage(image);

    }

    public void printImageValue() {
        System.out.println(imageValueToString());
    }

    public void logImageValue() {
        logger.info(imageValueToString());
    }

    public String imageValueToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Blue: " + blueImage.accept(imageVisitor));
        builder.append("\nGreen: " + greenImage.accept(imageVisitor));
        builder.append("\nRed: " + redImage.accept(imageVisitor));
        builder.append("\nAverage: " + averageImage.accept(imageVisitor));
        return builder.toString();
    }

    public double getBlue(){
        System.out.println("Blue: " + blueImage.accept(imageVisitor));
        return blueImage.accept(imageVisitor);
    }

    public double getGreen(){
        System.out.println("Green: " + greenImage.accept(imageVisitor));
        return greenImage.accept(imageVisitor);
    }

    public double getRed(){
        System.out.println("Red: " + redImage.accept(imageVisitor));
        return redImage.accept(imageVisitor);
    }

    public double getAverageColour(){
        System.out.println("Average: " + averageImage.accept(imageVisitor));
        return averageImage.accept(imageVisitor);
    }

}
