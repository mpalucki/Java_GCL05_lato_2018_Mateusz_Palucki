package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       while(true) {
           double a, b;

           System.out.println("Wybierz działanie");
           System.out.println("1. dodawanie");
           System.out.println("2. odejmowanie");
           System.out.println("3. mnozenie");
           System.out.println("4. dzielenie");
           System.out.println("5. potegowanie");
           System.out.println("6. pierwiastkowanie");
           System.out.println("7. pole kwadratu");
           System.out.println("8. pole trojkata");
           System.out.println("9. pole kola");
           System.out.println("10. pole prostokata");
           Scanner read = new Scanner(System.in);

           BasicCalculator basic = new BasicCalculator();
           FieldCalculator field = new FieldCalculator();

           int choose = read.nextInt();
           switch (choose) {
               case 1:
                   System.out.println("podaj pierwszy skladnik: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj drugi skladnik: ");
                   b = read.nextInt();
                   System.out.println(basic.calculateSum(a, b));
                   break;

               case 2:

                   System.out.println("podaj pierwszy skladnik: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj drugi skladnik: ");
                   b = read.nextInt();
                   System.out.println(basic.calculateDifference(a, b));
                   break;

               case 3:
                   System.out.println("podaj pierwszy skladnik: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj drugi skladnik: ");
                   b = read.nextInt();
                   System.out.println(basic.calculateMultiplication(a, b));
                   break;

               case 4:
                   System.out.println("podaj dzielnik: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj dzielna: ");
                   b = read.nextInt();
                   try {
                       basic.calculateDivision(a, b);
                   } catch (Exception except) {
                       System.out.println("dzielenie przez zero!");
                   }

               case 5:
                   System.out.println("podaj podstawe: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj wykladnik: ");
                   b = read.nextInt();
                   try {
                       System.out.println(basic.calculatePow(a, b));
                   } catch (Exception except) {
                       System.out.println("iloczyn pusty");
                   }
                   break;

               case 6:
                   System.out.println("podaj liczbe pod pierwiastkiem: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj stopien pierwiastka: ");
                   b = read.nextInt();
                   try {
                       System.out.println(basic.calculateSqrl(a, b));
                   } catch (Exception except) {
                       System.out.println("bledne dane!");
                   }
                   break;

               case 7:
                   System.out.println("podaj bok kwadratu: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   try
                   {
                       System.out.println(field.calculateSqare(a));
                   }
                   catch (Exception except)
                   {
                       System.out.println("bledne dane!");
                   }
                   break;

               case 8:
                   System.out.println("podaj podstawe: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj wysokosc: ");
                   b = read.nextInt();
                   try{
                       System.out.println(field.calculateTriangle(a,b));
                   }
                   catch (Exception except)
                   {
                       System.out.println("bledne dane!");
                   }
                   break;

               case 9:
                   System.out.println("podaj promien kola: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   try
                   {
                       System.out.println(field.calculateCircle(a));
                   }
                   catch (Exception except)
                   {
                       System.out.println("bledne dane!");
                   }
                   break;
               case 10:
                   System.out.println("podaj 1 bok: ");
                   read = new Scanner(System.in);
                   a = read.nextInt();
                   System.out.println("podaj 2 bok: ");
                   b = read.nextInt();
                   try{
                       System.out.println(field.calculateRectlangle(a,b));
                   }
                   catch (Exception except)
                   {
                       System.out.println("bledne dane!");
                   }
                   break;
           }

       }
    }
}
