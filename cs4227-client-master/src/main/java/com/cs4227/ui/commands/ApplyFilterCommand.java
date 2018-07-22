package com.cs4227.ui.commands;

import com.cs4227.ui.models.ImageModel;
import com.cs4227.ui.views.AdjustmentsView;
import com.cs4227.ui.views.ImageView;

public class ApplyFilterCommand implements Command {

    private AdjustmentsView adjustmentsView;
    private ImageView imageView;
    private ImageModel imageModel;

    public ApplyFilterCommand(AdjustmentsView adjustmentsView, ImageView imageView, ImageModel imageModel) {
        this.adjustmentsView = adjustmentsView;
        this.imageView = imageView;
        this.imageModel = imageModel;
    }

    @Override
    public void execute() {
        imageModel.ApplyFilter(adjustmentsView.getFilterType());
        imageModel.changeImage(imageModel.getImage());
        imageView.setImage(imageModel.getImage());
    }
}
