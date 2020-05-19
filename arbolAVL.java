/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

import java.io.FileWriter;
import javax.swing.JOptionPane;
import lsimple.*;


/**
 *
 * @author MALDONADO
 */
public class arbolAVL {    
    
    public  nodoAVL raiz;
    public  String cuerpoDelDot = "";
    
    public listasimple lspreorden = new listasimple();
    public listasimple lsinorden = new listasimple();
    public listasimple lspostorden = new listasimple();

    public arbolAVL() {
        this.raiz = null;
    }
    
    public  void preOrdenListaSimple(nodoAVL recorrer) {
        if (recorrer != null) {

            lsnodo xnodols = new lsnodo(recorrer.getId(),recorrer.getPass());        
            lspreorden.insertar(xnodols);
            //System.out.println(recorrer.id);
            preOrdenListaSimple(recorrer.getIzquierda());
            preOrdenListaSimple(recorrer.getDerecha());
        }
    }
    
    public  void inOrdenListaSimple(nodoAVL recorrer) {
        if (recorrer != null) {

            inOrdenListaSimple(recorrer.getIzquierda());
            lsnodo xnodols = new lsnodo(recorrer.getId(),recorrer.getPass());        
            lsinorden.insertar(xnodols);            
            inOrdenListaSimple(recorrer.getDerecha());
        }
    }
    
    public  void postOrdenListaSimple(nodoAVL recorrer) {
        if (recorrer != null) {
            postOrdenListaSimple(recorrer.getIzquierda());
            postOrdenListaSimple(recorrer.getDerecha());
            lsnodo xnodols = new lsnodo(recorrer.getId(),recorrer.getPass());        
            lspostorden.insertar(xnodols);
        }
    }
    

    public  void insertarNuevo(nodoAVL idEntrada) {
        raiz = insertar(idEntrada, raiz);
    }

    public  nodoAVL insertar(nodoAVL nuevo, nodoAVL raiz) {
        if (raiz == null) {
            raiz = nuevo;

        } else if (nuevo.getId().compareTo(raiz.getId()) < 0) {

            raiz.setIzquierda(insertar(nuevo, raiz.getIzquierda()));
            if (altura(raiz.getDerecha()) - altura(raiz.getIzquierda()) == -2) {

                if (nuevo.getId().compareTo(raiz.getIzquierda().getId()) < 0) {
                    raiz = IzquierdaIzquierda(raiz);
                } else {
                    raiz = IzquierdaDerecha(raiz);
                }

            }

        } else if (nuevo.getId().compareTo(raiz.getId()) > 0) {

            raiz.setDerecha(insertar(nuevo, raiz.getDerecha()));
            if (altura(raiz.getDerecha()) - altura(raiz.getIzquierda()) == 2) {

                if (nuevo.getId().compareTo(raiz.getDerecha().getId()) > 0) {
                    raiz = DerechaDerecha(raiz);
                } else {
                    raiz = DerechaIzquierda(raiz);
                }
            }

        } else {
            System.err.println("No se permiten los valores duplicados: \""
                    + nuevo.getId() + "\".");
        }

        raiz.setFrecuenciaEquivalente(mayor(altura(raiz.getIzquierda()), altura(raiz.getDerecha())) + 1);
        return raiz;
    }

    public  nodoAVL buscarDato(nodoAVL recorrer, String id) {
        if (recorrer == null) {
            return recorrer;
        } else if (recorrer.getId().equals(id)) {
            return recorrer;
        } else if (recorrer.getId().compareTo(id) < 0) {
            return buscarDato(recorrer.getDerecha(), id);
        } else {
            return buscarDato(recorrer.getIzquierda(), id);
        }

    }

    //para eliminar nodo se utiliza el metodo nodoReemplazo
    public  boolean eliminarNodo(String id) {
        nodoAVL recorrer = raiz;
        nodoAVL padre = raiz; 
        boolean banderaHijoIzquierdo = true;

        //while (recorrer.getId()!=id) { //USADO URIGIANLMENTE
         while (!recorrer.getId().equals(id)) {
            padre = recorrer;

            if (id.compareTo(recorrer.getId()) < 0) {
                banderaHijoIzquierdo = true;
                recorrer = recorrer.getIzquierda();

            } else {
                banderaHijoIzquierdo = false;
                recorrer = recorrer.getDerecha();
            }

            if (recorrer == null) {
                return false;
            }
        }
        if (recorrer.getIzquierda() == null && recorrer.getDerecha() == null) {

            if (recorrer == raiz) {
                raiz = null;
            } else if (banderaHijoIzquierdo) {
                padre.setIzquierda(null);
            } else {
                padre.setDerecha(null);
            }

        } else if (recorrer.getDerecha() == null) {

            if (recorrer == raiz) {
                raiz = recorrer.getIzquierda();
            } else if (banderaHijoIzquierdo) {
                padre.setIzquierda(recorrer.getIzquierda());
            } else {
                padre.setDerecha(recorrer.getIzquierda());
            }

        } else if (recorrer.getIzquierda() == null) {

            if (recorrer == raiz) {
                raiz = recorrer.getDerecha();
            } else if (banderaHijoIzquierdo) {
                padre.setIzquierda(recorrer.getDerecha());
            } else {
                padre.setDerecha(recorrer.getIzquierda());
            }

        } else {

            nodoAVL reemplazo = nodoReemplazo(recorrer);

            if (recorrer == raiz) {
                raiz = reemplazo;
            } else if (banderaHijoIzquierdo) {
                padre.setIzquierda(reemplazo);
            } else {
                padre.setDerecha(reemplazo);
            }
            reemplazo.setIzquierda(recorrer.getIzquierda());
        }

        return true;
    }

