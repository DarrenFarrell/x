package com.cs4227.framework.strategy;

import com.cs4227.framework.state.StateContext;
import org.apache.log4j.Logger;

import javax.swing.filechooser.FileFilter;
import java.awt.image.BufferedImage;
import java.io.File;

public class SaveAsOther implements SaveAsStrategy {

    private static final String FILE_TYPE_ERROR = "An incompatible file type was chosen. Cannot save file to directory: ";
    private static final String DESCRIPTION = "Other";

    Logger logger = Logger.getLogger(SaveAsOther.class);


    public String getDescription()
    {
        return DESCRIPTION;
    }

    public void save(String destination, BufferedImage image, StateContext context){
        logger.error(FILE_TYPE_ERROR + destination);
        context.toggle();
    }
}
