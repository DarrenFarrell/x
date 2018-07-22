package com.cs4227.framework.filehandler;

import com.cs4227.framework.state.StateContext;
import com.cs4227.framework.state.TargetFailureState;
import com.cs4227.framework.state.TargetSuccessState;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileReaderTarget implements BaseFileHandlerTarget {

    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to read the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to read the file from directory:  ";

    private StateContext outcomeContext;
    private TargetSuccessState successState;
    private TargetFailureState failureState;
    private Logger logger = Logger.getLogger(FileReaderTarget.class);

    public FileReaderTarget() {
        outcomeContext = new StateContext();
        successState = new TargetSuccessState();
        failureState = new TargetFailureState();
        successState.setAlternateState(failureState);
    }

    @Override
    public PostFileHandlerContext execute(PreFileHandlerContext context) {
        outcomeContext.setState(successState);
        PostFileHandlerContext postRequestContext = createPostRequestContext(context);
        File selectedFile = new File(context.getDirectory());
        try {
            BufferedImage selectedImage = ImageIO.read(selectedFile);
            postRequestContext.setImage(selectedImage);
        } catch (IOException e) {
            outcomeContext.toggle();
            postRequestContext.setImage(null);
            logger.error(IO_ERROR + context.getDirectory(), e);
        } catch (Exception e) {
            outcomeContext.toggle();
            postRequestContext.setImage(null);
            logger.error(UNKNOWN_ERROR + context.getDirectory(), e);
        }
        postRequestContext.setOutcomeContext(outcomeContext);
        postRequestContext.setOverallTime(System.nanoTime() - context.getStartTime());
        return postRequestContext;
    }

    private PostFileHandlerContext createPostRequestContext(PreFileHandlerContext context) {
        PostFileHandlerContext postRequestContext = new PostFileHandlerContext();
        postRequestContext.setMethod(context.getMethod());
        return postRequestContext;
    }
}
