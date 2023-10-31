package com.masanz.almacen.almacendematerial.managers;

import com.masanz.almacen.almacendematerial.model.*;

import java.util.List;
import java.util.Map;

public class GestorAlmacen {

    private static final int ESPACIOS_CELDA=4;

    private Armario armario;

    public GestorAlmacen(){
        this.armario=new Armario();
    }

    public Armario getArmario(){
        return armario;
    }

    public int getEspaciosCeldas(){
        return ESPACIOS_CELDA;
    }

    public int getFilas(){
        return 0;
        //TODO
    }

    public boolean meterArticulo(Articulo articulo){
        return false;
    }

    public Posicion getPosicionArticulo(Articulo articulo){
        return null;
    }

    public List<Articulo> getArticulos(int filas, int columnas){
        /*DUDA*/
        return null;
    }

    public int getOcupacionCelda(Posicion p){
        return 0;
    }

    public boolean existeIdArticulo(String string) {
        return false;
    }

    public String saveCsv(){
        return null;
    }

    public void loadCsv(String s){

    }

    public Articulo getArticulo(String string){
        return null;
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden orden){
        return null;
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden orden){
        return null;
    }
}
