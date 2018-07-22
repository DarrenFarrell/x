package com.cs4227.framework.filehandler;

import org.apache.log4j.Logger;

public class FileLoggingInterceptor implements BaseFileHandlerInterceptor {

    private Logger logger = Logger.getLogger(FileLoggingInterceptor.class);

    @Override
    public void executePreRequest(PreFileHandlerContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Executing method " + context.getMethod() + " to obtain image from directory: "
                + context.getDirectory());
        logger.info(logInfo);
    }

    @Override
    public void executePostRequest(PostFileHandlerContext context) {
        StringBuilder logInfo = new StringBuilder();
        logInfo.append("Method " + context.getMethod() + " execution outcome: ");
        logInfo.append(context.getOutcomeContext().getStateMessage());
        logInfo.append(" Time spent: " + context.getOverallTime() / 1000000000.0);
        logger.info(logInfo);
    }

}
