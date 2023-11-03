package com.masanz.almacen.almacendematerial.terminal.io;

import java.util.Scanner;

public class Entrada {

    /**
     * @param entero parámetro de tipo String que introduce el usuario
     * @param num1 parámetro que introduce el usuario
     * @param num2 parámetro que introduce el usuario
     * Se crea un scanner para leer datos de entrada y se crea una variable con valor -1 para que entre en condición
     * el while y guardamos en 'n' el valor introducido del scanner
     * @return el valor de 'n'
     */
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

    /**
     * @param s parámetro que introduce el usuario
     * Se crea un escaner para leer los datos de la entrada y se crea una variable tipo double
     * con valor -1 para así entrar en la condición de while. Dentro del bucle se  guarda en la variable
     * 'd' el valor introducido en el escaner
     * @return el valor de 'd'
     */
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

    /**
     * @param s parámetro que introduce el usuario
     * Se crea un escaner de entrada y una variable de tipo String en la que se guarda en el valor introducido
     * en el escaner
     * @return se devuelve el String guardado en lectura
     */
    public static String leerString(String s){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s: ", s);

        String lectura = scanner.nextLine();
        return lectura;
    }

}
