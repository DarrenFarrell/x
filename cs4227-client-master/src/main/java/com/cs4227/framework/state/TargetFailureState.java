package com.cs4227.framework.state;

public class TargetFailureState implements BaseDualState {

    private static final String FAILURE_MESSAGE = "Failed. Please check the logs for further information.";

    private BaseDualState successState;

    public void toggle(StateContext context) {
        context.setState(successState);
    }

    public String stateMessage(){
        return FAILURE_MESSAGE;
    }

    public void setAlternateState(BaseDualState state) {
        this.successState = state;
    }
}
