package com.cs4227.ui.models;

import com.cs4227.framework.Img4u;
import com.cs4227.framework.memento.MementoControl;
import com.cs4227.framework.visitor.ImageValueProcessor;
import com.cs4227.ui.components.FileChooser;
import com.cs4227.ui.views.ImageView;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

public class ImageModel {

    private BufferedImage image;
    private BufferedImage orginalImage;
    private String alertMessage;
    private Img4u img4u;

    public ImageModel(BufferedImage image){
        this.image = image;
        this.img4u = new Img4u();
    }

    public BufferedImage getImage(){
        return image;
    }

    public void readImage(FileChooser fileChooser) {
        String path = fileChooser.getSelectedFile().getPath();
        this.orginalImage = img4u.openImage(path);
        this.image = deepCopy(orginalImage);
    }

    public void saveImage(String path) {
        this.alertMessage = img4u.saveImage(path, image);
    }

    public void adjustImageBrightness(int brightnessValue) {
        this.image = img4u.adjustImageBrightness(deepCopy(image), brightnessValue);
    }

    public void ApplyFilter(String filterType) {
        this.image = img4u.applyFilter(deepCopy(orginalImage), filterType);
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void ApplyRotate(String rotateDir, String rotateDeg) {
        rotateDeg = rotateDeg.replaceAll("\\D+","");
        this.image = img4u.applyRotate(image, rotateDir, rotateDeg);
    }

    public void changeImage(BufferedImage image){

        MementoControl.originatorSetImage( image );
        MementoControl.addMemento( MementoControl.storeInMemento() );
        MementoControl.setImagePathCount( MementoControl.getImageCount() + 1 );
        MementoControl.setCurrentPathIndex( MementoControl.getCurrentPathIndex() + 1 );

        ImageValueProcessor visitorExample = new ImageValueProcessor(image);
        visitorExample.printImageValue();
        visitorExample.logImageValue();

        this.image = image;
    }

    public void ApplySizeChange(int w, int h) {
        this.image = img4u.applySizeChange(image, w, h);
    }

    public BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
