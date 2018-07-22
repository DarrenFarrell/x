package com.cs4227.framework.visitor;

public interface Visitor {
    public double visit(RedImage redImage);
    public double visit(GreenImage greenImage);
    public double visit(BlueImage blueImage);
    public double visit(AverageImage averageImage);
}
