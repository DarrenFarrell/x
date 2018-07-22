package com.cs4227.framework.filters;

public class FilterFactory {

    public Filter createFilter(String filterType){
        switch (filterType){
            case "Monochrome":
                Filter monochrome = new Filter(new Monochrome());
                return monochrome;
            case "Red":
                Filter red = new Filter(new RedFilter());
                return red;
            case "Green":
                Filter green = new Filter(new GreenFilter());
                return green;
            case "Blue":
                Filter blue = new Filter(new BlueFilter());
                return blue;
        }
        return null;
    }
}
