package com.example.hw3;

import com.example.hw3.customExample.ArithmeticOperations;
import com.example.hw3.tests.AfterTest;
import com.example.hw3.tests.BeforeTest;
import com.example.hw3.tests.Test;

public class ArithmeticOperationsTest {

    private ArithmeticOperations arithmeticOperations;

    @BeforeTest
    void setUp(){
        arithmeticOperations =new ArithmeticOperations(10, 5);

    }

    @Test
    void sumTest(){
        int expected = 15;
        int sum = arithmeticOperations.sum();
        if(sum!=expected){
            throw new IllegalArgumentException();
        }
    }
    @Test
    void divisionTest(){
        int expected = 2;
        int division = arithmeticOperations.division();
        if(division!=expected){
            throw new IllegalArgumentException();
        }
    }
    @Test
    void multiplicationTest(){
        int expected = 50;
        int multiplication = arithmeticOperations.multiplication();
        if(multiplication!=expected){
            throw new IllegalArgumentException();
        }
    }
    @Test
    void subtractionTest(){
        int expected = 5;
        int subtraction = arithmeticOperations.subtraction();
        if(subtraction!=expected){
            throw new IllegalArgumentException();
        }
    }

    @AfterTest
    void removeSetUp(){
        arithmeticOperations.bringEverythingToZero();
    }
}
