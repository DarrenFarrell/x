package com.cs4227.framework.filters;

import java.awt.image.BufferedImage;

public abstract class AbstractFilter {
    protected FilterAPI filterAPI;

    protected AbstractFilter(FilterAPI drawAPI){
        this.filterAPI = drawAPI;
    }
    public abstract BufferedImage convert(BufferedImage image);
}
