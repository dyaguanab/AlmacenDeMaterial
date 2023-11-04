package com.masanz.almacen.almacendematerial.io;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;

import java.io.FileNotFoundException;


public class CsvSaver {
    /**
     * Pasa como parámetro el gestor almacén y devuelve el metodo saveCsv
     */
    public static String grabar(GestorAlmacen gE) throws FileNotFoundException {
        return gE.saveCsv();
    }

}
