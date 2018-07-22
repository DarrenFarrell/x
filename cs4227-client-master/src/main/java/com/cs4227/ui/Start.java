package com.cs4227.ui;

import com.cs4227.framework.memento.MementoControl;
import com.cs4227.ui.views.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.InputStream;


public class Start {

    public static void main(String[] args) throws Exception {
        InputStream in = Start.class.getResourceAsStream("/imageDefault.jpg");
        BufferedImage selectedImage = ImageIO.read(in);

        ImageView imageView = new ImageView(selectedImage);
        OptionsView optionsView = new OptionsView();
        AdjustmentsView adjustmentsView = new AdjustmentsView();
        TransformView transformView = new TransformView();

        imageView.setVisible(true);
        optionsView.setVisible(true);
        adjustmentsView.setVisible(true);
        transformView.setVisible(true);

        EditorController editorController = new EditorController(imageView,optionsView,adjustmentsView,transformView);
    }

}
