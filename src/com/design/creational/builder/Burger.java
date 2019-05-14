package com.design.creational.builder;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
