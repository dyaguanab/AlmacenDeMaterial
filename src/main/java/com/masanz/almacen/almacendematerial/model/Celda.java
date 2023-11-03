package com.masanz.almacen.almacendematerial.model;

import com.masanz.almacen.almacendematerial.exceptions.ExcepcionAmi;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Celda {

    private int espacio;
    private List<Articulo> lista;

    /**
     * Es el constructor
     * Se inicializan los atributos
     */
    public Celda(int espacio){
        this.espacio = espacio;
        this.lista = new LinkedList<>();
    }

    /**
     * @return Devuelve el valor de lista
     */
    public List<Articulo> getLista(){
        return lista;
    }

    /**
     * @param lista Se establece el valor de lista
     */
    public void setLista(List<Articulo> lista){
        this.lista=lista;
    }

    /**
     * @param a Se mete el articulo en la celda
     * @throws ExcepcionAmi Se lanza una excepción
     */
    public void meter(Articulo a) throws ExcepcionAmi{
        if (estaArticulo(a)) {
            throw new ExcepcionAmi("Ya existe el articulo introducido");
        }
        if (a.getEspacio() <= getEspacioLibre()){
            lista.add(a);
        } else {
            throw new ExcepcionAmi("No hay espacio suficiente para meter el articulo");
        }

    }

    /**
     * @return Se devuelve el espacio libre
     */
    public int getEspacioLibre(){
        return espacio-getEspacioOcupado();
    }

    /**
     * @return Se devuelve el espacio ocupado
     */
    public int getEspacioOcupado(){
        int esp=0;
        for (int i = 0; i < lista.size(); i++) {
            Articulo a = lista.get(i)  ;
            esp += a.getEspacio();
        }
        return esp;
    }

    /**
     * @param a Se mira si el articulo está ya en la celda
     * @return Devuelve true o false, depende si se encuentra el articulo
     */
    public boolean estaArticulo(Articulo a){
        if (lista.contains(a)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * @param s Se pasa el parámetro para ver si está la id del articulo
     * @return Devuelve true o false, depende de si se encuentra la id
     */
    public boolean existeIdArticulo(String s){
        for (int i = 0; i < lista.size(); i++) {
            Articulo a = lista.get(i);
            if(a.getId()==s){
                return true;
            }
        }
        return false;
    }

    /**
     * @param s Se pasa el parámetro s para obtener el articulo
     * @return Devuelve el articulo en la celda
     */
    public Articulo getArticulo(String s){
        for (int i = 0; i < lista.size(); i++) {
            Articulo a =lista.get(i);
            if (a.getId()==s);
            return a;
        }
        return null;
    }

    /**
     * @return iterator
     */
    public Iterator <Articulo> iterator(){
        return lista.iterator();
    }

    /**
     * Se hace un Stringbuilder para añadir elementos en cadena, se recorre la lista contiene Articulos
     * y a partir de ahí se obtiene los espacios que hay, depende del espacio se asigna unos '_' a los lados
     * de la id obtenida. Se calcula los espacios libres que hay y se le asigna unos espacios en blanco.
     * @return la cadena de caracteres
     */
    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder("");

        for (int i = 0; i < lista.size(); i++) {
            Articulo a = lista.get(i);
            int espacio =a.getEspacio();
            if (espacio==1){
                sb.append("_");
                sb.append(a.getId());
                sb.append("_");
            } else if (espacio==2) {
                sb.append("______");
                sb.append(a.getId());
                sb.append("______");
            } else if (espacio==3) {
                sb.append("___________");
                sb.append(a.getId());
                sb.append("___________");
            }else if(espacio==4){
                sb.append("________________");
                sb.append(a.getId());
                sb.append("________________");
            }
            sb.append("|");
        }
        int espL = getEspacioLibre();
        if (espL==1){
        sb.append("         |");
        } else if (espL==2) {
            sb.append("         |         |");
        } else if (espL==3) {
            sb.append("         |         |         |");
        } else if (espL==4) {
            sb.append("                                        |");
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        Celda c = new Celda(4);
//
//        LocalDate fecha = LocalDate.parse("2023-06-11");
//
//        Articulo a = new Articulo("MON1001",ETipoArticulo.MONITOR,3, fecha,1500.0);
//        Articulo a1 = new Articulo("MON1002",ETipoArticulo.MONITOR,3, fecha,1500.0);
//
//        try {
//            c.meter(a);
//            c.meter(a);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            c.meter(a);
//            c.meter(a1);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
}
