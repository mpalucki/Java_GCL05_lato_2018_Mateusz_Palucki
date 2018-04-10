package com.company;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class BasicCalculatorTest {

    private BasicCalculator basic;

    double x,y;
    public BasicCalculatorTest(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{
                {13.0,70.0},
                {-70.0,9.0},
                {112.0,4.0}
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

    @BeforeClass
    public static void beforeClassBasic() throws Exception{
        System.out.println("@BeforeClass");
    }
    @AfterClass
    public static void afterClassBasic() throws Exception{
        System.out.println("@AfterClass");
    }


    @Test
    public void calculateDivision() throws Exception {
        double result = basic.calculateDivision(x,y);
        assertEquals(result,basic.calculateDivision(x,y),0);
    }



    @Test
    public void calculateSum() {
        double result = x+y;
       assertEquals(result,basic.calculateSum(x,y),0);
    }

    @Test
    public void calculateDifference() {
        double result = x-y;
        System.out.println(result);
        assertEquals(result,basic.calculateDifference(x,y),0);
    }

    @Test
    public void calculateMultiplication() {
        assertEquals("3*7=21",21,basic.calculateMultiplication(3,7),0);
        assertEquals("3*(-5)=-15",-15,basic.calculateMultiplication(3,-5),0);
        assertEquals("3*0.0=0",0,basic.calculateMultiplication(3,0),0);
    }


    @Test (expected = IllegalArgumentException.class)
    public void calculateDivisionWithExcept() throws Exception{
        basic.calculateDivision(12,0);
    }

    @Test
    public void calculatePow() throws Exception {
        assertEquals("8^2 = 36",64, basic.calculatePow(8,2),0);
        assertEquals("2^4 = 16",16, basic.calculatePow(2,4),0);
        assertEquals("2^-2 = 0.25",0.25, basic.calculatePow(2,-2),0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculatePowException() throws Exception
    {
        basic.calculatePow(0,0);
    }

    @Test
    public void calculateSqrl() throws Exception {
        assertEquals("pierwiastek st. 2 z 9",3,basic.calculateSqrl(9,2),0);
        assertEquals("pierwiastek st. 3 z 8",2,basic.calculateSqrl(8,3),0);
        assertEquals("pierwiastek st. 2 z 36",6,basic.calculateSqrl(36,2),0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateSqrlException() throws Exception {
        basic.calculateSqrl(-12,3);
    }
}