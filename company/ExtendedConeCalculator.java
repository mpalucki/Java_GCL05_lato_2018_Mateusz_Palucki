package com.company;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class ExtendedConeCalculator implements ExtendedCalculator{

    public void calculateArea() throws Exception
    {
        int r;
        int l;
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj promien podstawy");
        r = odczyt.nextInt();
        if(r<0)
        {
            throw new IllegalArgumentException("wpisano ujemna liczbe!");
        }
        System.out.println("Podaj dlugosc tworzacej");
        l = odczyt.nextInt();
        if (l<0)
        {
            new IllegalArgumentException("wpisano ujemna liczbe!");
        }

        System.out.println("pole wynosi : "+(Math.PI*r*r + Math.PI*r*l) );
    }
    public void calculateVolume() throws Exception
    {
        int r;
        int h;
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj promien podstawy");
        r = odczyt.nextInt();
        if(r<0)
        {
            throw new IllegalArgumentException("wpisano ujemna liczbe!");
        }
        System.out.println("Podaj wysokosc");
        h = odczyt.nextInt();
        if(h<0)
        {
            throw new IllegalArgumentException("wpisano ujemna liczbe!");
        }
        System.out.println("objetosc wynosi : "+ ((Math.PI*r*r*h)/3.0 ));
    }
}
