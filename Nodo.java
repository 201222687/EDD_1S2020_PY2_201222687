/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_B;

import java.io.FileWriter;

/**
 *
 * @author MALDONADO
 */

public class Nodo {
    
    int llaveMinimaRecorridoNodo;
    int baseMinimaRecorridoNodo;
    Ordenable[] llavesMinimasOrdenable;
    Object[] datos;
    Nodo[] punteroNodo;

    public String getDotName() {
        return "Nodo" + this.hashCode();
    }

    public Nodo(int pK) {
        this.llaveMinimaRecorridoNodo = pK;
        baseMinimaRecorridoNodo = 0;
        llavesMinimasOrdenable = new Ordenable[2 * pK + 1];
        datos = new Object[2 * pK + 1];
        punteroNodo = new Nodo[(2 * pK) + 2];
    }

    public Nodo(int pK, Ordenable pLlave, Object pDato) {
        this(pK);
        baseMinimaRecorridoNodo = 1;
        llavesMinimasOrdenable[0] = pLlave;
        datos[0] = pDato;
    }

    public void setK(int llaveMinimaRecorridoNodo) {
        this.llaveMinimaRecorridoNodo = llaveMinimaRecorridoNodo;
    }

    public int getK() {
        return llaveMinimaRecorridoNodo;
    }
    /**
     * GENERA SOLAMENTE EL ARBOL B
     */
    public String dotArbol_B() {
        StringBuilder b = new StringBuilder();
        String getDot = getDotName();
        b.append("\""+getDot+"\"");
        b.append("[label=\"<P0>");
        String key, fecha, usu,tit,edi,edicion,cat,idi;
        int total;
        for (int i = 0; i < baseMinimaRecorridoNodo; i++) {
            llavesMinimasOrdenable[i].setReferencia(getDot);
            key = llavesMinimasOrdenable[i].getKey().toString();
            fecha = llavesMinimasOrdenable[i].getFecha();
            total = llavesMinimasOrdenable[i].getTotal();
            usu = llavesMinimasOrdenable[i].getUsuario();
            tit= llavesMinimasOrdenable[i].getTitulo();
            edi= llavesMinimasOrdenable[i].getEditorial();
            edicion= llavesMinimasOrdenable[i].getEdicion();
            cat= llavesMinimasOrdenable[i].getCategoría();
            idi= llavesMinimasOrdenable[i].getIdioma();

            b.append("|" + "ISBN: " + key + "\\n" + "Año: " + fecha + "\\n" + "Carnet: " + total + "\\nAutor: " + usu+"\\nTitulo:"+tit+"\\nEditorial:"+edi+"\\nEdicion:"+edicion+"\\nCategoria:"+cat+"\\nIdioma:"+idi);
            b.append("|<P" + (i + 1) + ">");
        }

        b.append("\"];\n");

        for (int i = 0; i <= baseMinimaRecorridoNodo; i++) {
            if (punteroNodo[i] != null) {
                b.append(punteroNodo[i].dotArbol_B());
                b.append("\""+getDotName()+"\"" + ":P" + i + " -> \"" + punteroNodo[i].getDotName() + "\"  [color=red, fillcolor=red, penwidth=3.0];\n");
            }
        }
        return b.toString();
    }
    /*
 ********************************************************************************************************
 ********************************************************************************************************
     */
    
}
