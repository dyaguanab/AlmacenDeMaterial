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
        sb.append("-              L i s t a d o s       ( A M I )             -\n");
        sb.append("------------------------------------------------------------\n");
        sb.append("     1. Articulos por tipo y precio\n");
        sb.append("     2. Articulos por tipo y fecha\n");
        sb.append("     3. Importar articulos por tipo\n");
        sb.append("     0. Terminar\n");
        sb.append("------------------------------------------------------------\n");
        sb.append("Opcion [0-3]: ");

        do {
            do {
                String impresion = sb.toString();

                System.out.println(impresion);
                dato = scanner.nextInt();

                if (dato < 0 || dato > 3) {
                    System.out.println("Error. Opción no valida, intentelo otra vez.");
                }
            } while (dato < 0 || dato > 3);

            if (dato == 0){
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
     * Se crea un scanner y una variable de tipo String que guardará lo introducido a través del scanner
     * creamos un map de EtipoArticulo y una lista de tipo articulo, se hace un if establecer el orden
     * de los articulos de tipo precio
     * se hace 2 for anidados en el que el interior es para dibujar los articulos  sobre la lista creada
     */
    public void articulosPorTipoPrecio(){
            Scanner scanner = new Scanner(System.in);
            String orden="";
            System.out.println("Por defecto orden Ascendente A u orden Descendente D: ");
            orden=scanner.nextLine();
            Map<ETipoArticulo, List<Articulo>> ml;

            if (orden.equals("A") || orden.equals("D")){
                ml= gestorAlmacen.articulosPorTipoPrecio(orden.equals("A") ? EOrden.ASCENDENTE : EOrden.DESCENDENTE);
            }else {
                ml= gestorAlmacen.articulosPorTipoPrecio(EOrden.ASCENDENTE);
            }
            for (ETipoArticulo tipo: ml.keySet()){
                List<Articulo> list= ml.get(tipo);
                System.out.println(tipo.toString());
                for (int i = 0; i < list.size(); i++) {
                    Articulo a = list.get(i);
                    StringBuilder sb= new StringBuilder();//empezar a diseñar
                    sb.append("                 ");
                    sb.append(a.getId());
                    sb.append("     ");
                    sb.append(a.getFechaAdquisicion());
                    sb.append("         ");
                    sb.append(a.getPrecio());

                    String impresion= sb.toString();
                    System.out.println(impresion);
                }
            }
    }


    /**
     * Se crea un scanner y una variable de tipo String que guardará lo introducido a través del scanner
     * creamos un map de EtipoArticulo y una lista de tipo articulo, se hace un if establecer el orden
     * de los articulos de tipo fecha
     * se hace 2 for anidados en el que el interior es para dibujar los articulos  sobre la lista creada
     */
    public void articulosPorTipoFecha(){
        Scanner scanner = new Scanner(System.in);
        String orden="";
        System.out.println("Por defecto orden Ascendente A u orden Descendente D: ");
        orden=scanner.nextLine();
        Map<ETipoArticulo, List<Articulo>> ml;

        if (orden=="A" || orden=="D"){
            ml= gestorAlmacen.articulosPorTipoFecha(EOrden.DESCENDENTE);
        }else {
            ml= gestorAlmacen.articulosPorTipoFecha(EOrden.ASCENDENTE);
        }
        for (ETipoArticulo tipo: ml.keySet()){
            List<Articulo> list= ml.get(tipo);
            System.out.println(tipo.toString());
            for (int i = 0; i < list.size(); i++) {
                Articulo a = list.get(i);
                StringBuilder sb= new StringBuilder();
                sb.append("                 ");
                sb.append(a.getId());
                sb.append("     ");
                sb.append(a.getFechaAdquisicion());
                sb.append("         ");
                sb.append(a.getPrecio());

                String impresion= sb.toString();
                System.out.println(impresion);
            }
        }
    }

    /**
     * Se hace StringBuilder para dibujar el esquema. Se hace una lista en la que por cada tipo
     * se busca su precio y se va sumando en una variable en la que al final en otra variable se
     * suma el total de todos los precio tipos
     */
    public void importePorTipos(){
        StringBuilder sb= new StringBuilder("");


        Map<ETipoArticulo, List<Articulo>> tipo=gestorAlmacen.articulosPorTipoFecha(EOrden.ASCENDENTE);
        double sumaPrecioTipos= 0.0;
        double totalPrecioTipos= 0.0;

        List<Articulo> lista= tipo.get(ETipoArticulo.MONITOR);
        for (int i = 0; i < lista.size(); i++) {
            sumaPrecioTipos += lista.get(i).getPrecio();
        }
        totalPrecioTipos+=sumaPrecioTipos;
        sb.append(ETipoArticulo.MONITOR.toString());
        sb.append("             ");
        sb.append(sumaPrecioTipos);
        sb.append("\n");

        sumaPrecioTipos =0.0;
        lista= tipo.get(ETipoArticulo.FAX);
        for (int i = 0; i < lista.size(); i++) {
            sumaPrecioTipos += lista.get(i).getPrecio();
        }
        totalPrecioTipos+=sumaPrecioTipos;
        sb.append(ETipoArticulo.FAX.toString());
        sb.append("                 ");
        sb.append(sumaPrecioTipos);
        sb.append("\n");

        sumaPrecioTipos =0.0;
        lista= tipo.get(ETipoArticulo.IMPRESORA);
        for (int i = 0; i < lista.size(); i++) {
            sumaPrecioTipos += lista.get(i).getPrecio();
        }
        totalPrecioTipos+=sumaPrecioTipos;
        sb.append(ETipoArticulo.IMPRESORA.toString());
        sb.append("           ");
        sb.append(sumaPrecioTipos);
        sb.append("\n");

        sumaPrecioTipos =0.0;
        lista= tipo.get(ETipoArticulo.SCANNER);
        for (int i = 0; i < lista.size(); i++) {
            sumaPrecioTipos += lista.get(i).getPrecio();
        }
        totalPrecioTipos+=sumaPrecioTipos;
        sb.append(ETipoArticulo.SCANNER.toString());
        sb.append("             ");
        sb.append(sumaPrecioTipos);
        sb.append("\n");

        sumaPrecioTipos =0.0;
        lista= tipo.get(ETipoArticulo.CPU);
        for (int i = 0; i < lista.size(); i++) {
            sumaPrecioTipos += lista.get(i).getPrecio();
        }
        totalPrecioTipos+=sumaPrecioTipos;
        sb.append(ETipoArticulo.CPU.toString());
        sb.append("                 ");
        sb.append(sumaPrecioTipos);
        sb.append("\n");

        sb.append("---------------------------\n");
        sb.append("Total               ");
        sb.append(totalPrecioTipos);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("MONITOR             370,00");
        System.out.println("FAX                 650,00");
        System.out.println("IMPRESORA           800,00");
        System.out.println("SCANNER             500,00");
        System.out.println("CPU                7200,00");
        System.out.println("---------------------------");
        System.out.println("Total              9520,00");
    }
}
