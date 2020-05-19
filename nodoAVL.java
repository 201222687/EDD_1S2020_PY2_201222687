/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import arbol_B.*;

/**
 *
 * @author MALDONADO
 */
public class nodoAVL {     
    
    public String id;
    public String pass;
    
    
    public nodoAVL derecha;
    public nodoAVL izquierda;
    public int frecuenciaEquivalente;    
    private ArbolB objetoarbolbjc;
        
    public nodoAVL(String id, String pass){
        this.id = id;
        this.pass = pass;
        this.frecuenciaEquivalente = 0;
        
        this.derecha = null;
        this.izquierda = null;
        
        this.objetoarbolbjc = new ArbolB(2);
    }
    
        
    /**
     * @return the derecha
     */
    public nodoAVL getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(nodoAVL derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the izquierda
     */
    public nodoAVL getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(nodoAVL izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the frecuenciaEquivalente
     */
    public int getFrecuenciaEquivalente() {
        return frecuenciaEquivalente;
    }

    /**
     * @param frecuenciaEquivalente the frecuenciaEquivalente to set
     */
    public void setFrecuenciaEquivalente(int frecuenciaEquivalente) {
        this.frecuenciaEquivalente = frecuenciaEquivalente;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the objetoarbolbjc
     */
    public ArbolB getObjetoarbolbjc() {
        return objetoarbolbjc;
    }

    /**
     * @param objetoarbolbjc the objetoarbolbjc to set
     */
    public void setObjetoarbolbjc(ArbolB objetoarbolbjc) {
        this.objetoarbolbjc = objetoarbolbjc;
    }
    
}
