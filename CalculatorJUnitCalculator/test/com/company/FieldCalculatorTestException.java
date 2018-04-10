package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class FieldCalculatorTestException {

    private FieldCalculator field;
    double x,y;

    public FieldCalculatorTestException(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {-13.0,12.0},
                {-340.0,22.0},
                {112.0,-10.0}
        };
        return Arrays.asList(data);
    }
    @Before
    public void fieldSetUp() throws Exception {
        field = new FieldCalculator();
    }

    @After
    public void tearDown() throws Exception {
        field = null;
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateRectangle() throws Exception
    {
        field.calculateRectlangle(x,y);
    }

}