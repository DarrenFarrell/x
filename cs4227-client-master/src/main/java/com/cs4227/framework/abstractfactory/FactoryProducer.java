package com.cs4227.framework.abstractfactory;

public class FactoryProducer {
    public static AbstractRotateFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("Clockwise")){
            return new FactoryRotateClockwise();

        }else if(choice.equalsIgnoreCase("Anti-Clockwise")){
            return new FactoryRotateAntiClockwise();
        }

        return null;
    }
}
