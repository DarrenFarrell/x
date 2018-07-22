package com.cs4227.framework.abstractfactory;

public class FactoryRotateAntiClockwise extends AbstractRotateFactory {

    @Override
    public Rotate45 createRotater45() {
        return new RotateAntiClockwise45();
    }

    @Override
    public Rotate90 createRotater90() {
        return new RotateAntiClockwise90();
    }
}
