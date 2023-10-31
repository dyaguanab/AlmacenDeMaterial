package com.masanz.almacen.almacendematerial.model;

import javafx.geometry.Pos;

public class Posicion {
    private static String letras = "ABCDE";
    private char fila;
    private int columna;

//    public Posicion(){
//
//    }

    /**
     * Introduce el usuario los valores
     * @param letra damos por entendido que se va a introducir de la 1 a la 5
     * @param columna damos por entendido que se va a introducir de a la 1 a la 4
     */
    public Posicion(char letra,int columna){
        fila=letra;
        this.columna=columna;

    }

    /**
     * @param a es un parámetro que lo guardamos en el atributo fila
     * @param b es un parámetro que lo guardamos en el atributo columna
     *Fila y columna comienza desde 1
     */
    public Posicion(int a, int b){
        this.fila=filaToChar(a);
        this.columna=b;
    }

//    public Posicion(String letras){
//
//    }
    /**
    * @return Devolvemos el valor de fila
    * */
    public char getFila(){
        return fila;
    }

    /**
     * @return Devolvemos el valor en número de la letra
     */
    public int getFilaNumber(){
        return filaToInt(fila);
    }

    /**
     * @param fila se guarda el valor introducido  en el atributo
     */
    public void setFila(char fila){
        this.fila=fila;
    }

    /**
     * @param filaNumber se guarda en fila un caracter especifico de la cadena letras
     */
    public void setFilaNumber(int filaNumber){
        this.fila=letras.charAt(filaNumber-1);
    }

    /**
     * @param fila se utiliza para asignar un valor en setFilaNumber
     * @param columna se utiliza para asignar un valor en setColumna
     */
    public void setFilaColumnaNumbers(int fila,int columna){
        setFilaNumber(fila);
        setColumna(columna);
    }

    /**
     * @return Devuelve la cadena letras
     */
    public static String getLetras(){
        return letras;
    }

    /**
     * @return Devuelve la columna
     */
    public int getColumna(){
        return columna;
    }

    /**
     * @param columna se guarda el valor introducido en el atributo
     */
    public void setColumna(int columna){
        this.columna=columna;
    }

    /**
     * @param fila se convierte en un integer desde un char
     * @return el valor de fila en integer
     */
    private int filaToInt(char fila){
        return letras.indexOf(fila,0)+1;
    }

    /**
     * @param fila se convierte en un char desde un integer
     * @return Devuelve el valor de fila en char
     */
    public static char filaToChar(int fila){
        return letras.charAt(fila-1);
    }

    /**
     * @param o iguala las posiciones
     * @return Devuelve la posicion de fila y columna
     */
    public boolean equals(Object o){
        Posicion p = (Posicion) o;
        return p.fila == fila && p.columna == columna;
    }

    /**
     * @return Devuelve un indentificador
     */
    public int hashCode(){
        return filaToInt(fila) * letras.length() + columna;
    }

    /**
     * @return Muestra la concatenación de la fila con la columna ''
     */
    public String toString(){
        StringBuilder sb= new StringBuilder(fila);
        sb.append(columna);
        return sb.toString();
    }

    /**
     * @param
     * @return
     */
    public int compareTo(Posicion p){
        return p.hashCode()-hashCode();
    }
}
