package com.cs4227.framework.filehandler;

import java.awt.image.BufferedImage;

public class PostFileHandlerContext extends PostBaseContext {

    private BufferedImage image;

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

}



