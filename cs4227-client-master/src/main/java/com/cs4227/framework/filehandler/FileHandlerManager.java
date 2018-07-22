package com.cs4227.framework.filehandler;

import com.cs4227.framework.state.LoggingDisableState;
import com.cs4227.framework.state.LoggingEnableState;
import com.cs4227.framework.state.StateContext;
import com.cs4227.framework.strategy.*;

import java.awt.image.BufferedImage;

public class FileHandlerManager {

    private FileHandlerDispatcherManager dispatcherManager;
    private LoggingEnableState loggingEnableState;
    private LoggingDisableState loggingDisableState;
    private StateContext loggingContext;
    private FileLoggingInterceptor loggingInterceptor;
    private FileWriterTarget fileWriterTarget;
    private FileReaderTarget fileReaderTarget;
    private SaveAsJPG jpgStrategy;
    private SaveAsPNG pngStragegy;
    private SaveAsOther otherStrategy;

    public FileHandlerManager() { initialize();
    }

    public BufferedImage openImage(String directory) {
        dispatcherManager.setTarget(fileReaderTarget);
        PreFileHandlerContext preRequestContext = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(preRequestContext);
        return postRequestContext.getImage();
    }

    public String saveImage(String directory, BufferedImage image) {
        dispatcherManager.setTarget(fileWriterTarget);
        PreFileHandlerContext context = createPreFileHandlerContext(directory,
                Thread.currentThread().getStackTrace()[1].getMethodName());
        context.setImage(image);
        StrategyContext strategyContext = new StrategyContext();
        strategyContext.setSaveStrategy(determineSaveStrategy(directory));
        context.setStrategyContext(strategyContext);
        PostFileHandlerContext postRequestContext = dispatcherManager.executeFileHandlerRequest(context);
        return postRequestContext.getOutcomeContext().getStateMessage();
    }

    public void toggleLogging() {
        loggingContext.toggle();
    }

    private void initialize() {
        dispatcherManager = new FileHandlerDispatcherManager();
        fileReaderTarget = new FileReaderTarget();
        fileWriterTarget = new FileWriterTarget();

        pngStragegy = new SaveAsPNG();
        jpgStrategy = new SaveAsJPG();
        otherStrategy = new SaveAsOther();

        loggingContext = new StateContext();
        loggingContext.setCreatorClass(FileHandlerManager.class.toString());
        loggingInterceptor = new FileLoggingInterceptor();
        loggingEnableState = new LoggingEnableState(loggingInterceptor, dispatcherManager);
        loggingDisableState = new LoggingDisableState(loggingInterceptor, dispatcherManager);
        loggingEnableState.setAlternateState(loggingDisableState);
        loggingDisableState.setAlternateState(loggingEnableState);
        //Logging is enabled by default
        loggingContext.setState(loggingEnableState);
        loggingEnableState.toggle(loggingContext);
    }

    private SaveAsStrategy determineSaveStrategy(String directory) {
        SaveAsStrategy strategy = otherStrategy;
        String fileExtension = directory.split("\\.")[1]+"";
        switch (fileExtension.toLowerCase()) {
            case "jpg":
            case "jpeg":
                strategy = jpgStrategy;
            break;
            case "png":
                strategy = pngStragegy;
            break;
        }
        return strategy;
    }

    private PreFileHandlerContext createPreFileHandlerContext(String directory, String method) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setMethod(method);
        context.setStartTime(System.nanoTime());
        return context;
    }
}
