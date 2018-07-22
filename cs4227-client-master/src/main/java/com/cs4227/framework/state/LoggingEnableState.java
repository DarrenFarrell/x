package com.cs4227.framework.state;

import com.cs4227.framework.filehandler.FileHandlerDispatcherManager;
import com.cs4227.framework.filehandler.FileLoggingInterceptor;
import org.apache.log4j.Logger;

public class LoggingEnableState implements BaseDualState {

    private static final String ENABLED_MESSAGE = "Logging has been enabled.";
    private static final String ENABLED_LOG_MESSAGE = "Logging has been enabled for class: ";

    private FileHandlerDispatcherManager manager;
    private FileLoggingInterceptor interceptor;
    private BaseState disableState;
    private Logger logger = Logger.getLogger(LoggingEnableState.class);

    public LoggingEnableState(FileLoggingInterceptor interceptor, FileHandlerDispatcherManager manager) {
        this.interceptor = interceptor;
        this.manager = manager;
    }

    public void toggle(StateContext context) {
        logger.info(ENABLED_LOG_MESSAGE + context.getCreatorClass());
        manager.addInterceptor(interceptor);
        context.setState(disableState);
    }

    public void setAlternateState(BaseDualState state) {
        this.disableState = state;
    }

    public String stateMessage() {
        return ENABLED_MESSAGE;
    }
}
