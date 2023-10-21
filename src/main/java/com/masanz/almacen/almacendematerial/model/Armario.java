package com.masanz.almacen.almacendematerial.model;

import java.util.List;
import java.util.Map;

public class Armario {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 4;
    public static final int ESPACIOS_X_CELDA = 4;

    private Celda[][] celdas = new Celda[FILAS][COLUMNAS];

    public Armario (){

    }

    public int getFilas(){
        return FILAS;
    }

    public int getColumnas(){
        return COLUMNAS;
    }

    public Celda getCelda(int fila,int columa){
        return celdas[fila][columa];
        //REVISAR
    }

    public int getEspacioLibre(Posicion posicion){
        return 0;
    }

    public void meter(Posicion posicion,Articulo articulo){
        return;
    }

    public int getOCupacionCelda(Posicion posicion){
        return 0;
    }

    public List<Articulo> getArticulos(int filas, int columnas){
        return null;
    }

    public Posicion buscarPosicionConEspacio(int posicion) {
        return null;
    }

    public Posicion getPosicionArticulo(Articulo articulo){
        return null;
    }

    public boolean existeIdArticulo(String string) {
        return false;
    }

    public Articulo getArticulo(String string) {
        return null;
    }

    public Map<ETipoArticulo, List <Articulo>> articulosPorTipo(java.util.Comparator<Articulo> comparator, EOrden orden){
        return null;
    }
}
