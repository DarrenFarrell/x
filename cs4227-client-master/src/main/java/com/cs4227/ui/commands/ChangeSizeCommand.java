package com.cs4227.ui.commands;

import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.TransformView;
import com.cs4227.ui.views.ImageView;

public class ChangeSizeCommand implements Command {

    private TransformView transformView;
    private ImageView imageView;
    private ImageModel imageModel;

    public ChangeSizeCommand(TransformView transformView, ImageView imageView, ImageModel imageModel) {
        this.transformView = transformView;
        this.imageView = imageView;
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        imageModel.ApplySizeChange(transformView.getInputWidth(), transformView.getInputHeight());
        imageModel.changeImage(imageModel.getImage());
        imageView.setImage(imageModel.getImage());
    }
}