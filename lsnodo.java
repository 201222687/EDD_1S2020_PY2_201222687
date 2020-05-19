/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsimple;



/**
 *
 * @author MALDONADO
 */
public class lsnodo {
    
    private lsnodo siguiente;    
    private String categorials;
    private String numlibrosls;
       
    
        public lsnodo(String categorials,String numlibrosls){
                
        this.categorials=categorials;
        this.numlibrosls=numlibrosls;
        siguiente=null;
    }  

    /**
     * @return the siguiente
     */
    public lsnodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(lsnodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the categorials
     */
    public String getCategorials() {
        return categorials;
    }

    /**
     * @param categorials the categorials to set
     */
    public void setCategorials(String categorials) {
        this.categorials = categorials;
    }

    /**
     * @return the numlibrosls
     */
    public String getNumlibrosls() {
        return numlibrosls;
    }

    /**
     * @param numlibrosls the numlibrosls to set
     */
    public void setNumlibrosls(String numlibrosls) {
        this.numlibrosls = numlibrosls;
    }
    
}
