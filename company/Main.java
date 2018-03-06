package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wybierz działanie");
        System.out.println("1. obwod podstawy stozka");
        System.out.println("2. pole podstawy stożka");
        System.out.println("3. obwod podstawy czworoscianu foremnego");
        System.out.println("4. pole podstawy czworoscianu foremnego");
        System.out.println("5. pole czworoscianu foremnego");
        System.out.println("6. objetosc czworoscianu foremnego");
        System.out.println("7. pole stożka");
        System.out.println("8. objetosc stożka");
        Scanner read = new Scanner(System.in);

        ConeCalculator calc = new ConeCalculator();
        TetrahedronCalculator calctet = new TetrahedronCalculator();

        ExtendedCalculator ex_calc_cone = new ExtendedConeCalculator();
        ExtendedCalculator ex_calc_tet = new ExtendedConeCalculator();

        int choose = read.nextInt();

        switch (choose) {
            case 1:
                System.out.println(calc.calculateBaseArea());
                break;
            case 2:
                System.out.println(calc.calculateBasePerimeter());
            case 3:
                System.out.println(calctet.calculateBaseArea());
            case 4:
                System.out.println(calctet.calculateBasePerimeter());
            case 5:
                try{
                    ex_calc_cone.calculateArea();
                }
                catch(Exception except)
                {
                    System.out.println("Błąd!");
                }
            case 6:
                try {
                    ex_calc_cone.calculateVolume();
                }
                catch(Exception except)
                {
                    System.out.println("Błąd!");
                }
            case 7:
                try {
                    ex_calc_tet.calculateVolume();
                }
                catch(Exception except)
                {
                    System.out.println("Błąd!");
                }
            case 8:
                try{
                    ex_calc_tet.calculateVolume();
                }
                catch(Exception except)
                {
                    System.out.println("Błąd!");
                }

        }


    }
}
