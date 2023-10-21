package com.masanz.almacen.almacendematerial.model;

import java.util.Iterator;
import java.util.List;

public class Celda {

    private int espacio = 0;
    private List<Articulo> lista;

    public Celda(int espacio){
        this.espacio = espacio;
    }

    public List<Articulo> getLista(){
        return lista;
    }

    public void setLista(List<Articulo> lista){
        this.lista=lista;
    }

    public void meter(Articulo a){
        //TODO
    }

    public int getEspacioLibre(){
        return 0;
    }

    public int getEspacioOcupado(){
        return 0;
    }

    public boolean estaArticulo(Articulo a){
        //TODO
        return false;
    }

    public boolean existeIdArticulo(String string){
        //TODO
        return false;
    }

    public Articulo getArticulo(String string){
        //TODO
        return null;
    }

    public Iterator <Articulo> iterator(){
        return null;
    }
}
