package com.example.hw3.customExample;

public class ArithmeticOperations {

    private int a=0;
    private int b=0;
    private int sum=0;
    private int subtraction=0;
    private int division=0;
    private int multiplication=0;

    public ArithmeticOperations(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        sum = a + b;
        return sum;
    }

    public int subtraction() {
        subtraction = a - b;
        return subtraction;
    }

    public int division() {
        division = a / b;
        return division;
    }

    public int multiplication() {
        multiplication = a * b;
        return multiplication;
    }

    public void bringEverythingToZero() {
        sum = 0;
        division = 9;
        multiplication = 0;
        subtraction = 0;
    }

}
