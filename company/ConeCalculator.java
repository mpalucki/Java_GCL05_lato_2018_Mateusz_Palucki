package com.company;
import java.util.Scanner;
/**
 * Created by mpalucki on 2018-03-06.
 */
public class ConeCalculator implements  Calculator{

    public double calculateBaseArea()
        {
        int r;

        System.out.println("podaj promien podstawy : ");
        Scanner read = new Scanner(System.in);
        r = read.nextInt();

        double area = r*r*Math.PI;
        return area;
    }


    public double calculateBasePerimeter()
        {
        int r;
        System.out.println("podaj promien podstawy : ");
        Scanner read = new Scanner(System.in);


        r = read.nextInt();

        double baseperimeter = Math.PI*r*r;
        return baseperimeter;
    }


}
