package com.cs4227.ui.commands;

import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.TransformView;
import com.cs4227.ui.views.ImageView;

public class RotateCommand implements Command {

    private TransformView transformView;
    private ImageView imageView;
    private ImageModel imageModel;

    public RotateCommand(TransformView transformView, ImageView imageView, ImageModel imageModel) {
        this.transformView = transformView;
        this.imageView = imageView;
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        imageModel.ApplyRotate(transformView.getRotateDirection(), transformView.getRotateDegree());
        imageModel.changeImage(imageModel.getImage());
        imageView.setImage(imageModel.getImage());
    }
}