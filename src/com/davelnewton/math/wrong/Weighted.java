package com.davelnewton.math.wrong;

public class Weighted<T> {

    private double weight;
    private T object;

    public Weighted(double weight, T object) {
        this.weight = weight;
        this.object = object;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

}
