/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_B;

import java.io.FileWriter;
/**
 *
 * @author MALDONADO
 */
public class ArbolB {
    
    public Nodo raiz = null;
    private int llaveMinima = 2;
    private int alturaMinima = 0;  
    public int cantidadDeNodos =0 ;

    public ArbolB() {}

    public ArbolB(int k) {
        this.llaveMinima = k;
    }

    public ArbolB(Nodo nuevaRaiz) {
        llaveMinima = nuevaRaiz.getK();
        this.raiz = nuevaRaiz;
        alturaMinima = 1;
    }

    public void insert(Ordenable llave, Object obj) {
        
        cantidadDeNodos= cantidadDeNodos+1;
        if (this.alturaMinima == 0) {
            this.raiz = new Nodo(this.llaveMinima, llave, obj);
            this.alturaMinima = 1;
            return;
        }

        insercionLlaves separador = insert(this.raiz, llave, obj, 1);

        if (separador == null) {
        } else {

            Nodo ptr = this.raiz;

            this.raiz =
                    new Nodo(this.llaveMinima, separador.getLlave(), separador.getDato());
            this.raiz.punteroNodo[0] = ptr;
            this.raiz.punteroNodo[1] = separador.getPuntero();
            this.alturaMinima++;
        }
    }

    protected insercionLlaves insert(Nodo node, Ordenable llave, Object obj, int level) {

        insercionLlaves separador = null;
        Nodo ptr = null;

        int i = 0;
        while ((i < node.baseMinimaRecorridoNodo) && (llave.mayorQue(node.llavesMinimasOrdenable[i])))
            i++;

        if ((i < node.baseMinimaRecorridoNodo) && llave.igualA(node.llavesMinimasOrdenable[i])) {
            node.datos[i] = obj;
            return null;
        }

        if (level < this.alturaMinima) {

            separador = insert(node.punteroNodo[i], llave, obj, level + 1);

            if (separador == null)
                return null;
            else {
                llave = separador.llaveMinima;
                obj = separador.dato;
                ptr = separador.punteroRaiz;
            }
        }

        i = node.baseMinimaRecorridoNodo - 1;
        while ((i >= 0) &&
               (node.llavesMinimasOrdenable[i] == null || llave.menorQue(node.llavesMinimasOrdenable[i]))) {
            node.llavesMinimasOrdenable[i + 1] = node.llavesMinimasOrdenable[i];
            node.datos[i + 1] = node.datos[i];
            node.punteroNodo[i + 2] = node.punteroNodo[i + 1];
            i--;
        }

        node.llavesMinimasOrdenable[i + 1] = llave;
        node.datos[i + 1] = obj;
        if (separador != null)
            node.punteroNodo[i + 2] = separador.punteroRaiz;
        node.baseMinimaRecorridoNodo++;

        if (node.baseMinimaRecorridoNodo > 2 * llaveMinima) {

            Nodo newnode = new Nodo(this.llaveMinima);
            newnode.punteroNodo[this.llaveMinima] = node.punteroNodo[node.baseMinimaRecorridoNodo];
            node.punteroNodo[node.baseMinimaRecorridoNodo] = null;
            node.baseMinimaRecorridoNodo = this.llaveMinima + 1;
            for (i = 0; i < this.llaveMinima; i++) {
                newnode.llavesMinimasOrdenable[i] = node.llavesMinimasOrdenable[i + node.baseMinimaRecorridoNodo];
                node.llavesMinimasOrdenable[i + node.baseMinimaRecorridoNodo] = null;
                newnode.datos[i] = node.datos[i + node.baseMinimaRecorridoNodo];
                node.datos[i + node.baseMinimaRecorridoNodo] = null;
                newnode.punteroNodo[i] = node.punteroNodo[i + node.baseMinimaRecorridoNodo];
                node.punteroNodo[i + node.baseMinimaRecorridoNodo] = null;
            }
            node.baseMinimaRecorridoNodo--;

            separador =
                    new insercionLlaves(newnode, node.llavesMinimasOrdenable[node.baseMinimaRecorridoNodo], node.datos[node.baseMinimaRecorridoNodo]);
            node.llavesMinimasOrdenable[node.baseMinimaRecorridoNodo] = null;
            node.datos[node.baseMinimaRecorridoNodo] = null;
            newnode.baseMinimaRecorridoNodo = this.llaveMinima;
            node.baseMinimaRecorridoNodo = this.llaveMinima;

            return separador;
        }

        return null;
    }

    public Object search(Ordenable llave) {
        return search(llave, raiz);
    }

    public Object search(Ordenable llave, Nodo node) {

        if ((node == null) || (node.baseMinimaRecorridoNodo < 1)) {
            System.err.println("error");
            return null;
        }

        if (llave.menorQue(node.llavesMinimasOrdenable[0]))
            return search(llave, node.punteroNodo[0]);

        if (llave.mayorQue(node.llavesMinimasOrdenable[node.baseMinimaRecorridoNodo - 1]))
            return search(llave, node.punteroNodo[node.baseMinimaRecorridoNodo]);

        int i = 0;
        while ((i < node.baseMinimaRecorridoNodo - 1) && (llave.mayorQue(node.llavesMinimasOrdenable[i])))
            i++;

        if (llave.igualA(node.llavesMinimasOrdenable[i]))
            return node.datos[i];
        

        return search(llave, node.punteroNodo[i]);

    }

    public int getAltura() {
        return alturaMinima;
    }
/*********************************************************************************************************************************************************
 *********************************************************************************************************************************************************
 ********************************************************************************************************************************************************/
 /**
 * RETORNA EL DOT DEL ARBOL_B 
 */
 public  String toDot(String nombreDot, String nombreImg) {
     
     StringBuilder b = new StringBuilder();
     b.append("digraph g { \n node [shape=record];\n");
        
     if(raiz!=null)
     {
        b.append(raiz.dotArbol_B()); 
     }
     else {System.out.println("arbol b esta vacio");}
     
      b.append("}");
                
        try {
            FileWriter f = new FileWriter(nombreDot + ".dot");
            f.write(b.toString());
            f.close();

            String salida = "dot -Tpng " + nombreDot + ".dot -o " + nombreImg + ".png";
            Runtime.getRuntime().exec(salida);
        } catch (Exception e) {
        }

        return b.toString();
    }    

 //#1 visualizar la informacion del libro pasos:
 //ingresar libro por isbn o nombre
 //buscar libro
 //mostrar libro. 
 //#2  
 
}
