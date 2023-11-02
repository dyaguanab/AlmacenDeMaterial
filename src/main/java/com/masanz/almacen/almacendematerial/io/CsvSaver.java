package com.masanz.almacen.almacendematerial.io;

import com.masanz.almacen.almacendematerial.managers.GestorAlmacen;

import java.io.FileNotFoundException;

public class CsvSaver {

    public static String grabar(GestorAlmacen gE) throws FileNotFoundException {
        return gE.saveCsv();
    }

}
