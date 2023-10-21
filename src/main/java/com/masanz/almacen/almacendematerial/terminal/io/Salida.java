package com.masanz.almacen.almacendematerial.terminal.io;

import com.masanz.almacen.almacendematerial.model.Armario;
import com.masanz.almacen.almacendematerial.model.Articulo;
import com.masanz.almacen.almacendematerial.model.ETipoArticulo;

import java.util.List;
import java.util.Map;

public class Salida {

    public static void menuPrincipal(){

    }

    public static void menuListados(){

    }

    public static void mostrarOpciones(String[] s){}


    public static void mostrarError(){}

    public static void mostrarMensaje(String string){}

    public static void mostrarArticulo(Articulo articulo, String string){}

    public static void mostrarArticulosCelda(Articulo[] articulos, int articulo){}

    public static void tablaArmario(Armario armario){}

    private static String getArticuloEnUnaLinea(Articulo articulo){
        return null;
    }

    public static void mostrarArticulosTipo(Map<ETipoArticulo, List<Articulo>> articulo){}


    public static void mostrarImporteTipos(Map<ETipoArticulo, Double> precio){}

    public static void main(String[] args) {

    }
}
