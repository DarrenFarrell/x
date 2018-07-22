package com.cs4227.framework.abstractfactory;

public class FactoryRotateClockwise extends AbstractRotateFactory {

    @Override
    public Rotate45 createRotater45() {
        return new RotateClockwise45();
    }

    @Override
    public Rotate90 createRotater90() {
        return new RotateClockwise90();
    }
}
