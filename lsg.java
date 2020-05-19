/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsgeneral;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MALDONADO
 */
public class lsg {
    
    private nodolsg primero;   
    private nodolsg ultimo;
    private int size;
    
    public lsg() {
        this.primero = null;       
        size = 0;
    }

    /**
     * @return the primero
     */
    public nodolsg getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(nodolsg primero) {
        this.primero = primero;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void insertar(nodolsg nuevo) {
        if (getPrimero() == null) {
            setPrimero(nuevo);
            setUltimo(nuevo);
            setSize(getSize() + 1);
        } else {
            
            getUltimo().setSiguiente(nuevo);            
            setUltimo(nuevo);
            setSize(getSize() + 1);
        }
    }

    public void mostrarelementosls() {
       
    nodolsg Actual = primero;

    if(Actual!=null)
    {
    System.out.println("Mostrando Lista  simple.\n");
        while(Actual != null)
        {
            System.out.println(""+Actual.getIp());
            Actual = Actual.getSiguiente();
        }
    System.out.println("--------fin----------------------.\n");
    }else
    {
    System.out.println("Lista simple Se Encuentra Vacia.\n");
    }
            
    }
    /**
     * @return the ultimo
     */
    public nodolsg getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(nodolsg ultimo) {
        this.ultimo = ultimo;
    }
        
    //Estos metodos funcionan para graficar la lista simple.
    public String graficar() throws IOException {
        
        StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
               
        nodolsg actual = getPrimero();
        if(actual!=null)
        {
            while(actual!=null)
            {
                 b.append("node" + actual.hashCode() + "[label = \"{<n> " + 
                        "Ip: "+actual.getIp()+ "\\n"+                        
                        "}\"];\n");
                 
                actual = actual.getSiguiente();
            }            
           
            actual = getPrimero();
            
            while (actual!=null)
            {                
                if(actual.getSiguiente()==null)
                {
                    
                }
                else
                {
                  b.append("node" + actual.hashCode() + "->" + "node" + actual.getSiguiente().hashCode() + ":n;\n");              
                }
             
                actual = actual.getSiguiente();
            }
            
        }
        
        b.append("\n}");
        return b.toString();
    }

    public void crearDotLSimple() {

        try {

            FileWriter f = new FileWriter("ListaSimpleNODOS.dot");
            f.write(graficar());
            f.close();

            String salida = "dot -Tpng ListaSimpleNODOS.dot -o ListaSimpleNODOS.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
            
    //eliminar nodo de la lista simple al inicio al medio y al final.
    public void EliminarDatolsg(String Identificador){
    nodolsg Actual= getPrimero();
    nodolsg Anterior = null;
    boolean Encontrado=false;

    if(Actual!=null)
    {
       // printf("Inicio de la lista doble enlazada ordenada.\n");
        while(Actual!=null && Encontrado!=true)
        {
            if(Actual.getIp().equals(Identificador))
            {
                if(Actual==getPrimero()&& Actual==getUltimo())
                {
                    setPrimero(null);
                    setUltimo(null);
                    
                 System.out.println("Nodo Que Se Elimino = %d hera el ultimo de la lista.\n"+Actual.getIp()+"\n");                    
                 
                } else if(Actual==getPrimero())
                {                    
                    setPrimero(getPrimero().getSiguiente());
                    //(*primero) = (*primero)->Siguiente;
                    //(*primero)->Anterior=NULL;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al inicio = .\n"+Actual.getIp()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al inicio = %d .\n",Actual->Identificador);
                }
                else if(Actual==getUltimo())
                {
                    Anterior.setSiguiente(null);
                    //Anterior->Siguiente=NULL;
                    setUltimo(Anterior);
                    //(*ultimo)=Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al final = .\n"+Actual.getIp()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al final = %d .\n",Actual->Identificador);
                }
                else
                {
                    Anterior.setSiguiente(Actual.getSiguiente());
                    //Anterior->Siguiente = Actual->Siguiente;                    
                    //Actual->Siguiente->Anterior = Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al medio = .\n"+Actual.getIp()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al medio = %d .\n",Actual->Identificador);
                }


                Encontrado=true;
            }
            Anterior=Actual;//Aca queda el nodo eliminado.
            Actual=Actual.getSiguiente();
            //Actual=Actual->Siguiente;
        }
        
        if(Encontrado==false)
        {
         System.out.println("Nodo no encontrado.\n");
         //printf("Nodo No Encontrado.\n");
        }

       // printf("Fin de la lista doble enlazada ordenada.\n");
    }
    else
    {
        System.out.println("La lista simple enlazada ordenada se encuentra vacia.\n");
        //printf("La lista doble enlazada ordenada se encuentra vacia.\n");
    }
    
    }
    
    public nodolsg obtenernodolsg(String Identificador) { 
       nodolsg actual = primero;
        
       while(actual!=null)
       {
       if(actual.getIp().equals(Identificador))
           {
               return actual;
           }
          actual=actual.getSiguiente();          
          // actual = actual->Siguiente;
       }        
       return null;
    }
    
     public nodolsg obtenernodolsgLibro(long numero) { 
       nodolsg actual = primero;
        
       while(actual!=null)
       {
       if(actual.getIsbn()==numero)
           {
               return actual;
           }
          actual=actual.getSiguiente();          
          // actual = actual->Siguiente;
       }        
       return null;
    }
    
        

}
