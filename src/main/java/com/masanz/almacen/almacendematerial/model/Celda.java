package com.masanz.almacen.almacendematerial.model;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Celda {

    private int espacio;
    private List<Articulo> lista;

    public Celda(int espacio){
        this.espacio = espacio;
        this.lista = new LinkedList<>(lista);
    }

    public List<Articulo> getLista(){
        return lista;
    }

    public void setLista(List<Articulo> lista){
        this.lista=lista;
    }

    public void meter(Articulo a) throws ExcepcionAmi{
        if (estaArticulo(a)) {
            throw new ExcepcionAmi("Ya existe el articulo introducido");
        }
        if (a.getEspacio() <= getEspacioLibre()){
            lista.add(a);
        } else {
            throw new ExcepcionAmi("No hay espacio suficiente para meter el articulo");
        }

    }

    public int getEspacioLibre(){
        return espacio-getEspacioOcupado();
    }

    public int getEspacioOcupado(){
        int esp=0;
        for (int i = 0; i < lista.size(); i++) {
            Articulo a = lista.get(i)  ;
            esp += a.getEspacio();
        }
        return esp;
    }

    public boolean estaArticulo(Articulo a){
        if (lista.contains(a)){
            return true;
        } else{
            return false;
        }
    }

    public boolean existeIdArticulo(String s){
        for (int i = 0; i < lista.size(); i++) {
            Articulo a = lista.get(i);
            if(a.getId()==s){
                return true;
            }
        }
        return false;
    }

    public Articulo getArticulo(String s){
        for (int i = 0; i < lista.size(); i++) {
            Articulo a =lista.get(i);
            if (a.getId()==s);
            return a;
        }
        return null;
    }

    public Iterator <Articulo> iterator(){
        return lista.iterator();
    }
}
