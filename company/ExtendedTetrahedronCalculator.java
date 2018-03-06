package com.company;
import java.util.Scanner;
/**
 * Created by mpalucki on 2018-03-06.
 */
public class ExtendedTetrahedronCalculator implements ExtendedCalculator{

    public void calculateArea() throws Exception
    {
        int a;
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj dlugosc boku");
        a = odczyt.nextInt();

        System.out.println("pole czworoscianu wynosi : "+(a*a*Math.pow(3,2)) );
    }
    public void calculateVolume() throws Exception
    {
        int a;

        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj dlugosc boku");
        a = odczyt.nextInt();

        System.out.println("objetosc czworoscianu wynosi : "+ ((a*a*a*Math.pow(3,2))/12.0 ));
    }
}
