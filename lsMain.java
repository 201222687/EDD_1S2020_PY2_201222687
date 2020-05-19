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
public class lsMain {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        listasimple lsuno = new listasimple();
        lsnodo el1 = new lsnodo("catuno","lib2");
        lsnodo el2 = new lsnodo("catdos","lib3");
        lsnodo el3 = new lsnodo("cattres","lib4");
        lsnodo el4 = new lsnodo("catcuatro","lib4");
        lsnodo el5 = new lsnodo("catcinco","lib4");
        lsnodo el6 = new lsnodo("catseis","lib4");
        lsnodo el7 = new lsnodo("catsiete","lib4");
        
        
        lsuno.insertar(el1);
        lsuno.insertar(el2);
        lsuno.insertar(el3);
        lsuno.insertar(el4);
        lsuno.insertar(el5);
        lsuno.insertar(el6);
        lsuno.insertar(el7);
        
        lsuno.mostrarelementosls();
        lsuno.crearDotLSimplePreorden();
        
        lsuno.EliminarDatols("catuno");        
        //lsuno.EliminarDatols("catdos");
        //lsuno.EliminarDatols("cattres");
        lsuno.EliminarDatols("catcuatro");
        //lsuno.EliminarDatols("catcinco");
        //lsuno.EliminarDatols("catseis");
        lsuno.EliminarDatols("catsiete");
        
        lsuno.mostrarelementosls();
        
        lsnodo s = lsuno.obtenernodols("cattres");
        
        if(s!=null)
        {
            System.out.println("Categoria encontrada");
            System.out.println(s.getCategorials());
        }
        else
        {
            System.out.println("Categoria NO encontrada");
        }
                
        
        
        
        
    }
    
}
