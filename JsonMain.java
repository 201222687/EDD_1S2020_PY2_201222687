/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;




/**
 *
 * @author MALDONADO
 */
public class JsonMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        
        
        try {
            
            Object obj = parser.parse(new FileReader("usuarios.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + jsonObject);
            
            JSONArray array = (JSONArray) jsonObject.get("Usuarios");
            System.out.println("");
            
            for(int i = 0 ; i < array.size() ; i++) {
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                
                System.out.println("DATOS DEL USUARIO: " + i);
                System.out.println("Carnet: " + jsonObject1.get("Carnet"));
                System.out.println("Nombre: " + jsonObject1.get("Nombre"));
                System.out.println("Apellido: " + jsonObject1.get("Apellido"));
                System.out.println("Carrera: " + jsonObject1.get("Carrera"));
                System.out.println("Password: " + jsonObject1.get("Password"));
                
                long Carnet =  (long) jsonObject1.get("Carnet");
                String Nombre = (String)jsonObject1.get("Nombre");
                String Apellido = (String)jsonObject1.get("Apellido");
                String Carrera = (String)jsonObject1.get("Carrera");
                String Password = (String)jsonObject1.get("Password");
                
                System.out.println("variables "+" "+Carnet+" "+Nombre+" "+Apellido+" "+ Carrera+" "+Password+" ");
                
                
                System.out.println("");
            }
            
        } catch(FileNotFoundException e) { }
        catch(IOException e) { }
        catch(ParseException e) { }
        
        
    }
    
}
