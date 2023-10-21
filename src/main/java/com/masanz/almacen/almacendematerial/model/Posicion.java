package com.masanz.almacen.almacendematerial.model;

import javafx.geometry.Pos;

public class Posicion {
    private static String letras = "ABCDE";
    private char fila;
    private int columna;

//    public Posicion(){
//
//    }

    public Posicion(char letra,int columna){
        fila=letra;
        this.columna=columna;

    }

//    public Posicion(int a, int b){
//
//    }

//    public Posicion(String letras){
//
//    }

    public char getFila(){
        return fila;
    }

    public int getFilaNumber(){
        return letras.indexOf(fila,0);
    }

    public void setFila(char fila){
        this.fila=fila;
    }

    public void setFilaNumber(int filaNumber){
        this.fila=letras.charAt(filaNumber-1);
    }

    public void setFilaColumnaNumbers(int fila,int columna){
        setFilaNumber(fila);
        setColumna(columna);
    }
    public static String getLetras(){
        return letras;
    }

    public int getColumna(){
        return columna;
    }

    public void setColumna(int columna){
        this.columna=columna;
    }

    private int filaToInt(char fila){
        return letras.indexOf(fila,0)+1;
    }

    private char filaToChar(int fila){
        return letras.charAt(fila-1);
    }

    public boolean equals(Object o){
        Posicion p = (Posicion) o;
        return p.fila == fila && p.columna == columna;
    }

    public int hashCode(){
        return filaToInt(fila) * letras.length() + columna;

        /*No hace falta, hay identificadores de java*/
    }

    public String toString(){
        StringBuilder sb= new StringBuilder(fila);
        sb.append(columna);
        return sb.toString();
    }

    public int compareTo(Posicion p){
        return p.hashCode()-hashCode();
    }
}
