/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ldoblegeneral;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MALDONADO
 */
public class ldg {
    
    public nodoldg primero;
    public nodoldg ultimo;
    public int size;

    public ldg() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }

    public nodoldg getPrimero() {
        return primero;
    }

    public void setPrimero(nodoldg primero) {
        this.primero = primero;
    }

    public nodoldg getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoldg ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insertar(nodoldg nuevo) {
        if (getPrimero() == null) {
            setPrimero(nuevo);
            setUltimo(nuevo);
            setSize(getSize() + 1);
        } else {           
            getUltimo().setSiguiente(nuevo);            
            nuevo.setAnterior(getUltimo());
            setUltimo(nuevo);
            setSize(getSize() + 1);
        }
    }
    
    public String graficar() throws IOException {
        
         StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
        
       
        
        nodoldg actual = getPrimero();
        if(actual!=null)
        {
            while(actual!=null)
            {
                 b.append("node" + actual.hashCode() + "[label = \"{<n> " + 
                        "INDEX: "+actual.getIndex()+ " .. "+
                        "TIMESTAMP: "+actual.getTimestamp()+ "\\n"+
                        "DATA: "+actual.getData() + " .. "+
                        "NONCE: "+actual.getNonce() + "\\n"+
                        "PREVIOUSHASH: "+actual.getPrevioushash() + "\\n"+
                        "HASH: "+actual.getHash() + "\\n"+
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
                  b.append("node" + actual.getSiguiente().hashCode() + "->" + "node" + actual.hashCode() + ":n;\n");
                }
             
                actual = actual.getSiguiente();
            }
            
        }
        
        b.append("\n}");
        return b.toString();
    }

    
    public void crearDotListaDoble() {

        try {

            FileWriter f = new FileWriter("ListaDobleBlockchain.dot");
            f.write(graficar());
            f.close();

            String salida = "dot -Tpng ListaDobleBlockchain.dot -o ListaDobleBlockchain.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    public String graficar2() throws IOException {
        
         StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
        
       
        
        nodoldg actual = getPrimero();
        if(actual!=null)
        {
            while(actual!=null)
            {
                 b.append("node" + actual.hashCode() + "[label = \"{<n> " + 
                        "INDEX: "+actual.getIndex()+ " .. "+
                        "TIMESTAMP: "+actual.getTimestamp()+ "\\n"+
                        "DATA: "+actual.getData() + " .. "+
                        "NONCE: "+actual.getNonce() + "\\n"+
                        "PREVIOUSHASH: "+actual.getPrevioushash() + "\\n"+
                        "HASH: "+actual.getHash() + "\\n"+
                        "NODOIP: "+actual.getNodoip() + "\\n"+
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
                  b.append("node" + actual.getSiguiente().hashCode() + "->" + "node" + actual.hashCode() + ":n;\n");
                }
             
                actual = actual.getSiguiente();
            }
            
        }
        
        b.append("\n}");
        return b.toString();
    }

    public void crearDotListaDoble2() {

        try {

            FileWriter f = new FileWriter("ListaDobleBlockchain2.dot");
            f.write(graficar2());
            f.close();
            String salida = "dot -Tpng ListaDobleBlockchain2.dot -o ListaDobleBlockchain2.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    public boolean EliminarDatols(String Identificador){
    nodoldg Actual= getPrimero();
    nodoldg Anterior = null;
    boolean Encontradoeste=false;

    if(Actual!=null)
    {
       // printf("Inicio de la lista doble enlazada ordenada.\n");
        while(Actual!=null && Encontradoeste!=true)
        {
            if(Actual.getIndex().equals(Identificador))
            {
                if(Actual==getPrimero()&& Actual==getUltimo())
                {
                    setPrimero(null);
                    setUltimo(null);
                    
                 System.out.println("Nodo Que Se Elimino = %d hera el ultimo de la lista.\n"+Actual.getIndex()+"\n");                    
                 
                } else if(Actual==getPrimero())
                {                    
                    setPrimero(getPrimero().getSiguiente());
                    getPrimero().setAnterior(null);
                    //(*primero)->Anterior=NULL;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al inicio = .\n"+Actual.getIndex()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al inicio = %d .\n",Actual->Identificador);
                }
                else if(Actual==getUltimo())
                {
                    Anterior.setSiguiente(null);                    
                    setUltimo(Anterior);                    
                    System.out.println("Nodo Que Se Elimino Se Encontraba al final = .\n"+Actual.getIndex()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al final = %d .\n",Actual->Identificador);
                }
                else
                {
                    Anterior.setSiguiente(Actual.getSiguiente());
                    //Anterior->Siguiente = Actual->Siguiente;  
                    Actual.getSiguiente().setAnterior(Anterior);
                    //Actual->Siguiente->Anterior = Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al medio = .\n"+Actual.getIndex()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al medio = %d .\n",Actual->Identificador);
                }
                Encontradoeste = true;
                return Encontradoeste;
            }
            Anterior=Actual;//Aca queda el nodo eliminado.
            Actual=Actual.getSiguiente();
            
        }
        
        if(Encontradoeste==false)
        {
        System.out.println("Nodo no encontrado lista doble.\n");         
        }
       
    }
    else
    {
        System.out.println("La lista doble enlazada se encuentra vacia.\n");        
    }    
    return Encontradoeste;    
    }
    
    public nodoldg obtenernodolsdoble(String Identificador) { 
       nodoldg actual = getPrimero();
        
       while(actual!=null)
       {
       if(actual.getIndex().equals(Identificador))
           {
               return actual;
           }
          actual=actual.getSiguiente();                    
       }        
       return null;
    }
}
