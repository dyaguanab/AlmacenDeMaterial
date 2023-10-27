package com.masanz.almacen.almacendematerial.model;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;

import java.util.*;

public class Armario {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 4;
    public static final int ESPACIOS_X_CELDA = 4;

    private Celda[][] celdas;

    public Armario (){
        this.celdas= new Celda[FILAS][COLUMNAS];
    }

    public int getFilas(){
        return FILAS;
    }

    public int getColumnas(){
        return COLUMNAS;
    }

    public Celda getCelda(int fila,int columna){
        return celdas[fila][columna];
    }

    public int getEspacioLibre(Posicion p){
        Celda c= celdas[p.getFilaNumber()-1][p.getColumna()-1];
        return c.getEspacioLibre();
    }

    public void meter(Posicion p,Articulo a) throws ExcepcionAmi {
        Celda c= celdas[p.getFilaNumber()-1][p.getColumna()-1];
        c.meter(a);
        /*Habrá que crear excepciones como celda*/
        //todo
    }

    public int getOCupacionCelda(Posicion p){
        Celda c = celdas[p.getFilaNumber()-1][p.getColumna()-1];
        return c.getEspacioOcupado();
    }

    public List<Articulo> getArticulos(int fila, int columna){
        Celda c= celdas[fila-1][columna-1];
        return c.getLista();
    }

    public Posicion buscarPosicionConEspacio(int espacio) {
        for (int i = FILAS-1; i >=0; i--) {
            for (int j = COLUMNAS-1; j >=0;j--) {
                Celda c=celdas[i][j];
                c.getEspacioLibre();
                if (c.getEspacioLibre()>=espacio){
                    Posicion p=new Posicion(i+1,j+1);
                    return p;
                }
            }
        }return null;
    }

    public Posicion getPosicionArticulo(Articulo a){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Celda c= celdas[i][j];
                if(c.estaArticulo(a)){
                    return new Posicion(i+1,j+1);
                }
            }
        }return null;
    }

    public boolean existeIdArticulo(String s) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Celda c= celdas[i][j];
                if (c.existeIdArticulo(s)){
                    return true;
                }
            }
        }return false;
    }

    public Articulo getArticulo(String s) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Celda c= celdas[i][j];
                Articulo a= c.getArticulo(s);
                if (a!=null){
                    return a;
                }
            }
        }return null;
    }

    public Map<ETipoArticulo, List <Articulo>>
    articulosPorTipo(java.util.Comparator<Articulo> fyp, EOrden orden){
        ETipoArticulo[] tipoArticulo =ETipoArticulo.values();
        Map<ETipoArticulo, List <Articulo>> mp = new HashMap<>();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Celda c= celdas[i][j];
                Iterator<Articulo> ite= c.iterator();
                while (ite.hasNext()){
                    Articulo a= ite.next();
                    ETipoArticulo tipo= a.getTipo();
                    if (!mp.containsKey(tipo)){
                        mp.put(tipo,new LinkedList<>());
                    }
                    mp.get(tipo).add(a);
                }
            }
        }

        for (int i = 0; i < tipoArticulo.length; i++) {
            ETipoArticulo tipo = tipoArticulo[i];
            mp.get(tipo).sort(fyp);
            if (orden ==EOrden.DESCENDENTE){
                Collections.reverse(mp.get(tipo));
            }/**/
        }
        return mp;
    }
}
