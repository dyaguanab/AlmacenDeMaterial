package com.masanz.almacen.almacendematerial.model;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;

import java.util.*;

public class Armario {
    public static final int FILAS = 5;
    public static final int COLUMNAS = 4;
    public static final int ESPACIOS_X_CELDA = 4;

    private Celda[][] celdas;

    /**
     * Le asigno a celdas los valores de FILAS y COLUMNAS.
     * Cada celda creada tiene unos ESPACIOS_X_CELDA
     */
    public Armario (){
        this.celdas= new Celda[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                celdas[i][j]=new Celda(ESPACIOS_X_CELDA);
            }
        }
    }

    /**
     * @return el valor de filas
     */
    public int getFilas(){
        return FILAS;
    }

    /**
     * @return el valor de columnas
     */
    public int getColumnas(){
        return COLUMNAS;
    }

    /**
     * @param fila
     * @param columna
     * @return celdas con los valores de los parámetros
     */
    public Celda getCelda(int fila,int columna){
        return celdas[fila][columna];
    }

    /**
     * @param p es una variable de tipo Posicion
     * Creo una nueva celda en la que obtengo la posicion de la fila y columna,
     * le resto 1 porque lo estoy pasando a lenguaje java.
     * @return el espacio libre obtenido
     */
    public int getEspacioLibre(Posicion p){
        Celda c= celdas[p.getFilaNumber()-1][p.getColumna()-1];
        return c.getEspacioLibre();
    }

    /**
     * @param p es una variable de tipo Posicion
     * @param a es una variable de tipo Articulo
     * Creo una nueva celda en la que obtengo la posicion de la fila y columna, como el anterior método.
     * Meto el articulo en la celda
     * @throws ExcepcionAmi lanzo la excepción creada
     */
    public void meter(Posicion p,Articulo a) throws Exception{
        Celda c= celdas[p.getFilaNumber()-1][p.getColumna()-1];
        c.meter(a);
    }

    /**
     * @param p es una variable de tipo Posicion
     * @return obtengo el espacio ocupado de la celda creada.
     */
    public int getOCupacionCelda(Posicion p){
        Celda c = celdas[p.getFilaNumber()-1][p.getColumna()-1];
        return c.getEspacioOcupado();
    }

    /**
     * @param fila le paso este parámetro en vez de obtenerla por posicion
     * @param columna le paso este parámetro en vez de obtenerla por posicion
     * pero lo sigo pasando a lenguaje java
     * @return devuelve la lista de la celda
     */
    public List<Articulo> getArticulos(int fila, int columna){
        Celda c= celdas[fila-1][columna-1];
        return c.getLista();
    }

    /**
     * @param espacio le paso este parametro para después obtener el espacio libre
     * Hago 2 bucles anidados en el que le resto 1 a las constantes FILAS y COLUMNAS,
     * para hacerlo en lenguaje java, en el armario empiezo a buscar la posicion desde
     * abajo en la derecha hacia la izquierda y arriba.
     * @return devuelve p que es la posicion con espacio disponible
     */
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

    /**
     * @param a es una variable de tipo Articulo
     * Se hacen 2 bucles anidados con las constantes FILAS y COLUMNAS que se guardan en
     * una nueva celda y con un if se busca si está el articulo en la celda.
     * @return en el caso de que esté se devuelve la posición en lenguaje humano, por eso el +1
     */
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

    /**
     * @param s es parámetro introducido por el usuario
     * Se sigue la misma lógica pero con el fin de si la id introducida por el
     * usuario existe en el articulo
     * @return true en caso de existir la id, en caso negativo devuelve false.
     */
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

    /**
     * @param s es parámetro introducido por el usuario
     * Se crea una variable de tipo Articulo en la que se guarda el articulo obtenido en caso de que exista
     * @return devuelve el articulo en caso de existir, sino no devuelve nada
     */
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

    /**
     * @param fyp parámetro comparator que será la fecha y el precio,
     * @param orden parámetro de tipo EOrden
     * Creo una variable de ETipoArticulo[] al que le guardo los valores, también creo un map 'mp'
     * llamado mp. Se realiza 2 bucles for que utilizan las constantes, que se guardan en una nueva celda,
     * se crea un iterador para recorrer esas celdas y se obtiene el tipo de articulo de cada celda.
     * Se verifica si mp si tiene una lista, sino se crea, a la lista se le añade el articulo.
     * Por último se ordena por el comparador 'fyp' .
     * @return se devuelve el mapa obtenido
     */
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
