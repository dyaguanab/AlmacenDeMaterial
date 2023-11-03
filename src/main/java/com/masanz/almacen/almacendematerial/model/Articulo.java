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
     * @param o Iguala los articulos
     * @return Devuelve los atributos
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
     * @return Devuelve la información y se muestra al usuario
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

    /**
     * @return Devuelve el id
     */
    public String getId(){
        return id;
    }

    /**
     * @param id Se guarda el valor introducido en el atributo
     */
    public void setId(String id){
        this.id=id;
    }

    /**
     * @return Devuelve el valor de tipo
     */
    public ETipoArticulo getTipo(){
        return tipo;
    }

    /**
     * @param tipo Se guarda el valor introducido en el atributo
     */
    public void setTipo(ETipoArticulo tipo){
        this.tipo=tipo;
    }

    /**
     * @return Devuelve el valor de espacio
     */
    public int getEspacio(){
        return espacio;
    }

    /**
     * @param espacio Establece el valor introducido en el atributo
     */
    public void setEspacio(int espacio){
        this.espacio=espacio;
    }

    /**
     * @return Devuelve el valor de fechaAdquisicion
     */
    public LocalDate getFechaAdquisicion(){
        return fechaAdquisicion;
    }

    /**
     * @param fechaAdquisicion Se guarda el valor introducido en el atributo
     */
    public void setFechaAdquisicion(LocalDate fechaAdquisicion){
        this.fechaAdquisicion=fechaAdquisicion;
    }

    /**
     * @return Se obtiene el valor de precio
     */
    public double getPrecio(){
        return precio;
    }

    /**
     * @param precio Se establece el valor de precio
     */
    public void setPrecio(double precio){
        this.precio=precio;
    }

    /*Prueba para ver que tal*/
    public static void main(String[] args) {
        Articulo articulo1 = new Articulo("2", ETipoArticulo.MONITOR, 2, LocalDate.now(), 999.95);
        System.out.println(articulo1);
    }
}
