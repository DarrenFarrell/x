package com.cs4227.framework.interceptor;

import com.cs4227.framework.filehandler.PreFileHandlerContext;

public class PreFileHandlerContextCreator {

    public PreFileHandlerContext createPreFileHandlerContext(String directory) {
        PreFileHandlerContext context = new PreFileHandlerContext();
        context.setDirectory(directory);
        context.setStartTime(System.nanoTime());
        return context;
    }

}
