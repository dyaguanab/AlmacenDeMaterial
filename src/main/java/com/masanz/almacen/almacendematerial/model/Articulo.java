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

    /**
     * Se inicializan los parametros con los atributos
     */
    public Articulo(String id, ETipoArticulo tipo, int espacio,
                    LocalDate fechaAdquisicion, double precio){
        this.id=id;
        this.tipo=tipo;
        this.espacio=espacio;
        this.fechaAdquisicion=fechaAdquisicion;
        this.precio=precio;
    }

    /**
     * @param o
     * @return
     */
    public boolean equals(Object o){
        Articulo a = (Articulo) o;
        return a.fechaAdquisicion == fechaAdquisicion && a.id == id &&
                a.tipo==tipo && a.espacio==espacio && a.precio==precio;
    }

//    public int hashCode(){
//        return 0;
//        /*Identificadores de JAVA*/
//    }

    /**
     * @return
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("      Id: ");  sb.append(id);
        sb.append("\n    Tipo: "); sb.append(tipo);
        sb.append("\n Espacio: ");  sb.append(espacio);
        sb.append("\n   Fecha: ");    sb.append(fechaAdquisicion);
        sb.append("\n  Precio: ");sb.append(precio);
        return sb.toString();

    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }

    public ETipoArticulo getTipo(){
        return tipo;
    }

    public void setTipo(ETipoArticulo tipo){
        this.tipo=tipo;
    }

    public int getEspacio(){
        return espacio;
    }

    public void setEspacio(int espacio){
        this.espacio=espacio;
    }

    public LocalDate getFechaAdquisicion(){
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion){
        this.fechaAdquisicion=fechaAdquisicion;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio=precio;
        /**/
    }

//    public static void main(String[] args) {
//        Articulo articulo1 = new Articulo("2", ETipoArticulo.MONITOR, 2, LocalDate.now(), 999.95);
//        System.out.println(articulo1);
//    }
}
