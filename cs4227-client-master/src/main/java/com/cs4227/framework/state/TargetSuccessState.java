package com.cs4227.framework.state;

public class TargetSuccessState implements BaseDualState {

    private static final String SUCCESS_MESSAGE = "Success.";

    private BaseDualState failureState;

    public void toggle(StateContext context) {
        context.setState(failureState);
    }

    public String stateMessage(){
        return SUCCESS_MESSAGE;
    }

    public void setAlternateState(BaseDualState state) {
        this.failureState = state;
    }

}
