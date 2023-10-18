package com.masanz.almacen.almacendematerial.model;

import java.util.Iterator;
import java.util.List;

public class Celda {

    private int espacio = 0;
    private List<Articulo> lista;
    /*Revisar*/

    public Celda(int espacio){

    }

    public List<Articulo> getLista(){
        return null;
    }

    public void setLista(List<Articulo> lista){

    }

    public void meter(Articulo articulo){

    }

    public int getEspacioLibre(){
        return 0;
    }

    public int getEspacioOcupado(){
        return 0;
    }

    public boolean estaArticulo(Articulo articulo){
        return false;
    }

    public boolean existeIdArticulo(String string){
        return false;
    }

    public Articulo getArticulo(String string){
        return null;
    }

    public Iterator <Articulo> iterator(){
        return null;
    }
}
