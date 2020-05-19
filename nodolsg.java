/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lsgeneral;

/**
 *
 * @author MALDONADO
 */
public class nodolsg {
    
    private nodolsg siguiente;    
    private String ip;
    
    //para libros    
    private long isbn ;
    private String titulo;
    private String autor;
    private String editorial;    
    private String anio;
    private String edicion;
    private String categoria;
    private String idioma;
    private int carnet;
           
    
    
   public nodolsg(String ip){                
        this.ip=ip;        
        siguiente=null;
    }  
   
      public nodolsg(long isbn,String titulo, String autor , String editorial,String anio, String edicion, String categoria,String idioma, int carnet ){                
        this.isbn=isbn;  
        this.titulo=titulo; 
        this.autor=autor; 
        this.editorial=editorial; 
        this.anio=anio; 
        this.edicion=edicion; 
        this.categoria=categoria; 
        this.idioma=idioma; 
        this.carnet=carnet; 
        siguiente=null;
      }     
   
      

    /**
     * @return the siguiente
     */
    public nodolsg getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(nodolsg siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the isbn
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     * @return the carnet
     */
    public int getCarnet() {
        return carnet;
    }

    /**
     * @param carnet the carnet to set
     */
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

   

  

 
    
}
