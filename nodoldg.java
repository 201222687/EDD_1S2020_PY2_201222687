/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldoblegeneral;

/**
 *
 * @author MALDONADO
 */
public class nodoldg {
    
    private String index;
    private String timestamp;
    private String data;
    private String nonce;
    private String previoushash;
    private String hash;
    
    private String nodoip;
    
    private nodoldg siguiente;
    private nodoldg anterior;
        
   public nodoldg(String index, String timestamp, String data, String nonce, String previoushash, String hash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.nonce = nonce;
        this.previoushash = previoushash;       
        this.hash = hash;          
        siguiente=null;
        anterior=null;
    }
   
      public nodoldg(String index, String timestamp, String data, String nonce, String previoushash, String hash,String nodoip) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.nonce = nonce;
        this.previoushash = previoushash;       
        this.hash = hash;     
        this.nodoip =nodoip;
        siguiente=null;
        anterior=null;
    }

    /**
     * @return the index
     */
    public String getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * @return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the nonce
     */
    public String getNonce() {
        return nonce;
    }

    /**
     * @param nonce the nonce to set
     */
    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    /**
     * @return the previoushash
     */
    public String getPrevioushash() {
        return previoushash;
    }

    /**
     * @param previoushash the previoushash to set
     */
    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return the siguiente
     */
    public nodoldg getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodoldg siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public nodoldg getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(nodoldg anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the nodoip
     */
    public String getNodoip() {
        return nodoip;
    }

    /**
     * @param nodoip the nodoip to set
     */
    public void setNodoip(String nodoip) {
        this.nodoip = nodoip;
    }
    
      
   

 
   
    
}
