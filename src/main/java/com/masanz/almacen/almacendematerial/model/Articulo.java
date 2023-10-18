package com.masanz.almacen.almacendematerial.model;

import java.time.LocalDate;

public class Articulo {

    private String id = "";
    private ETipoArticulo tipo;
    private int espacio;
    private LocalDate fechaAdquisicion;
    private double precio;

    public Articulo(){

    }

    public Articulo(String id){

    }

    public Articulo(String id, ETipoArticulo tipo, int espacio, LocalDate fechaAdquisicion, double precio){

    }

    public boolean equals(Object object){
        return false;
    }

    public int hashCode(){
        return 0;
    }

    public String toString(){
        return null;
    }

    public String getId(){
        return null;
    }

    public void setId(String id){

    }

    public ETipoArticulo getTipo(){
        return null;
    }

    public void setTipo(ETipoArticulo tipo){

    }

    public int getEspacio(){
        return 0;
    }

    public void setEspacio(int espacio){

    }

    public LocalDate getFechaAdquisicion(){
        return null;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion){

    }

    public double getPrecio(){
        return 0;
    }

    public void setPrecio(double precio){

    }
}
