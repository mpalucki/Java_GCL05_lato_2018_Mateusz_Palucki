package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BasicCalculatorTestException {

    private BasicCalculator basic;
    double x,y;
    public BasicCalculatorTestException(double x,double y)
    {
        this.x = x;
        this.y = y;

    }
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {13.0,0.0},
                {-340.0,0.0},
                {112.0,0.0}
        };
        return Arrays.asList(data);
    }
    @Before
    public void basicSetUp() throws Exception {
        basic = new BasicCalculator();
    }

    @After
    public void tearDown() throws Exception {
        basic = null;
    }



    @Test (expected = IllegalArgumentException.class)
    public void calculateDivision() throws Exception {
        basic.calculateDivision(x,y);
    }



}
