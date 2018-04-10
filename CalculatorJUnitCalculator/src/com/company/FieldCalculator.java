package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



public class FieldCalculator {



    public double calculateSqare(double side) throws Exception
    {
        if(side < 0)
        {
            throw new IllegalArgumentException("dlugosc musi być dodatnia!");
        }
        return side*side;
    }
    public double calculateTriangle(double base, double height) throws Exception
    {
        if (base < 0)
        {
            throw new IllegalArgumentException("podstawa musi być dodatnia");
        }
        else if(height < 0)
        {
            throw new IllegalArgumentException("wysokosc musi być dodatnia");
        }
        else if( base < 0 && height <0)
        {
            throw new IllegalArgumentException("zarowno wysokosc jak i podstawa muszą być dodatnie");
        }
        else
        {
            return (base*height)/2;
        }
    }
    public  double calculateCircle(double radius) throws Exception
    {
        if(radius < 0)
        {
            throw  new IllegalArgumentException("promien musi być wiekszy od 0");
        }
        return Math.PI*(radius*radius);
    }
    public double calculateRectlangle(double side_a, double side_b) throws Exception
    {
        if (side_a <= 0)
        {
            throw new IllegalArgumentException("podstawa musi być dodatnia");
        }
        else if(side_b <= 0)
        {
            throw new IllegalArgumentException("wysokosc musi być dodatnia");
        }
        else if( side_a <= 0 && side_b <= 0)
        {
            throw new IllegalArgumentException("zarowno wysokosc jak i podstawa muszą być dodatnie");
        }
        else
        {
            return (side_a*side_b);
        }
    }
}
