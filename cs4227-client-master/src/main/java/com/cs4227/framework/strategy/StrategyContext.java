package com.cs4227.framework.strategy;

import com.cs4227.framework.state.StateContext;

import java.awt.image.BufferedImage;

public class StrategyContext {

    private SaveAsStrategy saveStrategy;

    public SaveAsStrategy getSaveStrategy() {
        return saveStrategy;
    }

    public void setSaveStrategy(SaveAsStrategy saveStrategy) {
        this.saveStrategy = saveStrategy;
    }

    public void save(String destination, BufferedImage image, StateContext context) {
        saveStrategy.save(destination, image, context);
    }

}
