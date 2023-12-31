package com.masanz.almacen.almacendematerial.terminal.io;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.Armario;
import com.masanz.almacen.almacendematerial.model.Articulo;
import com.masanz.almacen.almacendematerial.model.ETipoArticulo;
import com.masanz.almacen.almacendematerial.terminal.menus.MenuListados;
import com.masanz.almacen.almacendematerial.terminal.menus.MenuPrincipal;

import java.util.List;
import java.util.Map;

public class Salida {

    /**
     * Se inicia el menu principal
     */
    public static void menuPrincipal(){
        GestorAlmacen gA= new GestorAlmacen();
        MenuPrincipal mp= new MenuPrincipal(gA);
        mp.run();
    }

    /**
     * Se inicia el menu listados
     */
    public static void menuListados(){
        GestorAlmacen gA= new GestorAlmacen();
        MenuListados mL = new MenuListados(gA);
        mL.run();
    }

    /** Estos metodos a la final serían hacer para dividir el contenido de los metodos y que no se vea un método grande.
     * Divide y vencerás. Se pueden usar o no.
    public static void mostrarOpciones(String[] s){}


    public static void mostrarError(){}

    public static void mostrarMensaje(String string){

    }

    public static void mostrarArticulo(Articulo articulo, String string){

    }

    public static void mostrarArticulosCelda(Articulo[] articulos, int articulo){

    }

    public static void tablaArmario(Armario armario){}

    private static String getArticuloEnUnaLinea(Articulo articulo){
        return null;
    }

    public static void mostrarArticulosTipo(Map<ETipoArticulo, List<Articulo>> articulo){

    }


    public static void mostrarImporteTipos(Map<ETipoArticulo, Double> precio){

    }

    public static void main(String[] args) {

    }
     **/
}
