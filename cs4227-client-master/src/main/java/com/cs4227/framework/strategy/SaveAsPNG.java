package com.cs4227.framework.strategy;

import com.cs4227.framework.state.StateContext;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveAsPNG implements SaveAsStrategy {

    Logger logger = Logger.getLogger(SaveAsPNG.class);

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file as PNG from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file as PNG from directory:  ";
    private static final String fileExtension = "png";
    private static final String description = "*.png,*.PNG";

    public void save(String destination, BufferedImage image, StateContext context) {
        try {
            ImageIO.write(image, fileExtension, new File(destination));
        } catch (IOException e) {
            context.toggle();
            logger.error(IO_ERROR + destination, e);
        } catch (Exception e) {
            context.toggle();
            logger.error(UNKNOWN_ERROR + destination, e);
        }
    }
}
