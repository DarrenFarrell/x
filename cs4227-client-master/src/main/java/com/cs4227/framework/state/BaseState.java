package com.cs4227.framework.state;

public interface BaseState {

    public void toggle(StateContext context);

    public String stateMessage();
}
