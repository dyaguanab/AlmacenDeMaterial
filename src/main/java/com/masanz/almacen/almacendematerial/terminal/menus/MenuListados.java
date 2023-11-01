package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;

public class MenuListados {

    private GestorAlmacen gestorAlmacen;

    public MenuListados(GestorAlmacen gestorAlmacen){
        this.gestorAlmacen=gestorAlmacen;
    }

    public static void run(){
        StringBuilder sb= new StringBuilder();
        int dato;

        sb.append("------------------------------------------------------------\n");
        sb.append("-              L i s t a d o s       ( A M I )             -");
        sb.append("------------------------------------------------------------\n");
        sb.append("     1. Articulos por tipo y precio");
        sb.append("     2. Articulos por tipo y fecha");
        sb.append("     3. Importar articulos por tipo");
        sb.append("     0. Terminar");
        sb.append("------------------------------------------------------------\n");
        sb.append("Opcion [0-3]: ");

        sb.toString();
    }

    public void articulosPorTipoPrecio(){

    }

    public void articulosPorTipoFecha(){

    }

    public void importePorTipos(){

    }

    public static void main(String[] args) {

    }
}
