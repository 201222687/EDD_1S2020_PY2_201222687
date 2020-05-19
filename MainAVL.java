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
public class MainAVL {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      //TODO code application logic here        
      arbolAVL treeAVL = new arbolAVL(); 
      
      nodoAVL x = new nodoAVL("A","0");     
      treeAVL.insertarNuevo(x);   
      nodoAVL x1 = new nodoAVL("B","0");     
      treeAVL.insertarNuevo(x1);   
      nodoAVL x2 = new nodoAVL("C","0");     
      treeAVL.insertarNuevo(x2);         
      
      
      //nodoAVL x = new nodoAVL("80","1111");     
      //tree.insertarNuevo(x);   
      //nodoAVL x1 = new nodoAVL("50","2222");     
      //tree.insertarNuevo(x1);   
      //nodoAVL x2 = new nodoAVL("60","3333");     
      //tree.insertarNuevo(x2);         
      
      //nodoAVL x3 = new nodoAVL("10","3333");     
      //tree.insertarNuevo(x3);         
      //nodoAVL x4 = new nodoAVL("20","3333");     
      //tree.insertarNuevo(x4);         
      //nodoAVL x5 = new nodoAVL("30","3333");     
      //tree.insertarNuevo(x5);         
      //nodoAVL x6 = new nodoAVL("14","3333");     
      //tree.insertarNuevo(x6);                 
      
      
      
      nodoAVL nodoAVLarbolB = treeAVL.buscarDato(treeAVL.raiz, "A");
      
      if(nodoAVLarbolB==null)
      {
          System.out.println("Categoria no encontrada");
      }
      else
      {
      nodoAVLarbolB.getObjetoarbolbjc().insert(new LlaveEntero("",6,"1999",201222687,"Escobar Wolf","Harry poter","20th Century","1","sagas","Aleman"),"");
      nodoAVLarbolB.getObjetoarbolbjc().insert(new LlaveEntero("",11,"",4,"d","","","","",""),"");
      nodoAVLarbolB.getObjetoarbolbjc().insert(new LlaveEntero("",5,"d",4,"d","","","","",""),"");      
      //arbolb.insert(new LlaveEntero("",6,"1999",201222687,"Escobar Wolf","Harry poter","20th Century","1","sagas","Aleman"),"");
      
      nodoAVLarbolB.pass= String.valueOf(nodoAVLarbolB.getObjetoarbolbjc().cantidadDeNodos);
      nodoAVLarbolB.getObjetoarbolbjc().toDot("nodoAVLarbolB", "nodoAVLarbolB");      
      }
     
      
      nodoAVL nodoAVLarbolB2 = treeAVL.buscarDato(treeAVL.raiz, "C");
      
      if(nodoAVLarbolB2==null)
      {
          System.out.println("Categoria no encontrada");
      }
      else
      {
      nodoAVLarbolB2.getObjetoarbolbjc().insert(new LlaveEntero("",6,"1999",201222687,"Escobar Wolf","Harry poter","20th Century","1","sagas","Aleman"),"");
      nodoAVLarbolB2.getObjetoarbolbjc().insert(new LlaveEntero("",11,"",4,"d","","","","",""),"");
      //GENERA EL ARCHIVO .DOT Y LA IMAGEN DE UNA VEZ
      nodoAVLarbolB2.pass= String.valueOf(nodoAVLarbolB2.getObjetoarbolbjc().cantidadDeNodos);
      nodoAVLarbolB2.getObjetoarbolbjc().toDot("nodoAVLarbolB2", "nodoAVLarbolB2");  
      }  
     
      
      treeAVL.generarArbol("arbolavl", "arbolavl");   
      
      
      treeAVL.preOrdenListaSimple(treeAVL.raiz);
      treeAVL.lspreorden.crearDotLSimplePreorden();
      
      treeAVL.inOrdenListaSimple(treeAVL.raiz);
      treeAVL.lsinorden.crearDotLSimpleInorden();
      
      treeAVL.postOrdenListaSimple(treeAVL.raiz);
      treeAVL.lspostorden.crearDotLSimplePostorden();
      
    }
    
    
    
}
