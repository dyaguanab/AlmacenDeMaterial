package com.masanz.almacen.almacendematerial.terminal.io;

import java.util.Scanner;

public class Entrada {
    public static int leerEntero(String entero, int num1, int num2){
        Scanner scanner = new Scanner(System.in);
        int n = -1;

        while (n < num1 || n > num2) {
            System.out.printf("%s [%d-%d]: ", entero, num1, num2);
            n = scanner.nextInt();
        }
        scanner.nextLine();
        return n;
    }

    public static double leerDecimalPositivo(String s){
        Scanner scanner = new Scanner(System.in);
        double d = -1.0;

        while (d < 0) {
            System.out.printf("%s: ", s);
            d = scanner.nextDouble();
        }
        scanner.nextLine();
        return d;
    }

    public static String leerString(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s: ", s);

        String lectura = scanner.nextLine();
        return lectura;
    }

}
