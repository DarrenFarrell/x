package com.cs4227.framework.state;

public class StateContext {

    private BaseState state;
    private String creatorClass;

    public void toggle() {
        state.toggle(this);
    }

    public StateContext(){
        state = null;
    }

    public void setState(BaseState state){
        this.state = state;
    }

    public BaseState getState(){
        return state;
    }

    public void setCreatorClass(String creatorClass) {
        this.creatorClass = creatorClass;
    }

    public String getCreatorClass() {
        return creatorClass;
    }

    public String getStateMessage() {
        return state.stateMessage();
    }
}
