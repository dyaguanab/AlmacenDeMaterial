package com.masanz.almacen.almacendematerial.model;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Armario {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 4;
    public static final int ESPACIOS_X_CELDA = 4;

    private Celda[][] celdas;

    public Armario (){
        this.celdas= new Celda[FILAS][COLUMNAS];
    }

    public int getFilas(){
        return FILAS;
    }

    public int getColumnas(){
        return COLUMNAS;
    }

    public Celda getCelda(int fila,int columna){
        return celdas[fila][columna];
    }

    public int getEspacioLibre(Posicion p){
        return 0;
    }

    public void meter(Posicion p,Articulo a) throws ExcepcionAmi {

    }

    public int getOCupacionCelda(Posicion p){
        return 0;
    }

    public List<Articulo> getArticulos(int fila, int columna){
        return null;
    }

    public Posicion buscarPosicionConEspacio(int espacio) {
        return null;
    }

    public Posicion getPosicionArticulo(Articulo a){
        return null;
    }

    public boolean existeIdArticulo(String s) {
        return false;
    }

    public Articulo getArticulo(String s) {
        return null;
    }

    public Map<ETipoArticulo, List <Articulo>>
    articulosPorTipo(java.util.Comparator<Articulo> comparator, EOrden orden){
        return null;
    }
}
