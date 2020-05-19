/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_B;

/**
 *
 * @author MALDONADO
 */
public class insercionLlaves {
    
    public Nodo punteroRaiz;
    public Ordenable llaveMinima;
    public Object dato;

    public insercionLlaves(Nodo pPuntero, Ordenable pLlave, Object pDato) {
        this.punteroRaiz = pPuntero;
        this.llaveMinima = pLlave;
        this.dato = pDato;
    }

    public void setPuntero(Nodo punteroRaiz) {
        this.punteroRaiz = punteroRaiz;
    }

    public Nodo getPuntero() {
        return punteroRaiz;
    }

    public void setLlave(Ordenable llaveMinima) {
        this.llaveMinima = llaveMinima;
    }

    public Ordenable getLlave() {
        return llaveMinima;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }
    
}
