package com.cs4227.framework.visitor;

class ImageVisitor implements Visitor {

    public ImageVisitor(){ /*empty*/ }

    @Override
    public double visit(RedImage redImage) {
        return redImage.getValue();
    }

    @Override
    public double visit(GreenImage greenImage) {
        return greenImage.getValue();
    }

    @Override
    public double visit(BlueImage blueImage) {
        return blueImage.getValue();
    }

    @Override
    public double visit(AverageImage averageImage) {
        return averageImage.getValue();
    }
}


