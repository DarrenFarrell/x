package com.cs4227.framework.state;

import com.cs4227.framework.filehandler.FileHandlerDispatcherManager;
import com.cs4227.framework.filehandler.FileLoggingInterceptor;
import org.apache.log4j.Logger;

public class LoggingDisableState implements BaseDualState {

    private static final String DISABLED_MESSAGE = "Logging has been disabled.";
    private static final String DISABLED_LOG_MESSAGE = "Logging has been disabled for class: ";

    private FileHandlerDispatcherManager manager;
    private FileLoggingInterceptor interceptor;
    private BaseState enableState;
    private Logger logger = Logger.getLogger(LoggingDisableState.class);

    public LoggingDisableState(FileLoggingInterceptor interceptor, FileHandlerDispatcherManager manager) {
        this.interceptor = interceptor;
        this.manager = manager;
    }

    public void toggle(StateContext context) {
        logger.info(DISABLED_LOG_MESSAGE + context.getCreatorClass());
        manager.removeInterceptor(interceptor);
        context.setState(enableState);
    }

    public void setAlternateState(BaseDualState state) {
        this.enableState = state;
    }

    public String stateMessage() {
        return DISABLED_MESSAGE;
    }
}