    public  nodoAVL nodoReemplazo(nodoAVL nuevoReemplazo) {

        nodoAVL reemplazarPadre = nuevoReemplazo;
        nodoAVL reemplazo = nuevoReemplazo;
        nodoAVL recorrer = nuevoReemplazo.getDerecha();

        while (recorrer != null) {
            reemplazarPadre = reemplazo;
            reemplazo = recorrer;
            recorrer = recorrer.getIzquierda();
        }

        if (reemplazo != nuevoReemplazo.getDerecha()) {
            reemplazarPadre.setIzquierda(reemplazo.getDerecha());
            reemplazo.setDerecha(nuevoReemplazo.getDerecha());
        }

        return reemplazo;
    }
    /**
     * VALORES QUE SIRVEN PARA PODER GENERAR EL ARCHIVO .DOT
     */
    public  String primeraParteDot(nodoAVL recorrer) {
        String salida = "\"nodo" + String.valueOf(recorrer.getId()) + "\""
                + " [ label = \"<C0>| "
                + "Categoria: " + String.valueOf(recorrer.getId()) + "\\n"
                + "#libros: " + String.valueOf(recorrer.getPass()) + "\\n"
                + " |<C1>\", fillcolor=skyblue];\n";
        return salida;
    }

    public  String generarArbol(String nombreDot, String nombreImagen) {
        String salidaUnificada = "";
        if (raiz != null) {
            try {
                FileWriter fichero = new FileWriter(nombreDot + ".dot");
                cuerpoDelDot = "";
                preOrden(raiz);
                fichero.write("digraph grafica{\nrankdir=TB;\nnode [shape = record, style=filled, fillcolor=seashell2];\n" + cuerpoDelDot + toDot(raiz) + "\n}");
                salidaUnificada = "node [shape = record, style=filled, fillcolor=seashell2];\n" + cuerpoDelDot + toDot(raiz);
                fichero.close();
                String f = "dot -Tpng " + nombreDot + ".dot -o " + nombreImagen + ".png";
                Runtime.getRuntime().exec(f);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Raiz vacia, no puede generarse arbol AVL!\nMetodo dot del arboL");
        }

        return salidaUnificada;
    }

    public  void preOrden(nodoAVL recorrer) {
        if (recorrer != null) {

            if (raiz.getIzquierda() != null || raiz.getDerecha() != null) {
                cuerpoDelDot += primeraParteDot(recorrer);
            }
            //System.out.println(recorrer.id);
            preOrden(recorrer.getIzquierda());
            preOrden(recorrer.getDerecha());
        }
    }
    
    

    public  String toDot(nodoAVL recorrer) {
        String buffer = "";
        int contador = 0;

        if (raiz.getIzquierda() != null || raiz.getDerecha() != null) {

        }

        if (recorrer.getIzquierda() != null) {
            buffer += "\"nodo" + recorrer.getId() + "\":C0->\"nodo" + recorrer.getIzquierda().getId() + "\"[color=red, fillcolor=red, penwidth=3.0]\n";
            buffer += toDot(recorrer.getIzquierda());
        }
        if (recorrer.getDerecha() != null) {
            buffer += "\"nodo" + recorrer.getId() + "\":C1->\"nodo" + recorrer.getDerecha().getId() + "\"[color=red, fillcolor=red, penwidth=3.0]\n";
            buffer += toDot(recorrer.getDerecha());
        }
        return buffer;
    }

    //*******************************************************************************************************
    //*******************************************************************************************************
    /*ULTIMO HECHO FUNCIONAL*/
    public  int altura(nodoAVL nodo) {
        if (nodo == null){
            return -1;
        }else{
            return nodo.getFrecuenciaEquivalente();
        }
    }

    public  int mayor(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        }
        return n2;
    }

    public  nodoAVL IzquierdaIzquierda(nodoAVL n1) {
        nodoAVL n2 = n1.getIzquierda();
        n1.setIzquierda(n2.getDerecha());
        n2.setDerecha(n1);
        n1.setFrecuenciaEquivalente(mayor(altura(n1.getIzquierda()), altura(n1.getDerecha())) + 1);
        n2.setFrecuenciaEquivalente(mayor(altura(n2.getIzquierda()), n1.getFrecuenciaEquivalente()) + 1);
        return n2;
    }

    public  nodoAVL DerechaDerecha(nodoAVL n1) {
        nodoAVL n2 = n1.getDerecha();
        n1.setDerecha(n2.getIzquierda());
        n2.setIzquierda(n1);
        n1.setFrecuenciaEquivalente(mayor(altura(n1.getIzquierda()), altura(n1.getDerecha())) + 1);
        n2.setFrecuenciaEquivalente(mayor(altura(n2.getDerecha()), n1.getFrecuenciaEquivalente()) + 1);
        return n2;
    }

    public  nodoAVL IzquierdaDerecha(nodoAVL n1) {
        n1.setIzquierda(DerechaDerecha(n1.getIzquierda()));
        return IzquierdaIzquierda(n1);
    }

    public  nodoAVL DerechaIzquierda(nodoAVL n1) {
        n1.setDerecha(IzquierdaIzquierda(n1.getDerecha()));
        return DerechaDerecha(n1);
    }
  
}
