package com.cs4227.framework.filehandler;

import com.cs4227.framework.state.StateContext;
import com.cs4227.framework.state.TargetFailureState;
import com.cs4227.framework.state.TargetSuccessState;
import org.apache.log4j.Logger;

public class FileWriterTarget implements BaseFileHandlerTarget {
    
    private static final String UNKNOWN_ERROR = "An unknown error occurred when attempting"
            + "to overwrite the file from directory: ";
    private static final String IO_ERROR = "An I/O-related error occurred when attempting"
            + "to overwrite the file from directory:  ";

    private StateContext outcomeContext;
    private TargetSuccessState successState;
    private TargetFailureState failureState;
    private Logger logger = Logger.getLogger(FileWriterTarget.class);

    public FileWriterTarget() {
        outcomeContext = new StateContext();
        successState = new TargetSuccessState();
        failureState = new TargetFailureState();
        successState.setAlternateState(failureState);
    }

    @Override
    public PostFileHandlerContext execute(PreFileHandlerContext context) {
        outcomeContext.setState(successState);
        context.getStrategyContext().save(context.getDirectory(), context.getImage(), outcomeContext);
        PostFileHandlerContext postRequestContext = createPostRequestContext(context);
        postRequestContext.setOutcomeContext(outcomeContext);
        return postRequestContext;
    }

    private PostFileHandlerContext createPostRequestContext(PreFileHandlerContext context) {
        PostFileHandlerContext postRequestContext = new PostFileHandlerContext();
        postRequestContext.setMethod(context.getMethod());
        return postRequestContext;
    }
}
