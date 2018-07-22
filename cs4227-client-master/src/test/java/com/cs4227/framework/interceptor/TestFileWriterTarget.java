package com.cs4227.framework.interceptor;

import com.cs4227.framework.filehandler.FileWriterTarget;
import com.cs4227.framework.filehandler.PostFileHandlerContext;
import com.cs4227.framework.filehandler.PreFileHandlerContext;
import com.cs4227.framework.strategy.SaveAsJPG;
import com.cs4227.framework.strategy.SaveAsOther;
import com.cs4227.framework.strategy.SaveAsPNG;
import com.cs4227.framework.strategy.StrategyContext;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestFileWriterTarget {

    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/imageDefault.jpg";
    private static final String SAVE_SUCCESSFUL = "Success.";
    private static final String FAILURE_MESSAGE = "Failed. Please check the logs for further information.";
    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    private FileWriterTarget target;

    private static BufferedImage testImage;

    static {
        try {
            testImage = ImageIO.read(new File(TEST_IMAGE_DIRECTORY));
        } catch (IOException e) {
            System.out.println(IO_ERROR + TEST_IMAGE_DIRECTORY + "\n" + e);
        } catch (Exception e) {
            System.out.println(UNKNOWN_ERROR + TEST_IMAGE_DIRECTORY + "\n" + e);
        }
    }

    @Before
    public void setup() {
        target = new FileWriterTarget();
    }

    @Test
    public void testWriteImageAsJPG() throws Exception {
        PreFileHandlerContextCreator contextCreator = new PreFileHandlerContextCreator();
        PreFileHandlerContext context = contextCreator.createPreFileHandlerContext(TEST_IMAGE_DIRECTORY);
        StrategyContext strategyContext = new StrategyContext();
        SaveAsJPG strategy = new SaveAsJPG();
        strategyContext.setSaveStrategy(strategy);
        context.setStrategyContext(strategyContext);
        context.setImage(testImage);
        PostFileHandlerContext postRequestContext = target.execute(context);
        assertEquals(postRequestContext.getOutcomeContext().getStateMessage(), SAVE_SUCCESSFUL);
    }

    @Test
    public void testWriteImageAsPNG() throws Exception {
        PreFileHandlerContextCreator contextCreator = new PreFileHandlerContextCreator();
        PreFileHandlerContext context = contextCreator.createPreFileHandlerContext(TEST_IMAGE_DIRECTORY);
        StrategyContext strategyContext = new StrategyContext();
        SaveAsPNG strategy = new SaveAsPNG();
        strategyContext.setSaveStrategy(strategy);
        context.setStrategyContext(strategyContext);
        context.setImage(testImage);
        PostFileHandlerContext postRequestContext = target.execute(context);
        assertEquals(postRequestContext.getOutcomeContext().getStateMessage(), SAVE_SUCCESSFUL);
    }

    @Test
    public void testErrorMessageOnOtherFileType() throws Exception {
        PreFileHandlerContextCreator contextCreator = new PreFileHandlerContextCreator();
        PreFileHandlerContext context = contextCreator.createPreFileHandlerContext(TEST_IMAGE_DIRECTORY);
        StrategyContext strategyContext = new StrategyContext();
        SaveAsOther strategy = new SaveAsOther();
        strategyContext.setSaveStrategy(strategy);
        context.setStrategyContext(strategyContext);
        context.setImage(testImage);
        PostFileHandlerContext postRequestContext = target.execute(context);
        assertEquals(postRequestContext.getOutcomeContext().getStateMessage(), FAILURE_MESSAGE);
    }

}