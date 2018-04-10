package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class FieldCalculatorTest {

    private FieldCalculator field;

    double x,y;
    public FieldCalculatorTest(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {13.0,70.0},
                {30.0,9.0},
                {112.0,4.0}
        };
        return Arrays.asList(data);
    }


    @Before
    public void setUp() throws Exception {
        field = new FieldCalculator();
    }

    @After
    public void tearDown() throws Exception {
        field = null;
    }


    @Test
    public void calculateSqare() throws Exception {
        double result = field.calculateSqare(x);
        assertEquals(result,field.calculateSqare(x),0);
    }



    @Test
    public void calculateRectlangle() throws Exception {
        double result = field.calculateRectlangle(x,y);
        assertEquals(result,field.calculateRectlangle(x,y),0);
    }


    @Test (expected = IllegalArgumentException.class)
    public void calculateSquareExcepiton() throws Exception{

        field.calculateSqare(-12);
    }


    @Test
    public void calculateTriangle() throws Exception{
        assertEquals("podstawa: 4, wysokosc 12",24,field.calculateTriangle(4,12),0);
        assertEquals("podstawa: 6, wysokosc 2",6,field.calculateTriangle(6,2),0);
        assertEquals("podstawa: 100, wysokosc 1",50,field.calculateTriangle(100,1),0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void calculateTriangleExcepiton() throws Exception{

        field.calculateTriangle(-5,-3);
    }

    @Test
    public void calculateCircle() throws Exception {
        assertEquals("promien 1",1*Math.PI,field.calculateCircle(1),0);
        assertEquals("promien 10",100*Math.PI,field.calculateCircle(10),0);
        assertEquals("promien 5",25*Math.PI,field.calculateCircle(5),0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void calculateCircleExcepiton() throws Exception{

        field.calculateCircle(-5);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateRectangleExcepiton() throws Exception{

        field.calculateRectlangle(-5,3);
    }
}