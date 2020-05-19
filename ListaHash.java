/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author MALDONADO
 */
public class ListaHash {
    
    public NodoLista primero;
    public NodoLista ultimo;
    public int size;

    public ListaHash() {
        this.primero = null;
        this.ultimo = null;
        size = 0;
    }

    public NodoLista getPrimero() {
        return primero;
    }

    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void insertar(NodoLista nuevo) {
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
    
    public String graficarLH() throws IOException {
        
        StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
        
       
        
        NodoLista actual = getPrimero();
        if(actual!=null)
        {
            while(actual!=null)
            {
                 b.append("node" + actual.hashCode() + "[label = \"{<n> " + 
                        "#Carnet: "+actual.getNodoHash().getCodigoProducto()+ " .. "+
                        "Nombre: "+actual.getNodoHash().getNombre()+ "\\n"+
                        "Apellido: "+actual.getNodoHash().getMarca() + " .. "+
                        "Carrera: "+actual.getNodoHash().getPrecio() + "\\n"+
                        "Password: "+actual.getNodoHash().getRutaImg() + "\\n"+
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

    public void crearDotLH() {

        try {

            FileWriter f = new FileWriter("ListaHash.dot");
            f.write(graficarLH());
            f.close();

            String salida = "dot -Tpng ListaHash.dot -o ListaHash.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    public boolean EliminarDatols(String Identificador){
    NodoLista Actual= getPrimero();
    NodoLista Anterior = null;
    boolean Encontradoeste=false;

    if(Actual!=null)
    {
       // printf("Inicio de la lista doble enlazada ordenada.\n");
        while(Actual!=null && Encontradoeste!=true)
        {
            if(Actual.getNodoHash().getCodigoProducto().equals(Identificador))
            {
                if(Actual==getPrimero()&& Actual==getUltimo())
                {
                    setPrimero(null);
                    setUltimo(null);
                    
                 System.out.println("Nodo Que Se Elimino = %d hera el ultimo de la lista.\n"+Actual.getNodoHash().getCodigoProducto()+"\n");                    
                 
                } else if(Actual==getPrimero())
                {                    
                    setPrimero(getPrimero().getSiguiente());
                    //(*primero) = (*primero)->Siguiente;
                    //(*primero)->Anterior=NULL;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al inicio = .\n"+Actual.getNodoHash().getCodigoProducto()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al inicio = %d .\n",Actual->Identificador);
                }
                else if(Actual==getUltimo())
                {
                    Anterior.setSiguiente(null);
                    //Anterior->Siguiente=NULL;
                    setUltimo(Anterior);
                    //(*ultimo)=Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al final = .\n"+Actual.getNodoHash().getCodigoProducto()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al final = %d .\n",Actual->Identificador);
                }
                else
                {
                    Anterior.setSiguiente(Actual.getSiguiente());
                    //Anterior->Siguiente = Actual->Siguiente;                    
                    //Actual->Siguiente->Anterior = Anterior;
                    System.out.println("Nodo Que Se Elimino Se Encontraba al medio = .\n"+Actual.getNodoHash().getCodigoProducto()+"\n");
                    //printf("Nodo Que Se Elimino Se Encontraba al medio = %d .\n",Actual->Identificador);
                }

                Encontradoeste = true;
                
                return Encontradoeste;
            }
            Anterior=Actual;//Aca queda el nodo eliminado.
            Actual=Actual.getSiguiente();
            //Actual=Actual->Siguiente;
        }
        
        if(Encontradoeste==false)
        {
        System.out.println("Nodo no encontrado lista simple.\n");
         //printf("Nodo No Encontrado.\n");
        }
       // printf("Fin de la lista doble enlazada ordenada.\n");
    }
    else
    {
        System.out.println("La lista simple enlazada ordenada se encuentra vacia.\n");
        //printf("La lista doble enlazada ordenada se encuentra vacia.\n");
    }    
    return Encontradoeste;    
    }
    
    public NodoHash obtenernodols(String Identificador) { 
       NodoLista actual = getPrimero();
        
       while(actual!=null)
       {
       if(actual.getNodoHash().getCodigoProducto().equals(Identificador))
           {
               return actual.getNodoHash();
           }
          actual=actual.getSiguiente();          
          // actual = actual->Siguiente;
       }        
       return null;
    }
}
