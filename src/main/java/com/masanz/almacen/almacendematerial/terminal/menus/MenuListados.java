package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;

import java.util.Scanner;

public class MenuListados {

    private GestorAlmacen gestorAlmacen;

    public MenuListados(GestorAlmacen gestorAlmacen){
        this.gestorAlmacen=gestorAlmacen;
    }

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

    public void articulosPorTipoPrecio(){

    }

    public void articulosPorTipoFecha(){

    }

    public void importePorTipos(){

    }

    public static void main(String[] args) {

    }
}
