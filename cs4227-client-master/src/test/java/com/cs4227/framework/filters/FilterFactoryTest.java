package com.cs4227.framework.filters;

import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertTrue;

public class FilterFactoryTest {


    private static BufferedImage testImage;
    private FilterFactory filterFactory;
    private ImageIcon icon;
    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/filterTest.jpg";
    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    @Before
    public void setup(){
        filterFactory = new FilterFactory();
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
    public void createMonochromeFilter(){
        Filter monochromeFilter = filterFactory.createFilter("Monochrome");
        assertThat(monochromeFilter.filterAPI, instanceOf(Monochrome.class));
        monochromeFilter.convert(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Monochrome filter applied correctly?",
                "Monochrome", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void createRedFilter(){
        Filter redFilter = filterFactory.createFilter("Red");
        assertThat(redFilter.filterAPI, instanceOf(RedFilter.class));
        redFilter.convert(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Red filter applied correctly?",
                "Red", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void createBlueFilter(){
        Filter blueFilter = filterFactory.createFilter("Blue");
        assertThat(blueFilter.filterAPI, instanceOf(BlueFilter.class));
        blueFilter.convert(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Blue filter applied correctly?",
                "Blue", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }

    @Test
    public void createGreenFilter(){
        Filter greenFilter = filterFactory.createFilter("Green");
        assertThat(greenFilter.filterAPI, instanceOf(GreenFilter.class));
        greenFilter.convert(testImage);
        icon.setImage(testImage);
        int result = JOptionPane.showConfirmDialog(null,
                "Was the Green filter applied correctly?",
                "Green", JOptionPane.YES_NO_OPTION, 0, icon);
        assertTrue(result == 0);
    }
}
