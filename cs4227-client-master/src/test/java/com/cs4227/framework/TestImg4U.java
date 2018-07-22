package com.cs4227.framework;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestImg4U {

    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/imageDefault.jpg";
    private static final String SAVE_SUCCESSFUL = "Success.";

    private Img4u framework;

    @Before
    public void setup() {
        framework = new Img4u();
    }

    @Test
    public void testOpenAndSaveImage() throws Exception {
        BufferedImage image = framework.openImage(TEST_IMAGE_DIRECTORY);
        assertTrue(image != null);
        String outcome = framework.saveImage(TEST_IMAGE_DIRECTORY, image);
        assertEquals(SAVE_SUCCESSFUL, outcome);
    }

}
