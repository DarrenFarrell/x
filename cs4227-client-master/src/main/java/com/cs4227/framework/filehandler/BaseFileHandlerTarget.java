package com.cs4227.framework.filehandler;

public interface BaseFileHandlerTarget {

    public PostFileHandlerContext execute(PreFileHandlerContext context);
}
