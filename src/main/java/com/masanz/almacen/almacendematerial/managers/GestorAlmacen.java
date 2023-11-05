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

    /**
     * Inicializa el armario
     */
    public GestorAlmacen(){
        this.armario=new Armario();
    }

    /**
     * @return devuelve armario
     */
    public Armario getArmario(){
        return armario;
    }

    /**
     * @return devuelve los espacios de las celdas
     */
    public int getEspaciosCeldas(){
        return ESPACIOS_CELDA;
    }

    /**
     * @return devuelve las filas
     */
    public int getFilas(){
        return Armario.FILAS;
    }

    /**
     * @param a variable de tipo Articulo
     * @return Devuelve true si en el armario ha sido metido el articulo,
     * en caso negativo devuelve false
     * @throws Exception lanza una excepción
     */
    public boolean meterArticulo(Articulo a) throws ExcepcionAmi{
        Posicion p= armario.buscarPosicionConEspacio(a.getEspacio());
        if (p!= null){
            armario.meter(p,a);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param a variable de tipo Articulo
     * @return la posiion del articulo que ha introducido el usuario
     */
    public Posicion getPosicionArticulo(Articulo a){
        return armario.getPosicionArticulo(a);
    }

    /**
     * @param filas parámetro introducido por el usuario
     * @param columnas parámetro introducido por el usuario
     * @return los articulos encontrados en las variables introducidas
     */
    public List<Articulo> getArticulos(int filas, int columnas){
        return armario.getArticulos(filas,columnas);
    }

    /**
     * @param p variable de tipo Posicion
     * @return la ocupación de la celda en la posicion introducida
     */
    public int getOcupacionCelda(Posicion p){
        return armario.getOCupacionCelda(p);
    }

    /**
     * @param s parámetro de tipo String
     * @return si existe el articulo introducido por la id
     */
    public boolean existeIdArticulo(String s) {
        return armario.existeIdArticulo(s);
    }

    /**
     * Se hace un StringBuilder en el que se busca la dirección en donde guardar el archivo csv
     * y se personaliza la manera en la que va a ser guardada la dirección del archivo, después
     * 3 bucles anidados en el que con las caracteristicas de armario, filas, columnas se van guardando
     * de la manera deseada
     * @return la información del contenido del archivo
     * @throws FileNotFoundException
     */
    public String saveCsv() throws FileNotFoundException {
        StringBuilder sb= new StringBuilder(System.getProperty("user.dir"));
        sb.append("\\backup\\ami_");
        sb.append(LocalDate.now().toString());
        sb.append("_");
        sb.append(LocalTime.now().toString().replaceAll(":","").substring(0,6));
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

    /**
     * @param s parámetro de tipo String
     * @throws ExcepcionAmi lanza una excepción
     * Carga el csv introducido por el usuario
     */
    public void loadCsv(String s) throws ExcepcionAmi{
        CsvLoader.cargar(s, this);
    }

    /**
     * @param s parámetro de tipo String
     * @return obtiene los articulos
     */
    public Articulo getArticulo(String s){
        return armario.getArticulo(s);
    }

    /**
     * @param orden parámetro de tipo EOrden
     * @return los articulos por el tipo precio ordenados
     */
    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoPrecio(EOrden orden){
        return armario.articulosPorTipo((o1, o2) ->(int)(o1.getPrecio()-o2.getPrecio()),orden);
    }

    /**
     * @param orden parámetro de tipo EOrden
     * @return los articulos por el tipo fecha ordenados
     */
    public Map<ETipoArticulo, List<Articulo>> articulosPorTipoFecha(EOrden orden){
        return armario.articulosPorTipo((o1, o2) ->o1.getFechaAdquisicion().compareTo(o2.getFechaAdquisicion()),orden);
    }

//    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
//    }
}
