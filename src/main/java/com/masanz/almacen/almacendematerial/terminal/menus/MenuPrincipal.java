package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.Armario;
import com.masanz.almacen.almacendematerial.model.Celda;
import com.masanz.almacen.almacendematerial.model.ETipoArticulo;
import com.masanz.almacen.almacendematerial.model.Posicion;

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
                    /*Llamar a clase anterior*/
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

    private void meterArticulo(){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Id del articulo (7 caracteres), ej. MON0001: ");
        String id = scanner.nextLine();
        System.out.print("\n"+ETipoArticulo.values());
        System.out.print("Tipo de articulo: ");
        String tipo= scanner.nextLine();
        System.out.print("\n" + "Espacio que ocupa, ej.1 [1-4]");
        String espacio= scanner.nextLine();
        espacio=scanner.nextLine();
        String fecha= scanner.nextLine();
        sb.append("Fecha de adquisición (aaaa-mm-dd), ej. 2021-06-05");
        lectura=scanner.nextLine();

        sb.toString();
    }
    private void consultarArticulo(){

    }

    private void consultarCelda(){

    }

    private void menuListados(){}

    private void grabarEstado(){}

    private void cargarDatos(){}

    public static void main(String[] args) {
        GestorAlmacen gA = new GestorAlmacen();
        MenuPrincipal mp = new MenuPrincipal(gA);
        mp.run();
    }
}
