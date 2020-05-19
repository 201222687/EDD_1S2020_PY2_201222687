/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_B;

/**
 *
 * @author MALDONADO
 */
public class MainB {

    public static  ArbolB arbolb = new ArbolB(2);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
  //(String referencia,long numeroFactura, String fecha, double total, String usuario, String titulo, String editorial, String edicion,String categoria,String idioma) {            
     
  
  
   arbolb.insert(new LlaveEntero("",6,"1999",201222687,"Escobar Wolf","Harry poter","20th Century","1","sagas","Aleman"),"");
   arbolb.insert(new LlaveEntero("",11,"",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",5,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",4,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",8,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",9,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",12,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",21,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",14,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",10,"d",4,"d","","","","",""),"");
   arbolb.insert(new LlaveEntero("",19,"1993",20122020,"jc","final","20th","1","feliz","espanol"),"");
   arbolb.insert(new LlaveEntero("",28,"1891",201222688,"ESCOBAR, DAVID","Curso de derecho constitucional","3M EspaÃ±a","2","Consulta","Español"),"");
   
   
   /*
   arbolb.insert(new LlaveEntero("",Integer.parseInt("6"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("11"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("5"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
    
   arbolb.insert(new LlaveEntero("",Integer.parseInt("4"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("8"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("9"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("12"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("21"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("14"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("10"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("19"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
   arbolb.insert(new LlaveEntero("",Integer.parseInt("28"),"10/5/20",Double.valueOf("8.9"), "juan"),Integer.parseInt("1") );        
   
    */   
    arbolb.toDot("arbolB","arbolB");
    
    //System.out.println(arbolb.search(new LlaveEntero("",19,"d",4,"d","","","","","")));    
    //System.out.println(arbolb.search(new LlaveEntero(28)));
    
    
    
    //System.out.println(s.getCategoría());   
    //System.out.println(arbolb.search(new LlaveEntero(30)));   
        
    //Object s = (String) arbolb.search(new LlaveEntero(19));
    //System.out.println(arbolb.search(new LlaveEntero(19)));
    //System.out.println(arbolb.search(new LlaveEntero(6)));        
    }
    
}
