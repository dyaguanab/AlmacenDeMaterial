package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private GestorAlmacen gestorAlmacen;

    public MenuPrincipal(GestorAlmacen gestorAlmacen){
        this.gestorAlmacen = gestorAlmacen;
    }

    private void cargaInicialDatos(){
        /*HACER PRIMERO CSVLOADER*/
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int dato;

        StringBuilder sb = new StringBuilder();
        sb.append("============================================================\n");
        sb.append(" =            Almacén de Material Informático             =\n");
        sb.append("============================================================\n");
        sb.append("    1.Mostrar armario del almacén\n");
        sb.append("    2.Meter articulo en el armario\n");
        sb.append("    3.Consultar articulo\n");
        sb.append("    4.Consultar celda\n");
        sb.append("    5.Listados (menú)\n");
        sb.append("    6.Grabar estado\n");
        sb.append("    7.Cargar datos\n");
        sb.append("    0.Terminar\n");
        sb.append("=============================================================\n");
        sb.append("Opcion [0-7]: ");

        do{
            do{
                String impresion = sb.toString();
                System.out.print(impresion);
                dato = scanner.nextInt();

                if (dato<0 || dato>7){
                    System.out.println("Error. Opción no valida. Intentelo otra vez.");
                }
            }while (dato <0 || dato >7);

                if (dato == 0) {
                    /**/
                } else if (dato == 1) {
                    mostrarArmario();
                } else if (dato == 2) {
                    meterArticulo();
                } else if (dato == 3) {
                    consultarArticulo();
                } else if (dato == 4) {
                    consultarCelda();
                } else if (dato == 5) {
                    menuListados();
                } else if (dato == 6) {
                    grabarEstado();
                } else {
                    cargarDatos();
                }
            }while (dato!=0);

    }

    private void mostrarArmario(){
        Armario a= gestorAlmacen.getArmario();
        StringBuilder sb= new StringBuilder(" ");
        sb.append("  |                    1                   |                    2                   |                    3                   |                    4                   |\n");
        sb.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < a.getFilas(); i++) {
            sb.append(" ");
            sb.append(Posicion.filaToChar(i+1));
            sb.append(" ");
            sb.append("|");
            for (int j = 0; j <a.getColumnas(); j++) {
                Celda c= a.getCelda(i,j);
                sb.append(c.toString());
            }
            sb.append("\n");
            sb.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        }
        String impresion = sb.toString();
        System.out.println(impresion);
    }

    private void meterArticulo() throws ExcepcionAmi {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Id del articulo (7 caracteres), ej. MON0001: ");
        String id = scanner.nextLine();
        System.out.print(ETipoArticulo.values());/*COrregirlo*/
        System.out.print("Tipo de articulo: ");
        String tipo= scanner.nextLine();
        System.out.print("Espacio que ocupa, ej.1 [1-4]: ");
        String espacio= scanner.nextLine();/*EJEMPLO*/
        System.out.print("Fecha de adquisición (aaaa-mm-dd), ej. 2021-06-05: ");
        String fechaAdquisicion= scanner.nextLine();
        System.out.print("Precio de adquisicion, ej. 120.0: ");
        String precio=scanner.nextLine();

        System.out.println("\nArticulo "+ id+ " metido en el armario");
        //todo

        Articulo art = new Articulo(id, ETipoArticulo.valueOf(tipo), Integer.parseInt(espacio), LocalDate.parse(fechaAdquisicion), Double.parseDouble(precio));
        gestorAlmacen.meterArticulo(art);
        /*Hacer comprobaciones con do while*/
    }
    private void consultarArticulo(){
        Scanner scanner= new Scanner(System.in);

        System.out.print("Id del articulo (7 caracteres), ej. IMP0001: ");
        String id= scanner.nextLine();

        Articulo a= gestorAlmacen.getArticulo(id);
        if (a==null){
            System.out.println("Id no encontrado");
        }else{
            System.out.println("\n      Id: "+ id);
            System.out.println("    Tipo: " + a.getTipo().toString());
            System.out.println(" Espacio: " + a.getEspacio());
            System.out.println("   Fecha: " + a.getFechaAdquisicion());
            System.out.println("  Precio: " + a.getPrecio());
            System.out.println("Posicion: " + gestorAlmacen.getPosicionArticulo(a));
        }
        /*comprobar error caracteres*/
        //todo
    }

    private void consultarCelda(){
        Scanner scanner= new Scanner(System.in);
        StringBuilder sb= new StringBuilder("");

        System.out.println("Celda del armario (2 caracteres), ej. A1: ");
        String celda=scanner.nextLine();

        Posicion p =new Posicion(celda);
        List<Articulo> la=gestorAlmacen.getArticulos(p.getFila(), p.getColumna());

        for (int i = 0; i < la.size(); i++) {

        }

        /*sb.append("| ") lo haremos afuera porque es el mismo para todos*/

        for (int i = 0; i < ; i++) {
            Articulo a;


            int espacio= a.getEspacio();
            if (espacio == 1){
                sb.append(a.getId());//7
                sb.append("    |\n");//5

                sb.append(a.getTipo());//7
                sb.append("    |\n");//5

                sb.append(a.getFechaAdquisicion());
                sb.append(" |\n");

                sb.append(a.getPrecio());
                sb.append("      |");
            } else if (espacio == 2) {
                sb.append("       ");
                sb.append(a.getId());
                sb.append("          |\n");

                sb.append("       ");
                sb.append(a.getTipo());
                sb.append("              |\n");

                sb.append("       ");
                sb.append(a.getFechaAdquisicion());
                sb.append("       |\n");

                sb.append("       ");
                sb.append(a.getPrecio());
                sb.append("          |");
            } else if (espacio == 3) {
                sb.append("              ");
                sb.append(a.getId());
                sb.append("                 |\n");

                sb.append("              ");
                sb.append(a.getTipo());
                sb.append("                 |\n");

                sb.append("              ");
                sb.append(a.getFechaAdquisicion());
                sb.append("                 |\n");

                sb.append("              ");
                sb.append(a.getPrecio());
                sb.append("                 |");
            } else if (espacio == 4) {
                sb.append("                     ");
                sb.append(a.getId());
                sb.append("                        \n");

                sb.append("                     ");
                sb.append(a.getTipo());
                sb.append("                        \n");

                sb.append("                     ");
                sb.append(a.getFechaAdquisicion());
                sb.append("                        \n");

                sb.append("                     ");
                sb.append(a.getPrecio());
                sb.append("                        \n");
            }
        }
        System.out.println("-----------------------------------------------------");

        Celda c;
        int espL = c.getEspacioLibre();
        if (espL==1){
            sb.append("");
        } else if (espL==2) {
            sb.append("");
        } else if (espL==3){
            sb.append("");
        } else if (espL==4) {
            sb.append("");
        }
    }        //todo


    private void menuListados(){
        /*mirar si lo que tengo que llamar a la clase u otra cosa*/
    }

    private void grabarEstado(){
        /*Hacer primero csv*/
    }

    private void cargarDatos(){
        /*Hacer primero csv*/
    }

    public static void main(String[] args) {
        GestorAlmacen gA = new GestorAlmacen();
        MenuPrincipal mp = new MenuPrincipal(gA);
        mp.run();
    }
}
