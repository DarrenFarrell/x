package com.cs4227.framework.filehandler;

public class FileHandlerDispatcherManager {

    private FileHandlerDispatcher dispatcher;

    public FileHandlerDispatcherManager() {
        dispatcher = new FileHandlerDispatcher();
    }

    public void addInterceptor(BaseFileHandlerInterceptor interceptor) {
        dispatcher.registerInterceptor(interceptor);
    }

    public void removeInterceptor(BaseFileHandlerInterceptor interceptor) {
        dispatcher.removeInterceptor(interceptor);
    }

    public PostFileHandlerContext executeFileHandlerRequest(PreFileHandlerContext preRequestContext) {
        return dispatcher.executeFileHandlerRequest(preRequestContext);
    }

    public void setTarget(BaseFileHandlerTarget target) {
        dispatcher.setTarget(target);
    }

}
