package com.masanz.almacen.almacendematerial.terminal.menus;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.io.CsvLoader;
import com.masanz.almacen.almacendematerial.io.CsvSaver;
import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private GestorAlmacen gestorAlmacen;

    /**
     * @param gestorAlmacen se inicializa
     */
    public MenuPrincipal(GestorAlmacen gestorAlmacen){
        this.gestorAlmacen = gestorAlmacen;
    }

//    private void cargaInicialDatos(){
//
//    }


    /**
     * Se crea un Scanner y un StringBuilder sb, en el sb se dibuja el menú, después se hace 2 do while anidados, en el que
     * el del interior se guarda en dato el número introducido por el scanner, se hace una condición para que el dato sea una
     * de las opciones que se piden. Cuando una opción valida es elegida llama al método que le corresponde. El while exterior
     * es para mantener en bucle el menú
     */
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

    /**
     * Se muestra el armario haciendo un Stringbuilder en el que se irá añadiendo la información
     * del contenido de este, los espacios vacios y los '|' mediante 2 for
     */
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

    /**
     * Se crea un scanner y se inicializan ciertas variables para que después el usuario
     * introduzca valores en esas variables que serán utilizadas para meter un articulo en el armario
     * en cada una de las variables se ponen ciertas condiciones con try catch para que tenga sentido
     * y sean correctos la información introducida por el usuario
     */
    private void meterArticulo(){
        Scanner scanner= new Scanner(System.in);
        String id="";
        ETipoArticulo tipo=null;
        int espacio=-1;
        LocalDate fechaAdquisicion=null;
        double precio=0;

        do{
            System.out.print("Id del articulo (7 caracteres), ej. MON0001: ");
            id = scanner.nextLine();
            if (id.length()!=7){
                System.out.println("Id del articulo tiene que ser de 7 caracteres, intentelo de nuevo");
            }
        }while (id.length()!=7);

        do {
            System.out.println("MONITOR IMPRESORA CPU FAX SCANNER");/*COrregirlo*/
            System.out.print("Tipo de articulo: ");
            try {
                tipo= ETipoArticulo.valueOf(scanner.nextLine());
            } catch(Exception e){
                System.out.println("Tipo de articulo incorrecto, intentelo de nuevo");
            }
        }while (tipo == null);

        do {
            System.out.print("Espacio que ocupa, ej.1 [1-4]: ");
            try{
                espacio= scanner.nextInt();
                if (espacio<1 || espacio>4) {
                    System.out.println("Espacio introducido no válido, intentelo de nuevo");
                }
            }catch (Exception e){
                System.out.println("Espacio introducido no válido, intentelo de nuevo");
            }

        }while (espacio<1 || espacio>4);

        do {
            System.out.print("Fecha de adquisición (aaaa-mm-dd), ej. 2021-06-05: ");
            try {
                fechaAdquisicion = LocalDate.parse(scanner.next());//revisar
            } catch (Exception e) {
                System.out.println("La fecha introducida no es valida, introuzcala en el formato indicado");
            }

        } while (fechaAdquisicion == null);

        do {
            System.out.print("Precio de adquisicion, ej. 120.0: ");
            try {
                precio=scanner.nextDouble();
                if (precio<0){
                    System.out.println("El precio introducido es negativo, inténtelo de nuevo");
                }
            }catch (Exception e){
                System.out.println("El precio introducido no es válido, inténtelo de nuevo");
            }
        }while (precio <0);

        Articulo art = new Articulo(id, tipo, espacio, fechaAdquisicion, precio);
        try {
            gestorAlmacen.meterArticulo(art);
            System.out.println("\nArticulo "+ id+ " metido en el armario");
        } catch (ExcepcionAmi e) {
            System.out.println("\nArticulo "+ id+ " no se ha podido meter en el armario: " + e.getMessage());
        }//excepción acabada aquí. REVISAR
    }

    /**
     * El usuario con el scanner introduce la id que quiere buscar, esta tiene que cumplir las condiciones
     * luego se busca en los articulos, en la que si es encontrada muestra en pantalla las caracteristcas del articulo
     */
    private void consultarArticulo(){
        Scanner scanner= new Scanner(System.in);
        String id="";

        do{
            System.out.print("Id del articulo (7 caracteres), ej. MON0001: ");
            id = scanner.nextLine();
            if (id.length()!=7){
                System.out.println("Id del articulo tiene que ser de 7 caracteres, intentelo de nuevo");
            }
        }while (id.length()!=7);

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
    }

    /**
     * Muestra la celda introduciendo 2 caracteres de la posicion deseada por el usuario, se muestra con un sb append
     */
    private void consultarCelda() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Celda del armario (2 caracteres), ej. A1: ");
        String celda = scanner.next();

        Posicion p = new Posicion(celda);
        List<Articulo> la = gestorAlmacen.getArticulos(p.getFilaNumber(), p.getColumna());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < la.size(); i++) {
            Articulo a = la.get(i);

            if (a.getEspacio() == 1) {
                sb.append("| " + a.getId() + "    |\n");
            } else if (a.getEspacio() == 2) {
                sb.append("|        " + a.getId() + "        |\n");
            } else if (a.getEspacio() == 3) {
                sb.append("|               " + a.getId() + "               |\n");
            } else if (a.getEspacio() == 4) {
                sb.append("|                      " + a.getId() + "                      |\n");
            }
        }

        for (int i = 0; i < la.size(); i++) {
            Articulo a = la.get(i);

            if (a.getEspacio() == 1) {
                sb.append(String.format("|         %8s           |\n", a.getTipo().toString()));
            } else if (a.getEspacio() == 2) {
                sb.append(String.format("|         %8s                 |\n", a.getTipo().toString()));
            } else if (a.getEspacio() == 3) {
                sb.append(String.format("|         %8s         |\n", a.getTipo().toString()));
            } else if (a.getEspacio() == 4) {
                sb.append(String.format("|         %8s           |\n", a.getTipo().toString()));
            }
        }

        for (int i = 0; i < la.size(); i++) {
            Articulo a = la.get(i);

            if (a.getEspacio() == 1) {
                sb.append("| " + a.getFechaAdquisicion() + "    |\n");
            } else if (a.getEspacio() == 2) {
                sb.append("|        " + a.getFechaAdquisicion() + "        |\n");
            } else if (a.getEspacio() == 3) {
                sb.append("|               " + a.getFechaAdquisicion() + "               |\n");
            } else if (a.getEspacio() == 4) {
                sb.append("|                      " + a.getFechaAdquisicion() + "                      |\n");
            }
        }

        for (int i = 0; i < la.size(); i++) {
            Articulo a = la.get(i);

            if (a.getEspacio() == 1) {
                sb.append(String.format("|         %8s           |\n", a.getPrecio()));
            } else if (a.getEspacio() == 2) {
                sb.append(String.format("|         %8s                 |\n", a.getPrecio()));
            } else if (a.getEspacio() == 3) {
                sb.append(String.format("|         %8s         |\n", a.getPrecio()));
            } else if (a.getEspacio() == 4) {
                sb.append(String.format("|         %8s           |\n", a.getPrecio()));
            }
        }

        String impresion=sb.toString();
        System.out.println(impresion);

    }

    /**
     * Se inicializa y se llama al menu listados
     */
    private void menuListados(){
        MenuListados mL = new MenuListados(gestorAlmacen);
        mL.run();
    }

    /**
     * Se graba el estado en el que se encuentra el armario, si es correcto muestra un mensaje
     * que ha sido grabado en el caso negativo también muestra otro mensaje
     */
    private void grabarEstado(){
        try {
            String archivo = CsvSaver.grabar(gestorAlmacen);
            System.out.println("Estado del armario grabado correctamente");
            System.out.println(archivo);
        } catch (Exception e) {
            System.out.println("Estado del armario no grabado: " + e.getMessage());
        }
    }

    /**
     * Se pide al usuario un fichero para cargarlo, si es correcto carga el fichero
     * en el caso negativo muestra un mensaje
     */
    private void cargarDatos(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Introduce el nombre del fichero ej. backup/ami_2023-06-05_193120.csv :");
            String s= scanner.nextLine();
            CsvLoader.cargar(s,gestorAlmacen);

        } catch (Exception e){
            System.out.println("Archivo seleccionado no cargado");
        }
    }

    public static void main(String[] args) {
        GestorAlmacen gA = new GestorAlmacen();
        MenuPrincipal mp = new MenuPrincipal(gA);
        mp.run();
    }
}
