/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsgeneral;

/**
 *
 * @author MALDONADO
 */
public class lsgmain {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lsg lsimplenodos = new lsg();
        // TODO code application logic here
        nodolsg elm1 = new nodolsg("168.78.9.0");        
        lsimplenodos.insertar(elm1);
        
        nodolsg elm2 = new nodolsg("169.78.9.0");        
        lsimplenodos.insertar(elm2);
        
        nodolsg elm3 = new nodolsg("170.78.9.0");        
        lsimplenodos.insertar(elm3);
        
        
        lsimplenodos.EliminarDatolsg("169.78.9.0");
        
        lsimplenodos.crearDotLSimple();
        
        
        //lista de libros
        lsg lsimplegenerallibros = new lsg();
        
        nodolsg libro1 = new nodolsg(22,"titulo","autor","editorial","anio","edicion","categoriawjja","idioma",3);                
        lsimplegenerallibros.insertar(libro1);
        
        
        nodolsg librobtenido = lsimplegenerallibros.obtenernodolsgLibro(22);
        
        System.out.println("El numero del libro isbn es = "+librobtenido.getIsbn());
        System.out.println("El numero del libro isbn es = "+librobtenido.getCategoria());
        
        
        
        
    }
    
}
