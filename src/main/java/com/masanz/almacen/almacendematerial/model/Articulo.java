package com.masanz.almacen.almacendematerial.model;

import java.time.LocalDate;

public class Articulo {

    private String id = "";
    private ETipoArticulo tipo;
    private int espacio;
    private LocalDate fechaAdquisicion;
    private double precio;

//    public Articulo(){
//
//    }

//    public Articulo(String id){
//        this.id = id;
//    }



    public boolean equals(Object o){
        Articulo a = (Articulo) o;
        return a.fechaAdquisicion == fechaAdquisicion && a.id == id &&
                a.tipo==tipo && a.espacio==espacio && a.precio==precio;
    }

    public int hashCode(){
        return 0;
        /*Identificadores de JAVA*/
    }

    public String toString(){
        return null;
        //TODO
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
        /*Al declarar los atributos en constructor no haría falta aquí*/
    }

    public ETipoArticulo getTipo(){
        return tipo;
    }

    public void setTipo(ETipoArticulo tipo){
        this.tipo=tipo;
        /**/
    }

    public int getEspacio(){
        return espacio;
    }

    public void setEspacio(int espacio){
        this.espacio=espacio;
        /**/
    }

    public LocalDate getFechaAdquisicion(){
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion){
        this.fechaAdquisicion=fechaAdquisicion;
        /**/
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio=precio;
        /**/
    }
}
