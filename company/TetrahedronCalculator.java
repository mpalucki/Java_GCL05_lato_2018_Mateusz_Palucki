package com.company;
import java.util.Scanner;
/**
 * Created by mpalucki on 2018-03-06.
 */
public class TetrahedronCalculator implements Calculator {

    public double calculateBaseArea()
    {
        int a;
        System.out.println("podaj dlugosc boku : ");
        Scanner read = new Scanner(System.in);
        a = read.nextInt();

        //double area = 0.25*a*a*Math.pow(3,2);
        return 0.25*a*a*Math.pow(3,2);
    }
    public double calculateBasePerimeter()
    {
        int a;
        System.out.println("podaj dlugosc boku : ");
        Scanner read = new Scanner(System.in);
        a = read.nextInt();

        return 3*a;
    }
}
