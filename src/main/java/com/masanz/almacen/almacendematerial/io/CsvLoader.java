package com.masanz.almacen.almacendematerial.io;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;
import com.masanz.almacen.almacendematerial.model.Armario;
import com.masanz.almacen.almacendematerial.model.Articulo;
import com.masanz.almacen.almacendematerial.model.ETipoArticulo;
import com.masanz.almacen.almacendematerial.model.Posicion;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class CsvLoader {
    public static void cargar(String s, GestorAlmacen gE) throws ExcepcionAmi {
        try{
            Scanner scanner = new Scanner(new File(s));
            Armario a= gE.getArmario();

            while (scanner.hasNext()){
                String linea= scanner.nextLine();
                String[] campos= linea.split(";");
                String posicion =campos[0];
                String tipo= campos[1];
                String id= campos[2];
                String espacios= campos[3];
                String fechaAdquisicion= campos[4];
                String precio= campos[5];

                Articulo art = new Articulo(id, ETipoArticulo.valueOf(tipo), Integer.parseInt(espacios), LocalDate.parse(fechaAdquisicion), Double.parseDouble(precio));
                Posicion p= new Posicion(posicion);
                a.meter(p,art);
            }
        }catch (Exception e){
            throw new ExcepcionAmi("Error. Fichero inexistente");
        }
    }
}
