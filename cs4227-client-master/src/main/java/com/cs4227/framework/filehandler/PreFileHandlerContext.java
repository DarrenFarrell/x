package com.cs4227.framework.filehandler;

import com.cs4227.framework.strategy.StrategyContext;

import java.awt.image.BufferedImage;

public class PreFileHandlerContext extends PreBaseContext {

    private String directory;
    private BufferedImage image;
    private StrategyContext strategyContext;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public StrategyContext getStrategyContext() {
        return strategyContext;
    }

    public void setStrategyContext(StrategyContext strategyContext) {
        this.strategyContext = strategyContext;
    }

}


