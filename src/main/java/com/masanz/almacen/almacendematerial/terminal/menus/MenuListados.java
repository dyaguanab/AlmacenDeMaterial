package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.Articulo;
import com.masanz.almacen.almacendematerial.model.EOrden;
import com.masanz.almacen.almacendematerial.model.ETipoArticulo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuListados {

    private GestorAlmacen gestorAlmacen;

    /**
     * @param gestorAlmacen se inicializa
     */
    public MenuListados(GestorAlmacen gestorAlmacen){
        this.gestorAlmacen=gestorAlmacen;
    }

    /**
     * Se crea un Scanner y un StringBuilder sb, en el sb se dibuja el menú, después se hace 2 do while anidados, en el que
     * el del interior se guarda en dato el número introducido por el scanner, se hace una condición para que el dato sea una
     * de las opciones que se piden. Cuando una opción valida es elegida llama al método que le corresponde. El while exterior
     * es para mantener en bucle el menú
     */
    public  void run(){
        StringBuilder sb= new StringBuilder();
        Scanner scanner = new Scanner(System.in);
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

        do {
            do {
                dato = scanner.nextInt();
                String impresion = sb.toString();
                System.out.println(impresion);

                if (dato < 0 || dato > 3) {
                    System.out.println("Error. Opción no valida, intentelo otra vez.");
                }
            } while (dato < 0 || dato > 3);

            if (dato == 0){
                /*terminar*/
            } else if (dato == 1) {
                articulosPorTipoPrecio();
            } else if (dato == 2) {
                articulosPorTipoFecha();
            } else if (dato == 3) {
                importePorTipos();
            }
        }while (dato!=0);
    }

    /**
     *
     */
    public void articulosPorTipoPrecio(){
        Scanner scanner = new Scanner(System.in);
        String orden="";
        System.out.println("Por defecto orden Ascendente A u orden Descendente D: ");
        orden=scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> ml;

        if (orden=="D" || orden=="d"){
            ml= gestorAlmacen.articulosPorTipoPrecio(EOrden.DESCENDENTE);
        }else {
            ml= gestorAlmacen.articulosPorTipoPrecio(EOrden.ASCENDENTE);
        }
        for (ETipoArticulo tipo: ml.keySet()){
            List<Articulo> list= ml.get(tipo);
            System.out.println(tipo.toString());
            for (int i = 0; i < list.size(); i++) {
                Articulo a = list.get(i);
                StringBuilder sb= new StringBuilder(tipo.toString());//empezar a diseñar
                sb.append("\n");
                sb.append("                 ");
                sb.append(a.getId());
                sb.append("     ");
                sb.append(a.getFechaAdquisicion());
                sb.append("         ");
                sb.append(a.getPrecio());
            }
        }
    }//mirar si asi sirve para t0do

    /**
     *
     */
    public void articulosPorTipoFecha(){
        Scanner scanner = new Scanner(System.in);
        String orden="";
        System.out.println("Por defecto orden Ascendente A u orden Descendente D: ");
        orden=scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> ml;

        if (orden=="D" || orden=="d"){
            ml= gestorAlmacen.articulosPorTipoFecha(EOrden.DESCENDENTE);
        }else {
            ml= gestorAlmacen.articulosPorTipoFecha(EOrden.ASCENDENTE);
        }
        for (ETipoArticulo tipo: ml.keySet()){
            List<Articulo> list= ml.get(tipo);
            System.out.println(tipo.toString());
            for (int i = 0; i < list.size(); i++) {
                Articulo a = list.get(i);
                StringBuilder sb= new StringBuilder(tipo.toString());//empezar a diseñar
                sb.append("\n");
                sb.append("                 ");
                sb.append(a.getId());
                sb.append("     ");
                sb.append(a.getFechaAdquisicion());
                sb.append("         ");
                sb.append(a.getPrecio());
            }
        }
    }

    public void importePorTipos(){

    }

    public static void main(String[] args) {

    }
}
