package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


public class BasicCalculator {



    public double calculateSum(double a, double b)
    {
        return a+b;
    }
    public double calculateDifference (double a, double b)
    {
        return a-b;
    }
    public double calculateMultiplication(double multiplicand,double multiplier)
    {
        return multiplicand*multiplier;
    }
    public double calculateDivision(double dividend, double divisor) throws Exception
    {
        if(divisor == 0)
        {
            throw new IllegalArgumentException("dzielenie przez zero!");
        }
        return dividend/divisor;
    }

    public double calculatePow(double base, double index) throws Exception
    {
        if(base ==0 && index == 0)
        {
            throw new IllegalArgumentException("iloczyn pusty");
        }
        else
        {
            return Math.pow(base, index);
        }
    }
    public double calculateSqrl(double number, double root) throws Exception
    {
        if(number <= 0)
        {
            throw new IllegalArgumentException("wartość pod pierwiastkiem dodatnia!");
        }
        return Math.pow(number, 1.0/root);
    }
}
