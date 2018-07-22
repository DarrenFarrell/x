package com.cs4227.framework.filters;

import java.awt.image.BufferedImage;

public class Filter extends AbstractFilter {

    public Filter(FilterAPI filterAPI) {
        super(filterAPI);
    }

    @Override
    public BufferedImage convert(BufferedImage image) {
        return filterAPI.convert(image);
    }
}
