/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsimple;

import java.io.FileWriter;
import java.io.IOException;
import tablahash.NodoLista;

/**
 *
 * @author MALDONADO
 */
public class listasimple {
    
    private lsnodo primero;   
    private lsnodo ultimo;
    private int size;
    
    public listasimple() {
        this.primero = null;       
        size = 0;
    }

    /**
     * @return the primero
     */
    public lsnodo getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(lsnodo primero) {
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
    
    public void insertar(lsnodo nuevo) {
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
       
    lsnodo Actual = primero;

    if(Actual!=null)
    {
    System.out.println("Mostrando Lista  simple.\n");
        while(Actual != null)
        {
            System.out.println(""+Actual.getCategorials()+" "+Actual.getNumlibrosls());
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
    public lsnodo getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(lsnodo ultimo) {
        this.ultimo = ultimo;
    }
        
    //Estos metodos funcionan para graficar la lista simple.
    public String graficarLH() throws IOException {
        
        StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
               
        lsnodo actual = getPrimero();
        if(actual!=null)
        {
            while(actual!=null)
            {
                 b.append("node" + actual.hashCode() + "[label = \"{<n> " + 
                        "Categoria: "+actual.getCategorials()+ "\\n"+
                        "No.Libros: "+actual.getNumlibrosls()+ "\\n"+                        
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

    public void crearDotLSimplePreorden() {

        try {

            FileWriter f = new FileWriter("ListaSimplePreorden.dot");
            f.write(graficarLH());
            f.close();

            String salida = "dot -Tpng ListaSimplePreorden.dot -o ListaSimplePreorden.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
        
    public void crearDotLSimpleInorden() {

        try {

            FileWriter f = new FileWriter("ListaSimpleInorden.dot");
            f.write(graficarLH());
            f.close();

            String salida = "dot -Tpng ListaSimpleInorden.dot -o ListaSimpleInorden.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
        
    public void crearDotLSimplePostorden() {

        try {

            FileWriter f = new FileWriter("ListaSimplePostorden.dot");
            f.write(graficarLH());
            f.close();

            String salida = "dot -Tpng ListaSimplePostorden.dot -o ListaSimplePostorden.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    //eliminar nodo de la lista simple al inicio al medio y al final.
    public void EliminarDatols(String Identificador){
    lsnodo Actual= getPrimero();
    lsnodo Anterior = null;
    boolean Encontrado=false;

    if(Actual!=null)
    {
       // printf("Inicio de la lista doble enlazada ordenada.\n");
        while(Actual!=null && Encontrado!=true)
        {
            if(Actual.getCategorials()==Identificador)
            {
                if(Actual==getPrimero()&& Actual==getUltimo())
                {
                    setPrimero(null);
                    setUltimo(null);
                    
                 System.out.println("Nodo Que Se Elimino = %d hera el ultimo de la lista.\n"+Actual.getCategorials()+"\n");                    
                 
                } else if(Actual==getPrimero())
                {                    
                    setPrimero(getPrimero().getSiguiente());
                    //(*primero) = (*primero)->Siguiente;
                    //(*primero)->Anterior=NULL;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al inicio = .\n"+Actual.getCategorials()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al inicio = %d .\n",Actual->Identificador);
                }
                else if(Actual==getUltimo())
                {
                    Anterior.setSiguiente(null);
                    //Anterior->Siguiente=NULL;
                    setUltimo(Anterior);
                    //(*ultimo)=Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al final = .\n"+Actual.getCategorials()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al final = %d .\n",Actual->Identificador);
                }
                else
                {
                    Anterior.setSiguiente(Actual.getSiguiente());
                    //Anterior->Siguiente = Actual->Siguiente;                    
                    //Actual->Siguiente->Anterior = Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al medio = .\n"+Actual.getCategorials()+"\n");
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
    
    public lsnodo obtenernodols(String Identificador)
    { 
       lsnodo actual = primero;
        
       while(actual!=null)
       {
       if(actual.getCategorials().equals(Identificador))
           {
               return actual;
           }
          actual=actual.getSiguiente();          
          // actual = actual->Siguiente;
       }        
       return null;
    }
    
}
