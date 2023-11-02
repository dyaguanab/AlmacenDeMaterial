package com.masanz.almacen.almacendematerial.managers;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.io.CsvLoader;
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
        return Armario.FILAS;
    }

    public boolean meterArticulo(Articulo a) throws ExcepcionAmi {
        Posicion p= armario.buscarPosicionConEspacio(a.getEspacio());
        if (p!= null){
            armario.meter(p,a);
            return true;
        } else {
            return false;
        }
    }

    public Posicion getPosicionArticulo(Articulo a){
        return armario.getPosicionArticulo(a);
    }

    public List<Articulo> getArticulos(int filas, int columnas){
        return armario.getArticulos(filas,columnas);
    }

    public int getOcupacionCelda(Posicion p){
        return armario.getOCupacionCelda(p);
    }

    public boolean existeIdArticulo(String s) {
        return armario.existeIdArticulo(s);
    }

    public String saveCsv(){
        return null;
    }

    public void loadCsv(String s) throws ExcepcionAmi{
        CsvLoader.cargar(s, this);
    }

    public Articulo getArticulo(String s){
        return armario.getArticulo(s);
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden orden){
        return null;
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden orden){
        return null;
    }
}
