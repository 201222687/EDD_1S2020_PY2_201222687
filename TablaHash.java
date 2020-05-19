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
public class TablaHash 
{
    public   NodoHash[] vectorHash;
    public   int tamaño;    
    
    public int ocupados;   
        
    public TablaHash() {
        this.ocupados = 0;            
        this.tamaño = 45; // tamano del vector
        //this.tamaño = 8; // tamano del vector
        this.vectorHash = new NodoHash[tamaño];        
    }
    
    //Funcion hash por metodo de plegamiento
    public int plegamiento(String nombre) {
        
        int clave = Integer.parseInt(nombre);
        int codigo = clave % (this.tamaño-1);
        System.out.println("Nombre: " + nombre + " convertido a entero : " + clave
                + " y " + clave + "%" + (this.tamaño-1) + " = " + codigo);

        if (codigo < this.tamaño) {
            return (codigo);
        } else {
            System.out.println(nombre + " se redujo a la mitad");
            return (codigo / 2);
        }        
        //return exploracionCuadratica(codigo, String.valueOf(clave), true);
    }
           
    public void insertar(String codProducto, String nombre, String marca, String precio, String ruta) {
        //if (getEstudiante(carnet) == null) {
        boolean insertado = false;
        int posicion = 0;
        
            posicion = plegamiento(codProducto);
            if (vectorHash[posicion] == null) {
                vectorHash[posicion] = new NodoHash(codProducto, nombre, marca, precio, ruta, ocupados + 1);
                ocupados += 1;                
                insertado = true;
                
            } else {
                //Colisiones por medio de listas // Dispersion abierta.
                //Aqui agrego a la lista
                NodoHash nuevo = new NodoHash(codProducto, nombre, marca, precio, ruta, (ocupados + 1));
                vectorHash[posicion].getListaCodigoProductos().insertar(new NodoLista(nuevo));               
                ocupados += 1;
                ////porcentajeUtil = calcularPorcentajeUtil();
                insertado = true;
            }

            if (insertado == true) {
                System.out.println("Insertado correctamente");
            } else {
                System.out.println("No se pudo insertar el dato: " + nombre + " en la posicion " + posicion);
            }
    }
     
    public NodoHash getEstudiante(String codProducto) {
        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                if (vectorHash[j].getCodigoProducto().equalsIgnoreCase(codProducto)) {
                    return vectorHash[j];
                }                
            }
        }
        return null;
    }
    
     public NodoHash getUsuariopy2(String codProducto) {
        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                if (vectorHash[j].getCodigoProducto().equalsIgnoreCase(codProducto)) {
                    return vectorHash[j];
                }
                else
                {
                    NodoHash nodohashls =vectorHash[j].getListaCodigoProductos().obtenernodols(codProducto);
                    
                    if(nodohashls!=null)
                    {
                        return nodohashls;
                    }                    
                }
            }
        }
        return null;
    }

    public boolean eliminaruserpy2(String codProducto) {
        
        boolean encontrado=false;
        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                if (vectorHash[j].getCodigoProducto().equalsIgnoreCase(codProducto)) {
                   
                    encontrado = true;
                  
                    if(vectorHash[j].getListaCodigoProductos().getPrimero()!=null)
                    {                        
                     ListaHash lshash = vectorHash[j].getListaCodigoProductos();                                            
                     vectorHash[j]=vectorHash[j].getListaCodigoProductos().getPrimero().getNodoHash();                                                              
                     vectorHash[j].getListaCodigoProductos().setPrimero(lshash.getPrimero().getSiguiente());
                     
                      return encontrado;                   
                    }
                    else 
                    {
                     vectorHash[j]=null;
                     
                     return encontrado;                   
                     
                    }                                       
                     
                }
                else
                {
                    if(vectorHash[j].getListaCodigoProductos().getPrimero()!=null)
                    {
                     if(vectorHash[j].getListaCodigoProductos().EliminarDatols(codProducto)==true)
                       {
                       // return vectorHash[j].getListaCodigoProductos().EliminarDatols(codProducto);
                       }
                        
                    }
                                        
                }
            }
        }        
        return encontrado;
    }
          
    public String graficarTH() throws IOException {
        int u = vectorHash.length - 1;
        StringBuilder b = new StringBuilder();

        b.append("digraph G {\n");
        b.append("nodesep=.05;\n");
        b.append("rankdir=LR;\n");
        b.append("node [shape=record,width=.1,height=.1];\n");
        b.append("node0 [label = \"");

        for (int j = 0; j < vectorHash.length - 1; j++) {
            b.append("<f" + j + ">" + j + "|");
        }

        b.append("<f" + u + ">" + u + "\"" + ",height=2.5];\n");
        b.append("node [width = 1.5];\n");

        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {//String codProducto, String nombre, String marca, String precio, String ruta
                b.append("node" + vectorHash[j].hashCode() + "[label = \"{<n> " + 
                        "#Carnet: "+vectorHash[j].getCodigoProducto()+ " .. "+
                        "Nombre: "+vectorHash[j].getNombre()+ "\\n"+
                        "Apellido: "+vectorHash[j].getMarca() + " .. "+
                        "Carrera: "+vectorHash[j].getPrecio() + "\\n"+
                        "Password: "+vectorHash[j].getRutaImg() + "\\n"+
                        "}\"];\n");
                
                //------
                
            NodoLista actual = vectorHash[j].getListaCodigoProductos().getPrimero();
            
        if(actual!=null)
        {
         b.append("node" + vectorHash[j].hashCode() + "->" + "node" + actual.hashCode() + ":n;\n");              
         
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
            
           
            actual = vectorHash[j].getListaCodigoProductos().getPrimero();
            
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
                
               //-------------- 
                
               
            } else {
            }
        }
        for (int j = 0; j < vectorHash.length; j++) {
            if (vectorHash[j] != null) {
                b.append("node0:f" + j + "->" + "node" + vectorHash[j].hashCode() + ":n;\n");              
            }
        }
        b.append("\n}");
        return b.toString();
    }

    public void crearDot() {

        try {

            FileWriter f = new FileWriter("tablaHash.dot");
            f.write(graficarTH());
            f.close();

            String salida = "dot -Tpng tablaHash.dot -o tablaHash.png";
            Runtime rt = Runtime.getRuntime();

            rt.exec(salida);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    
    
}
