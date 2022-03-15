package org.example;

public class Student {

    @MyCache
    public double study() {
        return Math.random();
    }

}
