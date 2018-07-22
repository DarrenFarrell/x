package com.cs4227.framework.filehandler;

import java.util.ArrayList;

public class FileHandlerDispatcher {

    private BaseFileHandlerTarget target;

    ArrayList<BaseFileHandlerInterceptor> baseInterceptors;

    public FileHandlerDispatcher() {
        baseInterceptors = new ArrayList<>();
    }

    synchronized public void registerInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.add(i);
    }

    synchronized public void removeInterceptor(BaseFileHandlerInterceptor i) {
        baseInterceptors.remove(i);
    }

    public PostFileHandlerContext executeFileHandlerRequest(PreFileHandlerContext context) {
        dispatchFileHandlerInterceptorPreRequest(context);
        PostFileHandlerContext postRequestContext = executeTarget(context);
        dispatchFileHandlerInterceptorPostRequest(postRequestContext);
        return postRequestContext;
    }

    private void dispatchFileHandlerInterceptorPreRequest(PreFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).executePreRequest(context);
        }
    }

    private void dispatchFileHandlerInterceptorPostRequest(PostFileHandlerContext context) {
        for (int i = 0; i < baseInterceptors.size(); i++) {
            baseInterceptors.get(i).executePostRequest(context);
        }
    }

    public void setTarget(BaseFileHandlerTarget target) {
        this.target = target;
    }

    public PostFileHandlerContext executeTarget(PreFileHandlerContext context) {
        return target.execute(context);
    }
}
