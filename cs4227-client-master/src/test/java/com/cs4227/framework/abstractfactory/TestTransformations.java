package com.cs4227.framework.abstractfactory;

import com.cs4227.framework.filters.FilterFactory;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class TestTransformations {

    private static BufferedImage testImage;
    private ImageIcon icon;
    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/filterTest.jpg";
    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    @Before
    public void setup(){
        icon = new ImageIcon();
        try {
            testImage = ImageIO.read(new File(TEST_IMAGE_DIRECTORY));
        } catch (IOException e) {
            System.out.println(IO_ERROR + TEST_IMAGE_DIRECTORY + "\n" + e);
        } catch (Exception e) {
            System.out.println(UNKNOWN_ERROR + TEST_IMAGE_DIRECTORY + "\n" + e);
        }
    }

    @Test
    public void testClockwise45Rotation() {
        AbstractRotateFactory factory = FactoryProducer.getFactory("Clockwise");
        Rotate45 rotater = factory.createRotater45();
        testImage = rotater.rotate(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Clockwise 45 filter applied correctly?",
                "Clockwise 45", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void testClockwise90Rotation() {
        AbstractRotateFactory factory = FactoryProducer.getFactory("Clockwise");
        Rotate90 rotater = factory.createRotater90();
        testImage = rotater.rotate(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Clockwise 90 filter applied correctly?",
                "Clockwise 90", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void testAntiClockwise45Rotation() {
        AbstractRotateFactory factory = FactoryProducer.getFactory("Anti-Clockwise");
        Rotate45 rotater = factory.createRotater45();
        testImage = rotater.rotate(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Anti-Clockwise 45 filter applied correctly?",
                "Anti=Clockwise 45", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void testAntiClockwise90Rotation() {
        AbstractRotateFactory factory = FactoryProducer.getFactory("Anti-Clockwise");
        Rotate90 rotater = factory.createRotater90();
        testImage = rotater.rotate(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Anti-Clockwise 90 filter applied correctly?",
                "Anti-Clockwise 90", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

}
