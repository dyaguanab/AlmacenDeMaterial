package com.masanz.almacen.almacendematerial.managers;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;
import com.masanz.almacen.almacendematerial.io.CsvLoader;
import com.masanz.almacen.almacendematerial.io.CsvSaver;
import com.masanz.almacen.almacendematerial.model.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class GestorAlmacen {

    private static final int ESPACIOS_CELDA=4;

    private Armario armario;

    public GestorAlmacen(){
        this.armario=new Armario();
    }

    public Armario getArmario(){
        return armario;
    }

    public int getEspaciosCeldas(){
        return ESPACIOS_CELDA;
    }

    public int getFilas(){
        return Armario.FILAS;
    }

    public boolean meterArticulo(Articulo a) throws Exception{
        Posicion p= armario.buscarPosicionConEspacio(a.getEspacio());
        if (p!= null){
            armario.meter(p,a);
            return true;
        } else {
            return false;
        }
    }

    public Posicion getPosicionArticulo(Articulo a){
        return armario.getPosicionArticulo(a);
    }

    public List<Articulo> getArticulos(int filas, int columnas){
        return armario.getArticulos(filas,columnas);
    }

    public int getOcupacionCelda(Posicion p){
        return armario.getOCupacionCelda(p);
    }

    public boolean existeIdArticulo(String s) {
        return armario.existeIdArticulo(s);
    }

    public String saveCsv() throws FileNotFoundException {
        StringBuilder sb= new StringBuilder(System.getProperty("user.dir"));
        sb.append("\\backup\\ami_");
        sb.append(LocalDate.now().toString());
        sb.append("_");
        sb.append(LocalTime.now().toString());
        sb.append(".csv");

        String archivo= sb.toString();
        PrintWriter pw = new PrintWriter(archivo);
        pw.println();
        for (int i = 1; i <= armario.getFilas(); i++) {
            for (int j = 1; j <= armario.getColumnas(); j++) {
                List<Articulo> list = armario.getArticulos(i,j);
                for (int k = 0; k < list.size(); k++) {
                    Articulo a = list.get(k);
                    Posicion p = new Posicion(i,j);
                    StringBuilder linea = new StringBuilder(p.toString());
                    linea.append(";");
                    linea.append(a.getTipo());
                    linea.append(";");
                    linea.append(a.getId());
                    linea.append(";");
                    linea.append(a.getEspacio());
                    linea.append(";");
                    linea.append(a.getFechaAdquisicion());
                    linea.append(";");
                    linea.append(a.getPrecio());
                    linea.append(";");

                    return linea.toString();
                }
            }
        }
        pw.close();
        return archivo;
    }

    public void loadCsv(String s) throws ExcepcionAmi{
        CsvLoader.cargar(s, this);
    }

    public Articulo getArticulo(String s){
        return armario.getArticulo(s);
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden orden){
        return armario.articulosPorTipo((o1, o2) ->(int)(o1.getPrecio()-o2.getPrecio()),orden);
    }

    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden orden){
        return armario.articulosPorTipo((o1, o2) ->o1.getFechaAdquisicion().compareTo(o2.getFechaAdquisicion()),orden);
    }

//    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//    }
}
