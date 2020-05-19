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
public class ldgMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ldg listadoble = new ldg();
        
        nodoldg elmendoble1 = new nodoldg("1","3 ","ddd","444","daf","hash");
        listadoble.insertar(elmendoble1);
        
        nodoldg elmendoble2 = new nodoldg("2","3 ","ddd","444","daf","hash");
        listadoble.insertar(elmendoble2);
        
        
        nodoldg elmendoble3 = new nodoldg("3","3 ","ddd","444","daf","hash");
        listadoble.insertar(elmendoble3);
        
        nodoldg elmendoble4 = new nodoldg("4","3 ","ddd","444","daf","hash");
        listadoble.insertar(elmendoble4);
        
        listadoble.EliminarDatols("1");
        
        
        listadoble.crearDotListaDoble();
        
    }
    
}
