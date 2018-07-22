package com.cs4227.ui.commands;

import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.AdjustmentsView;
import com.cs4227.ui.views.ImageView;

public class AdjustBrightnessCommand implements Command {
    private AdjustmentsView adjustmentsView;
    private ImageView imageView;
    private ImageModel imageModel;

    public AdjustBrightnessCommand(AdjustmentsView adjustmentsView, ImageView imageView, ImageModel imageModel){
        this.adjustmentsView = adjustmentsView;
        this.imageView = imageView;
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        int brightnessValue = adjustmentsView.getBrightnessValue();
        imageModel.adjustImageBrightness(brightnessValue);
        imageModel.changeImage(imageModel.getImage());
        imageView.setImage(imageModel.getImage());
    }
}
