/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author MALDONADO
 */
public class MainTH {

    /**
     * @param args the command line arguments
     */
    public static TablaHash tabla = new TablaHash();    
    public static ListaHash lista = new  ListaHash();
    
    public static void main(String[] args) {
        // TODO code application logic here
        tabla.insertar("20", "juan", "maldonado", "sistemas", "msms");
        tabla.insertar("33", "pedro", "Cordova", "industrial", "lslkad");
        tabla.insertar("21", "karla", "Estrada", "quimica", "iouie8");
        tabla.insertar("10", "karla", "Estrada", "quimica", "iouie8");
        tabla.insertar("12", "karla", "Estrada", "quimica", "iouie8");
        tabla.insertar("14", "encontradojuan", "encontrado maldo", "encontrado quimica", "encontrado iouie8");
        tabla.insertar("56", "karla1", "Estrada1", "quimica1", "iouie81");
        //tabla.insertar("56", "karla2", "Estrada2", "quimica2", "iouie82");
        tabla.insertar("100", "karla", "Estrada", "quimica", "iouie8");        
        tabla.insertar("70", "karla", "Estrada", "quimica", "iouie8"); 
        tabla.insertar("140", "karla", "Estrada", "quimica", "iouie8"); 
        tabla.crearDot();
        
        NodoHash s = tabla.getUsuariopy2("90");              
                
        //System.out.println(s);
        
        if(s!=null)
        {
        
        System.out.println("Usuario buscado.");
        System.out.println(s.getCodigoProducto());
        System.out.println(s.getNombre());//nombre
        System.out.println(s.getMarca());//apellido        
        System.out.println(s.getPrecio());//carrera
        System.out.println(s.getRutaImg());//password
                
        System.out.println("Usuario SE ESTA Modificado");
        System.out.println(s.getCodigoProducto());
        System.out.println(s.getNombre());//nombre
        System.out.println("nuevo apellido solorzano");
        s.setMarca("solorzano");//apellido    
        System.out.println(s.getPrecio());//carrera
        System.out.println(s.getRutaImg());//password
        
        System.out.println("Usuario YA Modificado");
        System.out.println(s.getCodigoProducto());
        System.out.println(s.getNombre());//nombre
        System.out.println(s.getMarca());//apellido        
        System.out.println(s.getPrecio());//carrera
        System.out.println(s.getRutaImg());//password
        
        }
        else
        {
         //NodoHash nodohashdels = s.getListaCodigoProductos().obtenernodols("56");         
         //nodohashdels.getCodigoProducto();         
         System.out.println("USUARIO NO ENCONTRADO POR MEDIO DE SU CARNET ");
        }
        
        //fin para obtener informacion en la tabla hash        
        //inicio prueba para eliminar usuario 
        //tabla.eliminaruserpy2("21");
        //tabla.eliminaruserpy2("14");
        //tabla.eliminaruserpy2("56");
        
        
        boolean n;
        n = tabla.eliminaruserpy2("70");
        if(n==true)
        {
            System.out.println("ECONTRADO");
        }
        else 
        {
            System.out.println("ENCONTRADO LS VERIFICAR");
        }
        
        
        /*
        
        n = tabla.eliminaruserpy2("100");
        if(n==true)
        {
            System.out.println("ECONTRADO");
        }
        else
        {
            System.out.println("NO ENCONTRADO");
        }
        
        
        n = tabla.eliminaruserpy2("10");
        if(n==true)
        {
            System.out.println("ECONTRADO");
        }
        else
        {
            System.out.println("NO ENCONTRADO");
        }
        
        n = tabla.eliminaruserpy2("33");
        if(n==true)
        {
            System.out.println("ECONTRADO");
        }
        else
        {
            System.out.println("NO ENCONTRADO");
        }
        */
        //tabla.eliminaruserpy2("12");
        
        //tabla.eliminaruserpy2("20");
        //tabla.eliminaruserpy2("70");
        
         tabla.crearDot();
        
        //-------------------------prueba de listahash individual
        /*
        NodoHash uno = new NodoHash("20", "juan", "mald1onado", "siste1mas", "msm1s",1);
        NodoHash dos = new NodoHash("10", "pedro", "maldon2ado", "siste2mas", "ms2ms",2);
        NodoHash tres = new NodoHash("30", "karla", "maldona3do", "sist3emas", "ms3ms",3);
        NodoHash cuatro = new NodoHash("40", "roberto", "maldo4nado", "sist4emas", "ms4ms",4);        
        NodoLista x1 = new NodoLista(uno);
        NodoLista x2 = new NodoLista(dos);
        NodoLista x3 = new NodoLista(tres);
        NodoLista x4 = new NodoLista(cuatro);        
        lista.insertar(x1);
        lista.insertar(x2);
        lista.insertar(x3);
        lista.insertar(x4);        
        lista.crearDotLH();
        */        
        //-------------------------prueba de listahash individual
    }    
}
