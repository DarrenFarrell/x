package com.cs4227.framework.filehandler;

public interface BaseFileHandlerInterceptor {

    public void executePreRequest(PreFileHandlerContext context);

    public void executePostRequest(PostFileHandlerContext context);
}
