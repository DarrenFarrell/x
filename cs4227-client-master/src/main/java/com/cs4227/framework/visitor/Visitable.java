package com.cs4227.framework.visitor;

public interface Visitable {
    public double accept(Visitor visitor);
}
